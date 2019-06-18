<template>
  <div class="page-container">
    <!--工具栏-->
    <div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
      <el-form :inline="true" :model="filters" :size="size">
        <el-form-item>
          <el-input v-model="filters.name" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item>
          <kt-button icon="fa fa-search" :label="$t('action.search')" perms="sys:dept:view" type="primary"
                     @click="findTreeData(null)"/>
        </el-form-item>
        <el-form-item>
          <kt-button icon="fa fa-plus" :label="$t('action.add')" perms="sys:dept:add" type="primary"
                     @click="handleAdd"/>
        </el-form-item>
      </el-form>
    </div>
    <!--表格树内容栏-->
    <el-table :data="tableTreeDdata" stripe size="mini" style="width: 100%;" v-loading="loading" row-key="id"
              element-loading-text="$t('action.loading')">
      <el-table-column prop="id" header-align="center" align="center" width="80" label="ID">
      </el-table-column>
      <table-tree-column prop="name" header-align="center" treeKey="id" width="150" label="名称">
      </table-tree-column>
      <el-table-column prop="sort" header-align="center" align="center" label="排序">
      </el-table-column>
      <el-table-column prop="factoryStatus" header-align="center" align="center" label="品牌厂商">
      </el-table-column>
      <el-table-column prop="showStatus" header-align="center" align="center" label="是否展示">
      </el-table-column>
      <el-table-column prop="productCount" header-align="center" align="center" label="产品数量">
      </el-table-column>
      <el-table-column prop="logo" header-align="center" align="center" label="产品logo">
        <template slot-scope="scope">
          <img :src="scope.row.logo" width="100" height="50"/>
        </template>
      </el-table-column>
      <el-table-column fixed="right" header-align="center" align="center" width="185" :label="$t('action.operation')">
        <template slot-scope="scope">
          <kt-button icon="fa fa-edit" :label="$t('action.edit')" perms="sys:dept:edit" @click="handleEdit(scope.row)"/>
          <kt-button icon="fa fa-trash" :label="$t('action.delete')" perms="sys:dept:delete" type="danger"
                     @click="handleDelete(scope.row)"/>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background @current-change="handleCurrentChange" layout="total, prev, pager, next"
                   :total="totalSize">
    </el-pagination>
    <!-- 新增修改界面 -->
    <el-dialog :title="!dataForm.id ? '新增' : '修改'" width="40%" :visible.sync="dialogVisible"
               :close-on-click-modal="false">
      <el-form :model="dataForm" ref="dataForm" @keyup.enter.native="submitForm()" label-width="80px"
               :size="size" style="text-align:left;">
        <el-form-item label="名称" prop="name">
          <el-input v-model="dataForm.name" placeholder="名称"></el-input>
        </el-form-item>

        <el-form-item label="首字母" prop="firstLetter">
          <el-input v-model="dataForm.firstLetter" placeholder="首字母"></el-input>
        </el-form-item>
        <el-form-item label="是否展示" prop="showStatus">
          <el-input v-model="dataForm.showStatus" placeholder="是否展示"></el-input>
        </el-form-item>
        <el-form-item label="商品数量" prop="productCount">
          <el-input v-model="dataForm.productCount" placeholder="商品数量"></el-input>
        </el-form-item>
        <el-form-item label="品牌厂商" prop="factoryStatus">
          <el-input v-model="dataForm.factoryStatus" placeholder="是否品牌厂商"></el-input>
        </el-form-item>
        <el-form-item label="品牌故事" prop="brandStory">
          <textarea v-model="dataForm.brandStory" placeholder="品牌故事"></textarea>
        </el-form-item>
        <el-form-item label="商品logo" prop="logo">
          <el-upload class="upload-demo" action="/file/uploadImg" :on-preview="handlePreview"
                     :on-success="handleSuccess"
                     :on-remove="handleRemove" :before-remove="beforeRemove" multiple :limit="3"
                     :on-exceed="handleExceed" :file-list="fileList">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
				<el-button :size="size" @click="dialogVisible = false">{{$t('action.cancel')}}</el-button>
				<el-button :size="size" type="primary" @click="submitForm()">{{$t('action.comfirm')}}</el-button>
			</span>
    </el-dialog>
  </div>
