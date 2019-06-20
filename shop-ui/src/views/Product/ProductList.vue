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
      <el-table-column type="selection" width="60" align="center"></el-table-column>
      <el-table-column label="编号" width="100" align="center">
        <template slot-scope="scope">{{scope.row.id}}</template>
      </el-table-column>
      <el-table-column label="商品图片" width="120" align="center">
        <template slot-scope="scope"><img style="height: 80px" :src="scope.row.pic"></template>
      </el-table-column>
      <el-table-column label="商品名称" align="center">
        <template slot-scope="scope">
          <p>{{scope.row.name}}</p>
          <p>品牌：{{scope.row.brandName}}</p>
        </template>
      </el-table-column>
      <el-table-column label="价格/货号" width="120" align="center">
        <template slot-scope="scope">
          <p>价格：￥{{scope.row.price}}</p>
          <p>货号：{{scope.row.productSn}}</p>
        </template>
      </el-table-column>
      <el-table-column label="标签" width="140" align="center">
        <template slot-scope="scope">
          <p>上架：
            <el-switch
              @change="handlePublishStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.publishStatus">
            </el-switch>
          </p>
          <p>新品：
            <el-switch
              @change="handleNewStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.newStatus">
            </el-switch>
          </p>
          <p>推荐：
            <el-switch
              @change="handleRecommendStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.recommandStatus">
            </el-switch>
          </p>
        </template>
      </el-table-column>
      <el-table-column label="排序" width="100" align="center">
        <template slot-scope="scope">{{scope.row.sort}}</template>
      </el-table-column>
      <el-table-column label="SKU库存" width="100" align="center">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" @click="handleShowSkuEditDialog(scope.$index, scope.row)" circle></el-button>
        </template>
      </el-table-column>
      <el-table-column label="销量" width="100" align="center">
        <template slot-scope="scope">{{scope.row.sale}}</template>
      </el-table-column>
      <el-table-column label="审核状态" width="100" align="center">
        <template slot-scope="scope">
          <p>{{scope.row.verifyStatus | verifyStatusFilter}}</p>
          <p>
            <el-button
              type="text"
              @click="handleShowVerifyDetail(scope.$index, scope.row)">审核详情
            </el-button>
          </p>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="160" align="center">
        <template slot-scope="scope">
          <p>
            <el-button
              size="mini"
              @click="handleShowProduct(scope.$index, scope.row)">查看
            </el-button>
            <el-button
              size="mini"
              @click="handleUpdateProduct(scope.$index, scope.row)">编辑
            </el-button>
          </p>
          <p>
            <el-button
              size="mini"
              @click="handleShowLog(scope.$index, scope.row)">日志
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </p>
        </template>
      </el-table-column>
    </el-table>
		<el-pagination
			background
			@current-change="handleCurrentChange"
			layout="total, prev, pager, next"
			:total="totalSize">
		  </el-pagination>
     <el-dialog
      title="编辑货品信息"
      :visible.sync="editSkuInfo.dialogVisible"
      width="40%">
      <span>商品货号：</span>
      <span>{{editSkuInfo.productSn}}</span>
      <el-input placeholder="按sku编号搜索" v-model="editSkuInfo.keyword" size="small" style="width: 50%;margin-left: 20px">
        <el-button slot="append" icon="el-icon-search" @click="handleSearchEditSku"></el-button>
      </el-input>
      <el-table style="width: 100%;margin-top: 20px"
                :data="editSkuInfo.stockList"
                border>
        <el-table-column
          label="SKU编号"
          align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.skuCode"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          v-for="(item,index) in editSkuInfo.productAttr"
          :label="item.name"
          :key="item.id"
          align="center">
          <template slot-scope="scope">
            {{getProductSkuSp(scope.row,index)}}
          </template>
        </el-table-column>
        <el-table-column
          label="销售价格"
          width="80"
          align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.price"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          label="商品库存"
          width="80"
          align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.stock"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          label="库存预警值"
          width="100"
          align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.lowStock"></el-input>
          </template>
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editSkuInfo.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleEditSkuConfirm">确 定</el-button>
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

 const defaultListQuery = {
    keyword: null,
    pageNum: 1,
    pageSize: 5,
    publishStatus: null,
    verifyStatus: null,
    productSn: null,
    productCategoryId: null,
    brandId: null
  };

