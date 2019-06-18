package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import com.ssm.shop.dao.*;
import com.ssm.shop.pojo.*;
import org.springframework.stereotype.Service;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.service.inter.PmsProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

@Service
public class PmsProductServiceImpl implements PmsProductService {

	@Autowired
	private PmsProductMapper PmsProductMapper;

	@Autowired
	private PmsMemberPriceMapper memberPriceMapper;

	@Autowired
	private PmsProductLadderMapper productLadderMapper;

	@Autowired
	private PmsProductFullReductionMapper productFullReductionMapper;

	@Autowired
	private PmsSkuStockMapper skuStockMapper;

	@Autowired
	private PmsProductAttributeValueMapper productAttributeValueMapper;

	@Autowired
	private CmsSubjectProductRelationMapper subjectProductRelationMapper;

//	@Autowired
//	private CmsPrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;

	@Override
	public List<PmsProduct> listPmsProduct(PmsProduct record){

		return null;

	}

	@Override
	public PageResult listPmsProductByPage(PmsProduct record){

		int total = PmsProductMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProduct> rows=PmsProductMapper.listPmsProductByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProduct record){

		return 0;

	}

	@Override
	public void savePmsProduct(PmsProduct pmsProduct){
		PmsProductMapper.insert(pmsProduct);
		//根据促销类型设置价格：、阶梯价格、满减价格
		Long productId = pmsProduct.getId();
		//会员价格
		List<PmsMemberPrice> memberPriceList = pmsProduct.getMemberPriceList();
		if (!CollectionUtils.isEmpty(memberPriceList)) {
			for (PmsMemberPrice pmsMemberPrice : memberPriceList) {
				pmsMemberPrice.setId(null);
				pmsMemberPrice.setProductId(productId);
				memberPriceMapper.insert(pmsMemberPrice);
			}
		}
		//阶梯价格
		List<PmsProductLadder> productLadderList = pmsProduct.getProductLadderList();
		if (!CollectionUtils.isEmpty(productLadderList)) {
			for (PmsProductLadder productLadder : productLadderList) {
				productLadder.setId(null);
				productLadder.setProductId(productId);
				productLadderMapper.insert(productLadder);
			}
		}
		//满减价格
		List<PmsProductFullReduction> productFullReductionList = pmsProduct.getProductFullReductionList();
		if (!CollectionUtils.isEmpty(productFullReductionList)) {
			for (PmsProductFullReduction productFullReduction : productFullReductionList) {
				productFullReduction.setId(null);
				productFullReduction.setProductId(productId);
				productFullReductionMapper.insert(productFullReduction);
			}
		}
		//添加sku库存信息
		List<PmsSkuStock> skuStockList = pmsProduct.getSkuStockList();
		if (!CollectionUtils.isEmpty(skuStockList)) {
			for (PmsSkuStock skuStock : skuStockList) {
				skuStock.setId(null);
				skuStock.setProductId(productId);
				skuStockMapper.insert(skuStock);
			}
		}
		//添加商品参数,添加自定义商品规格
		List<PmsProductAttributeValue> productAttributeValueList = pmsProduct.getProductAttributeValueList();
		if (!CollectionUtils.isEmpty(productAttributeValueList)) {
			for (PmsProductAttributeValue productAttributeValue : productAttributeValueList) {
				productAttributeValue.setId(null);
				productAttributeValue.setProductId(productId);
				productAttributeValueMapper.insert(productAttributeValue);
			}
		}
		//关联专题
		List<CmsSubjectProductRelation> subjectProductRelationList = pmsProduct.getSubjectProductRelationList();
		if (!CollectionUtils.isEmpty(subjectProductRelationList)) {
			for (CmsSubjectProductRelation productAttributeValue : subjectProductRelationList) {
				productAttributeValue.setId(null);
				productAttributeValue.setProductId(productId);
				subjectProductRelationMapper.insert(productAttributeValue);
			}
		}
		//关联优选
//		relateAndInsertList(prefrenceAreaProductRelationDao, productParam.getPrefrenceAreaProductRelationList(), productId);


	}

	@Override
	public PmsProduct getPmsProduct(long id){
		return PmsProductMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProduct(PmsProduct pmsProduct){
		PmsProductMapper.updateByPrimaryKeySelective(pmsProduct);

	}

	@Override
	public void deletePmsProduct(long id){
		PmsProductMapper.deleteByPrimaryKey(id);

	}

}