</template>

<script>
  import KtButton from "@/views/Core/KtButton"
  import TableTreeColumn from '@/views/Core/TableTreeColumn'
  import PopupTreeInput from "@/components/PopupTreeInput"
  import FaIconTooltip from "@/components/FaIconTooltip"
  import {
    format
  } from "@/utils/datetime"

  export default {
    components: {
      PopupTreeInput,
      KtButton,
      TableTreeColumn,
      FaIconTooltip
    },
    data() {
      return {
        pageRequest: {
          pageNum: 1,
          pageSize: 10
        },
        totalSize: 0,
        size: 'small',
        loading: false,
        filters: {
          name: ''
        },
        tableTreeDdata: [],
        dialogVisible: false,
        dataForm: {
          id: 0,
          name: '',
          firstLetter: 0,
          sort: 0,
          productCount: 0,
          factoryStatus: 0,
          showStatus: 0,
          brandStory: '',
          logo: ''
        },
        fileList: [{
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
        },
          {
            name: 'food2.jpeg',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
          }]

      }
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      handleSuccess(response) {
        console.log(response);
        this.dataForm.logo = response;
      },
      //点击下一页和点击页码时执行
      handleCurrentChange(val) {
        this.pageRequest.pageNum = val;
        this.findTreeData();

      },

      // 获取数据
      findTreeData: function () {
        this.loading = true
        var params = new URLSearchParams();
        params.append("currentPage", this.pageRequest.pageNum);
        params.append("pageSize", this.pageRequest.pageSize);
        params.append("name", this.filters.name);
        //this.$axios.post("http://129.28.172.154:8080/dept/findTree",params)
        this.$axios.post("http://129.28.172.154:8080/pmsBrand/listPmsBrandByPage", params).then((res) => {
          console.log(res);
          this.tableTreeDdata = res.data.data.content
          this.totalSize = res.data.data.totalSize;
          this.loading = false
        })
      },

      // 显示新增界面
      handleAdd: function () {
        this.dialogVisible = true
        this.dataForm = {
          id: 0,
          name: '',
          parentId: 0,
          parentName: '',
          orderNum: 0
        }
      },
      // 显示编辑界面
      handleEdit: function (row) {
        this.dialogVisible = true
        Object.assign(this.dataForm, row);
      },
      // 删除
      handleDelete(row) {
        this.$confirm('确认删除选中记录吗？', '提示', {
          type: 'warning'
        }).then(() => {
          let params = this.getDeleteIds([], row)
          this.$api.productType.deletes(params).then(res => {
            this.findTreeData()
            this.$message({
              message: '删除成功',
              type: 'success'
            })
          })
        })
      },
      // 获取删除的包含子机构的id列表
      getDeleteIds(ids, row) {
        //ids.push({id:row.id})
        ids.push(row.id);
        if (row.children != null) {
          for (let i = 0, len = row.children.length; i < len; i++) {
            this.getDeleteIds(ids, row.children[i])
          }
        }
        return ids.join(',');
      },
      // 机构树选中
      handleTreeSelectChange(data, node) {
        if (data.level == 0) {
          this.dataForm.parentId = 0
        } else {
          this.dataForm.parentId = data.id
          this.dataForm.level = 1
        }
        this.dataForm.parentName = data.name
      },
      // 表单提交
      submitForm() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true
              let params = Object.assign({}, this.dataForm)
              console.log(params.toString());
              this.$api.brands.save(params).then((res) => {
                this.editLoading = false
                if (res.code == 200) {
                  this.$message({
                    message: '操作成功',
                    type: 'success'
                  })
                  this.dialogVisible = false
                  this.$refs['dataForm'].resetFields()
                } else {
                  this.$message({
                    message: '操作失败, ' + res.msg,
                    type: 'error'
                  })
                }
                this.findTreeData()
              })
            })
          }
        })
      },
      // 时间格式化
      dateFormat: function (row, column, cellValue, index) {
        return format(row[column.property])
      }

    },
    mounted() {
      this.findTreeData()
    }
  }
</script>

<style scoped>

</style>