export default {
	components:{
		PopupTreeInput,
		KtButton,
		TableTreeColumn,
		FaIconTooltip
	},
	watch: {
	  selectProductCateValue: function (newValue) {
	    if (newValue != null && newValue.length == 2) {
	      this.listQuery.productCategoryId = newValue[1];
	    } else {
	      this.listQuery.productCategoryId = null;
	    }
	
	  }
	},
	filters: {
	  verifyStatusFilter(value) {
	    if (value === 1) {
	      return '审核通过';
	    } else {
	      return '未审核';
	    }
	  }
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
			 editSkuInfo:{
				 dialogVisible:false,
				 productId:null,
				 productSn:'',
				 productAttributeCategoryId:null,
				 stockList:[],
				 productAttr:[],
				 keyword:null
			   },
		   operates: [
			 {
			   label: "商品上架",
			   value: "publishOn"
			 },
			 {
			   label: "商品下架",
			   value: "publishOff"
			 },
			 {
			   label: "设为推荐",
			   value: "recommendOn"
			 },
			 {
			   label: "取消推荐",
			   value: "recommendOff"
			 },
			 {
			   label: "设为新品",
			   value: "newOn"
			 },
			 {
			   label: "取消新品",
			   value: "newOff"
			 },
			 {
			   label: "转移到分类",
			   value: "transferCategory"
			 },
			 {
			   label: "移入回收站",
			   value: "recycle"
			 }
		   ],
		   operateType: null,
		   listQuery: Object.assign({}, defaultListQuery),
		   list: null,
		   total: null,
		   listLoading: true,
		   selectProductCateValue: null,
		   multipleSelection: [],
		   productCateOptions: [],
		   brandOptions: [],
		   publishStatusOptions: [{
			 value: 1,
			 label: '上架'
		   }, {
			 value: 0,
			 label: '下架'
		   }],
		   verifyStatusOptions: [{
			 value: 1,
			 label: '审核通过'
		   }, {
			 value: 0,
			 label: '未审核'
		   }]
			}
		},
	methods: {
		//点击下一页和点击页码时执行
		handleCurrentChange(val) {
			console.log(val);
			this.pageRequest.pageNum=val;
			this.findTreeData();
		},
    handleDelete(index, row){
      this.$confirm('是否要进行删除操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = [];
        ids.push(row.id);
        //this.updateDeleteStatus(1,ids);
      });
    },
    handleUpdateProduct(index,row){
      this.$router.push({path:'/pms/updateProduct',query:{id:row.id}});
    },
    handleShowProduct(index,row){
      console.log("handleShowProduct",row);
    },
    handleAdd(){
		  //点击新增
    },
    handleSearchEditSku(){
		  //sku搜索
    },
    handleEditSkuConfirm(){
		  //sku点击确定
    },
		
		// 获取数据
    findTreeData: function () {
		this.loading = true
			var params = new URLSearchParams();
			params.append("currentPage",this.pageRequest.pageNum);
			params.append("pageSize",this.pageRequest.pageSize);
			//params.append("name",this.filters.name);
			//this.$axios.post("http://localhost:8080/dept/findTree",params)
			this.$axios.post("http://localhost:8080/pmsProduct/listPmsProductByPage",params).then((res) => {
				console.log(res);
				this.tableTreeDdata = res.data.data.content
				this.totalSize=res.data.data.totalSize;
				this.loading = false
			})
		},
		 handleShowSkuEditDialog(index,row){
		  console.log(row);
		  this.editSkuInfo.dialogVisible=true;
		  this.editSkuInfo.productId=row.id;
		  //this.editSkuInfo.productSn=row.productSn;
		  this.editSkuInfo.productAttributeCategoryId = row.productAttributeCategoryId;
		  //this.editSkuInfo.keyword=null;
		  var params = new URLSearchParams();
		  params.append("productId",row.id);
		  params.append("currentPage",1);
		  params.append("pageSize",100);
		  this.$axios.post("http://localhost:8080/pmsSkuStock/listPmsSkuStockByPage",params).then(response=>{
		    console.log(response);
		    this.editSkuInfo.stockList=response.data.data.content;
		  });
			var parames=new URLSearchParams();
			parames.append("currentPage",-1);
			parames.append("pageSize",-1);
			parames.append("productAttributeCategoryId",row.productAttributeCategoryId);
			parames.append("type",0);
			this.$axios.post("http://localhost:8080/pmsProductAttribute/listPmsProductAttributeByPage",params).then(response=>{
		    this.editSkuInfo.productAttr=response.data.data.content;
		  });
		},
		
    
	},
	mounted() {
    this.findTreeData()
	}
}
</script>

<style scoped>

</style>
