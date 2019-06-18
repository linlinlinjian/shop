package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsSkuStockMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsSkuStock;
import com.ssm.shop.service.inter.PmsSkuStockService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {

	@Autowired
	private PmsSkuStockMapper PmsSkuStockMapper;

	@Override
	public List<PmsSkuStock> listPmsSkuStock(PmsSkuStock record){

		return null;

	}

	@Override
	public PageResult listPmsSkuStockByPage(PmsSkuStock record){

		int total = PmsSkuStockMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsSkuStock> rows=PmsSkuStockMapper.listPmsSkuStockByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsSkuStock record){

		return 0;

	}

	@Override
	public void savePmsSkuStock(PmsSkuStock pmsSkuStock){
		PmsSkuStockMapper.insert(pmsSkuStock);

	}

	@Override
	public PmsSkuStock getPmsSkuStock(long id){
		return PmsSkuStockMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsSkuStock(PmsSkuStock pmsSkuStock){
		PmsSkuStockMapper.updateByPrimaryKeySelective(pmsSkuStock);

	}

	@Override
	public void deletePmsSkuStock(long id){
		PmsSkuStockMapper.deleteByPrimaryKey(id);

	}

}