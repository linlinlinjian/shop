<template>
  <div class="page-container">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.name" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button icon="fa fa-search" :label="$t('action.search')" perms="sys:dept:view" type="primary" @click="findTreeData(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button icon="fa fa-plus" :label="$t('action.add')" perms="sys:dept:add" type="primary" @click="handleAdd"/>
			</el-form-item>
		</el-form>
	</div>
	<!--表格树内容栏-->
    <el-table :data="tableTreeDdata" stripe size="mini" style="width: 100%;"
      v-loading="loading" row-key="id" element-loading-text="$t('action.loading')">
      <el-table-column
        prop="id" header-align="center" align="center" width="80" label="ID">
      </el-table-column>
      <table-tree-column 
        prop="name" header-align="center" treeKey="id" width="150" label="名称">
      </table-tree-column>
      <el-table-column 
        prop="parentName" header-align="center" align="center" width="120" label="上级分类">
      </el-table-column>
      <el-table-column
        prop="sort" header-align="center" align="center" label="排序">
      </el-table-column>
      <el-table-column
        prop="keywords" header-align="center" align="center" label="关键词">
      </el-table-column>
      <el-table-column
        prop="description" header-align="center" align="center" label="描述">
      </el-table-column>
      <el-table-column
        fixed="right" header-align="center" align="center" width="185" :label="$t('action.operation')">
        <template slot-scope="scope">
          <kt-button icon="fa fa-edit" :label="$t('action.edit')" perms="sys:dept:edit" @click="handleEdit(scope.row)"/>
          <kt-button icon="fa fa-trash" :label="$t('action.delete')" perms="sys:dept:delete" type="danger" @click="handleDelete(scope.row)"/>
        </template>
      </el-table-column>
    </el-table>
		<el-pagination
			background
			@current-change="handleCurrentChange"
			layout="total, prev, pager, next"
			:total="totalSize">
		  </el-pagination>
    <!-- 新增修改界面 -->
    <el-dialog :title="!dataForm.id ? '新增' : '修改'" width="40%" :visible.sync="dialogVisible" :close-on-click-modal="false">
      <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="submitForm()" 
        label-width="80px" :size="size" style="text-align:left;">
        <el-form-item label="名称" prop="name">
          <el-input v-model="dataForm.name" placeholder="名称"></el-input>
        </el-form-item>
		<el-form-item :label="dataForm.level==0 ? '顶级分类' : '一级分类'" prop="level">
		  <el-input v-model="dataForm.level"  placeholder="分类级别"></el-input>
		</el-form-item>
        <el-form-item label="上级分类" prop="parentName">
            <popup-tree-input 
              :data="popupTreeData" :props="popupTreeProps" :prop="dataForm.parentName==null?'顶级分类':dataForm.parentName" 
              :nodeKey="''+dataForm.parentId" :currentChangeHandle="handleTreeSelectChange">
            </popup-tree-input>
        </el-form-item>
        <el-form-item v-if="dataForm.type !== 2" label="排序编号" prop="sort">
          <el-input-number v-model="dataForm.sort" controls-position="right" :min="0" label="排序编号"></el-input-number>
        </el-form-item>
		<el-form-item label="导航栏展示" prop="navStatus">
		  <el-input v-model="dataForm.navStatus"  placeholder="导航栏展示"></el-input>
		</el-form-item>
		<el-form-item label="是否展示" prop="showStatus">
		  <el-input v-model="dataForm.showStatus"  placeholder="是否展示"></el-input>
		</el-form-item>
		<el-form-item label="商品数量" prop="productCount">
		  <el-input v-model="dataForm.productCount"  placeholder="商品数量"></el-input>
		</el-form-item>
		<el-form-item label="商品单位" prop="productUnit">
		  <el-input v-model="dataForm.productUnit" placeholder="商品单位"></el-input>
		</el-form-item>
	  <el-form-item label="关键词" prop="keywords">
		<el-input v-model="dataForm.keywords" placeholder="商品关键词"></el-input>
	  	</el-form-item>
	   <el-form-item label="商品描述" prop="description">
	  		<el-input v-model="dataForm.description"  placeholder="商品描述"></el-input>
	  		</el-form-item>
	  </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button :size="size"  @click="dialogVisible = false">{{$t('action.cancel')}}</el-button>
        <el-button :size="size"  type="primary" @click="submitForm()">{{$t('action.comfirm')}}</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import KtButton from "@/views/Core/KtButton"
import TableTreeColumn from '@/views/Core/TableTreeColumn'
import PopupTreeInput from "@/components/PopupTreeInput"
import FaIconTooltip from "@/components/FaIconTooltip"
import { format } from "@/utils/datetime"
export default {
	components:{
    PopupTreeInput,
    KtButton,
    TableTreeColumn,
    FaIconTooltip
	},
	data() {
		return {
			pageRequest: { pageNum: 1, pageSize: 10 },
			totalSize:0,
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
        parentId: 0,
        parentName: '',
        sort: 0,
		productCount:0,
		productUnit:'',
		keywords:'',
		description:'',
		navStatus:0,
		showStatus:0,
		level:0
      },
      dataRule: {
        name: [
          { required: true, message: '名称不能为空', trigger: 'blur' }
        ],
        parentName: [
          { required: true, message: '上级不能为空', trigger: 'change' }
        ]
      },
      popupTreeData: [],
      popupTreeProps: {
				label: 'name',
				children: 'children'
			}
		}
	},
	methods: {
		//点击下一页和点击页码时执行
		handleCurrentChange(val) {
			this.pageRequest.pageNum=val;
			this.findTreeData();
		},
		
		// 获取数据
    findTreeData: function () {
      this.loading = true
			var params = new URLSearchParams();
			params.append("currentPage",this.pageRequest.pageNum);
			params.append("pageSize",this.pageRequest.pageSize);
			params.append("name",this.filters.name);
			//this.$axios.post("http://localhost:8080/dept/findTree",params)
			this.$axios.post("http://localhost:8080/pmsProductCategory/listPmsProductCategoryByPage",params).then((res) => {
				console.log(res);
        this.tableTreeDdata = res.data.data.content
        this.popupTreeData = this.getParentMenuTree(res.data.data.content)
				this.totalSize=res.data.data.totalSize;
        this.loading = false
			})
    },
		// 获取上级机构树
    getParentMenuTree: function (tableTreeDdata) {
      let parent = {
        parentId: 0,
        name: '顶级分类',
        children: tableTreeDdata
      }
      return [parent]
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
    handleDelete (row) {
      this.$confirm('确认删除选中记录吗？', '提示', {
				type: 'warning'
      }).then(() => {
        let params = this.getDeleteIds([], row)
        this.$api.productType.deletes(params).then( res => {
          this.findTreeData()
          this.$message({message: '删除成功', type: 'success'})
        })
      })
    },
    // 获取删除的包含子机构的id列表
    getDeleteIds (ids, row) {
      //ids.push({id:row.id})
	  ids.push(row.id);
      if(row.children != null) {
        for(let i=0, len=row.children.length; i<len; i++) {
          this.getDeleteIds(ids, row.children[i])
        }
      }
      return ids.join(',');
    },
      // 机构树选中
    handleTreeSelectChange (data, node) {
	  if(data.level==0){
		   this.dataForm.parentId = 0
	  }else{
		  this.dataForm.parentId = data.id
		  this.dataForm.level=1
	  }
      this.dataForm.parentName = data.name
    },
    // 表单提交
    submitForm () {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
			this.$confirm('确认提交吗？', '提示', {}).then(() => {
				this.editLoading = true
				let params = Object.assign({}, this.dataForm)
				console.log(params.toString());
				this.$api.productType.save(params).then((res) => {
				  this.editLoading = false
				  if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
					this.dialogVisible = false
					this.$refs['dataForm'].resetFields()
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.findTreeData()
							})
						})
					}
			})
    },
		// 时间格式化
    dateFormat: function (row, column, cellValue, index){
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
