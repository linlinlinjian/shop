<template>
  <div class="page-container">
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
          prop="name"
          label="优惠券名称"
        >
        </el-table-column>
        <el-table-column
          prop="type"
          label="类型" :formatter="typeFormatter">
        </el-table-column>

        <el-table-column
          prop="useType"
          label="使用类型" :formatter="useTypeFormatter">
        </el-table-column>

        <el-table-column
          prop="count"
          label="数量">
        </el-table-column>
        <el-table-column
          prop="amount"
          label="金额">
        </el-table-column>
        <el-table-column
          prop="perLimit"
          label="限领">
        </el-table-column>
        <el-table-column
          prop="useCount"
          label="已用">
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
      <!--优惠券编辑-->
      <el-dialog title="优惠券" :visible.sync="dialogFormVisible">
        <el-form :model="editForm" ref="editForm" style="text-align:left;" >
          <el-form-item label="优惠券名称" :label-width="formLabelWidth">
            <el-input v-model="editForm.name" autocomplete="off" :label-width="formLabelWidth"></el-input>
          </el-form-item>
          <el-form-item  label="使用类型" :label-width="formLabelWidth">
            <el-select v-model="editForm.useType" placeholder="请选择使用类型">
              <el-option label="全场通用" value="0"></el-option>
              <el-option label="指定分类" value="1"></el-option>
              <el-option label="指定商品" value="2"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="editForm.useType=='1'" prop="useType" label="选择分类" :label-width="formLabelWidth">
              <el-cascader style="width:480px"
                   v-model="selectProductCateValue"
                   :options="productCateOptions">
              </el-cascader>
          </el-form-item>
          <el-form-item prop="proId" v-if="editForm.useType=='2'" label="选择商品" :label-width="formLabelWidth">
            <el-select v-model="editForm.proId" placeholder="请选择商品">
              <el-option
                v-for="item in productLists"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="优惠券类型" prop="type" :label-width="formLabelWidth">
            <el-select v-model="editForm.type" placeholder="请选择优惠券类型">
              <el-option label="全场赠券" value="0"></el-option>
              <el-option label="会员赠券" value="1"></el-option>
              <el-option label="购物赠券" value="2"></el-option>
              <el-option label="注册赠券" value="3"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="开始时间" :label-width="formLabelWidth">
            <el-date-picker
              v-model="editForm.startTime"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间" :label-width="formLabelWidth">
          <el-date-picker
            v-model="editForm.endTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
          </el-form-item>
          <el-form-item label="优惠券数量" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.count" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="优惠券金额" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.amount" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="限领数量" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.perLimit" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="使用门槛" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.minPoint" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="发行数量" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.publishCount" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="已使用数量" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.useCount" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="领取数量" :label-width="formLabelWidth">
            <el-input-number v-model="editForm.receiveCount" controls-position="right" :min="0" label="优惠券数量"></el-input-number>
          </el-form-item>
          <el-form-item label="领取日期" :label-width="formLabelWidth">
            <el-input v-model="editForm.enableTime" ></el-input>
          </el-form-item>
          <el-form-item label="优惠码" :label-width="formLabelWidth">
            <el-input v-model="editForm.code" ></el-input>
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
        name: "Coupon",
        data() {
          return {
            size: 'small',
            productLists:[],
            //选中商品分类的值
            selectProductCateValue: [],
            productCateOptions: [],
            selectName:'',
            isEdit:false,
            hackReset:false,
            pageRequest: { pageNum: 1, pageSize: 10 },
            tableData: [],
            operation: false, // true:新增, false:编辑
            dialogVisible: false, // 新增编辑界面是否显示
            editLoading: false,
            total:0,
            dialogFormVisible: false,
            formLabelWidth: '120px',
            editForm:{
              id:0,
              name:'',
              type:0,
              count:0,
              amount:0,
              perLimit:1,
              minPoint:0,
              startTime:'',
              endTime:'',
              useType:'',
              note:'',
              publishCount:0,
              useCount:0,
              receiveCount:0,
              enableTime:'',
              code:'',
              memberLevel:0,
              cateProId:0,
              cateProName:'',
              cateParName:'',
              proId:0,
              proName:''
            },
          }
        },
      mounted() {
          this.requestData();
          this.findTreeData();
          this.listProduct();
      },
      methods:{
        listProduct() {
          var params = new URLSearchParams();
          params.append("currentPage",-1);
          params.append("pageSize",-1);
          this.$axios.post("http://129.28.172.154:8080/pmsProduct/listPmsProductByPage",params).then((res) => {
            this.productLists = res.data.data.content
          })
        },
        findTreeData() {
          var params = new URLSearchParams();
          params.append("currentPage",-1);
          params.append("pageSize",-1);
          this.$axios.post("http://129.28.172.154:8080/pmsProductCategory/listPmsProductCategoryByPage",params).then((res) => {
            let list = res.data.data.content;
            this.productCateOptions = [];
            for (let i = 0; i < list.length; i++) {
              let children = [];
              if (list[i].children != null && list[i].children.length > 0) {
                for (let j = 0; j < list[i].children.length; j++) {
                  children.push({label: list[i].children[j].name, value: list[i].children[j].id});
                }
              }
              this.productCateOptions.push({label: list[i].name, value: list[i].id, children: children});
            }

          })
        },
        useTypeFormatter(row,column){
          //0->全场通用；1->指定分类；2->指定商品
          var value="";
          if(row.useType==0){
            value="全场通用";
          }else if(row.useType==1){
            value="指定分类";
          }else{
            value="指定商品";
          }
          return value;
        },
        typeFormatter(row,column){
          var value="";
          //0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
          if(row.type==0){
            value='全场赠券';
          }else if(row.type==1){
            value='会员赠券';
          }else if(row.type==2){
            value='购物赠券';
          }else{
            value='注册赠券';
          }
          return value;
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
          this.$axios.post("http://129.28.172.154:8080/smsCoupon/listSmsCouponByPage", params).then(response => {
            console.log(response)
              this.tableData=response.data.data.content;
              this.total=response.data.data.totalSize;
          });
        },
        handleAdd(){
          this.editForm={
            id:0,
              name:'',
              type:0,
              count:0,
              amount:0,
              perLimit:1,
              minPoint:0,
              startTime:'',
              endTime:'',
              useType:'',
              note:'',
              publishCount:0,
              useCount:0,
              receiveCount:0,
              enableTime:'',
              code:'',
              memberLevel:0,
              cateProId:0,
              cateProName:'',
              cateParName:'',
              proId:0,
              proName:''
          }
          this.dialogFormVisible=true;
          this.isEdit=false;
        },
        handleEdit(index,row){

            this.dialogFormVisible=true;
            this.isEdit=true;
            this.editForm=row;
        },
        handleDelete(index,row){
          var params=new URLSearchParams();
          params.append("id",row.id);
          this.$axios.post("http://129.28.172.154:8080/smsCoupon/deleteSmsCoupon", params).then(response => {
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
        clearData(){
          var data=this.editForm;
          for(var a in data){
            data[a]=[];
          }
          return data;
        },
        submitForm(){
          let params = Object.assign({}, this.editForm);
          if(this.isEdit==true){
            this.$axios.post("http://129.28.172.154:8080/smsCoupon/updateSmsCoupon", params).then(response => {
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
            this.$axios.post("http://129.28.172.154:8080/smsCoupon/insertSmsCoupon", params).then(response => {
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

        }
      }
    }
</script>

<style scoped>

</style>
