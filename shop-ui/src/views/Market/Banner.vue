<template>
<div>
  <el-row >
    <el-col :span="4">
      <el-input v-model="selectName"></el-input>
    </el-col>
    <el-col :span="20">
      <el-button type="primary" size="small" style="margin: 3px 0px 0px 10px;float: left" @click="requestData">查询</el-button>
      <el-button type="primary" size="small" style="margin: 3px 0px 0px 20px;float: left" @click="handleAdd">新增</el-button>
    </el-col>
  </el-row>
  <el-row>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="id"
        width="80"
      >
      </el-table-column>
      <el-table-column
        prop="title"
        label="banner标题"
      >
      </el-table-column>
      <el-table-column
        prop="content"
        label="描述" >
      </el-table-column>

      <el-table-column
        prop="imgUrl"
        label="图片" >
        <template slot-scope="scope">
          <img :src="scope.row.imgUrl" width="80px" height="60px">
        </template>
      </el-table-column>

      <el-table-column
        prop="sort"
        label="排序">
      </el-table-column>
      <el-table-column
        prop="types"
        label="链接">
      </el-table-column>
      <el-table-column
        prop="relationId"
        label="链接名称">
      </el-table-column>
      <el-table-column
        prop="isRedirect"
        label="是否跳转">
      </el-table-column>
      <el-table-column label="操作" align="center" width="200">
        <template slot-scope="scope" >
          <el-button
            size="mini" class="el-icon-edit"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            class="el-icon-delete"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      @current-change="handleCurrentChange"
      layout="total, prev, pager, next"
      :total="total">
    </el-pagination>
  </el-row>
  <!--banner编辑-->
  <el-dialog title="Banner" :visible.sync="dialogFormVisible">
    <el-form :model="editForm" ref="editForm" style="text-align:left;" >
      <el-form-item label="标题" :label-width="formLabelWidth">
        <el-input v-model="editForm.title" autocomplete="off" :label-width="formLabelWidth"></el-input>
      </el-form-item>
      <el-form-item label="是否跳转链接" prop="isRedirect" :label-width="formLabelWidth">
        <el-select v-model="editForm.isRedirect">
          <el-option label="是" value="0"></el-option>
          <el-option label="否" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="跳转类型" prop="type" :label-width="formLabelWidth">
        <el-select v-model="editForm.types">
          <el-option label="分类" value="0"></el-option>
          <el-option label="商品" value="1"></el-option>
          <el-option label="活动" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="排序" :label-width="formLabelWidth">
        <el-input-number v-model="editForm.sort" controls-position="right"></el-input-number>
      </el-form-item>
      <el-form-item label="图片" :label-width="formLabelWidth">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:8080/file/uploadImg"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="editForm.imgUrl" :src="editForm.imgUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>

    </el-form>
    <div slot="footer" style="text-align: center" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="submitForm">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
    export default {
        name: "Banner",
        data() {
          return {
            size: 'small',
            selectName:'',
            isEdit: false,
            hackReset: false,
            pageRequest: {pageNum: 1, pageSize: 10},
            tableData: [],
            operation: false, // true:新增, false:编辑
            dialogVisible: false, // 新增编辑界面是否显示
            editLoading: false,
            total: 0,
            dialogFormVisible: false,
            formLabelWidth: '120px',
            editForm: {
              id: 0,
              title: '',
              content: '',
              imgUrl: '',
              sort: '',
              createTime: '',
              types: '',
              relationId: 0,
              isRedirect: ''
            },
          }
        },
        mounted() {
          this.requestData();
        },
      methods:{
        submitForm(){
          let params = Object.assign({}, this.editForm);
          if(this.isEdit==true){
            this.$axios.post("http://localhost:8080/pmsBanner/updatePmsBanner", params).then(response => {
              if(response.data.code==200){
                this.$message({
                  message: ''+response.data.msg+'',
                  type: 'success'
                });
                this.dialogFormVisible=false;
                this.requestData();
              }else{
                this.$message.error('修改失败');
              }

            });
          }else{
            this.$axios.post("http://localhost:8080/pmsBanner/insertPmsBanner", params).then(response => {
              if(response.data.code==200){
                this.$message({
                  message: ''+response.data.msg+'',
                  type: 'success'
                });
                this.dialogFormVisible=false;
                this.requestData();
              }else{
                this.$message.error('新增失败');
              }

            });
          }
          },
        handleAdd(){
          this.editForm={
            title: '',
            content: '',
            imgUrl: '',
            sort: '',
            createTime: '',
            types: '',
            relationId: '',
            isRedirect: ''
          };
          this.dialogFormVisible=true;
          this.isEdit=false;
        },
        handleAvatarSuccess(res, file) {
          console.log(res);
          this.editForm.imgUrl = res;
        },
        beforeAvatarUpload(file) {
          const isJPG = file.type === 'image/jpeg';
          const isLt2M = file.size / 1024 / 1024 < 2;

          if (!isJPG) {
            this.$message.error('上传图片只能是 JPG 格式!');
          }
          if (!isLt2M) {
            this.$message.error('上传图片大小不能超过 2MB!');
          }
          return isJPG && isLt2M;
        },

        handleSizeChange(val) {
          this.pageRequest.pageNum = 1;
          this.pageRequest.pageSize = val;
          this.requestData();
        },
        handleCurrentChange(val) {
          this.pageRequest.pageNum = val;
          this.requestData();
        },
        checkParam(){
          var params=new URLSearchParams();
          params.append("currentPage",this.pageRequest.pageNum);
          params.append("pageSize",this.pageRequest.pageSize);
          params.append("name",this.selectName);
          return params;
        },
        requestData(){
          var params=this.checkParam();
          this.$axios.post("http://localhost:8080/pmsBanner/listPmsBannerByPage", params).then(response => {
            console.log(response)
            this.tableData=response.data.data.content;
            this.total=response.data.data.totalSize;
          });
        },
        handleEdit(index,row){

          this.dialogFormVisible=true;
          this.isEdit=true;
          this.editForm=row;
        },
        handleDelete(index,row){
          var params=new URLSearchParams();
          params.append("id",row.id);
          this.$axios.post("http://localhost:8080/pmsBanner/deletePmsBanner", params).then(response => {
            if(response.data.code==200){
              this.$message({
                message: ''+response.data.msg+'',
                type: 'success'
              });
              this.requestData();
            }else{
              this.$message.error('删除失败');
            }

          });
        },
      },

    }
</script>

<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
