<template>
	<el-container>
		<el-main>
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
				prop="name"
				label="姓名"
				>
			  </el-table-column>
			  <el-table-column
				prop="email"
				label="地址">
			  </el-table-column>
			  <el-table-column
				prop="mobile"
				label="联系方式">
			  </el-table-column>
			  <el-table-column
				prop="createBy"
				label="创建人">
			  </el-table-column>
			  <el-table-column
					prop="createTime"
					label="创建时间"
					width="300">
				  </el-table-column>
				  <el-table-column label="操作" width="200">
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
			  
			<el-dialog title="编辑信息" :visible.sync="dialogTableVisible">
			 <el-form :model="dataForm">
				<el-form-item label="姓名" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.name" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="密码" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.password" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="机构" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.deptName" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="邮箱" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.email" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="手机" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.mobile" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="角色" :label-width="formLabelWidth">
				  <el-input v-model="dataForm.userRoles" autocomplete="off"></el-input>
				</el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
			  </div>
			</el-dialog>
	
	</el-main>
	</el-container>
		
</template>

<script>
export default {
	created(){
		
	},
	mounted(){
		this.findPage();
	}
	,
	 data() {
        return {
		  dialogTableVisible:false,
          size: 'small',
          filters: {
          	name: ''
          },
          columns: [],
          filterColumns: [],
          pageRequest: { pageNum: 1, pageSize: 10 },
          tableData: [],
          
          operation: false, // true:新增, false:编辑
          dialogVisible: false, // 新增编辑界面是否显示
          editLoading: false,
          dataFormRules: {
          	name: [
          		{ required: true, message: '请输入用户名', trigger: 'blur' }
          	]
          },
          // 新增编辑界面数据
          dataForm: {
          	id: 0,
          	name: '',
          	password: '123456',
          	deptId: 1,
          	deptName: '',
          	email: 'test@qq.com',
          	mobile: '13889700023',
          	status: 1,
          	userRoles: []
          },
		  formLabelWidth: '120px',
          deptData: [],
          deptTreeProps: {
          	label: 'name',
          	children: 'children'
          },
          roles: [],
		  total:0
        }
      },
	  methods:{
		  
		  //点击下一页和点击页码时执行
		  handleCurrentChange(val) {
		
			this.pageRequest.pageNum=val;
			this.findPage();
		  },

		  // 获取分页数据
		  findPage() {
		  	var params = new URLSearchParams();
			params.append("currentPage",this.pageRequest.pageNum);
			params.append("rows",this.pageRequest.pageSize);
		  	this.$axios.post("http://localhost:8080/user/findList",params).then((res) => {
				this.tableData=res.data.rows;
				this.total=res.data.total;
		  		//this.pageResult = res.data
		  		//this.findUserRoles()
		  	})
		  },
		  handleEdit(index, row) {
			console.log(index, row);
			this.dialogTableVisible=true;
			console.log(row);
			this.dataForm.id=row.id;
			this.dataForm.password=row.password;
			this.dataForm.deptName=row.depId;
			this.dataForm.email=row.email;
			this.dataForm.mobile=row.mobile;
			this.dataForm.userRoles=row.userRoles;
			this.dataForm.name=row.name;
		  },
		  handleDelete(index, row) {
			console.log(index, row);
		  }
	  }
}
</script>

<style>
</style>
