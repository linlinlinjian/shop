package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsProductAttributeValueMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttributeValue;
import com.ssm.shop.service.inter.PmsProductAttributeValueService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsProductAttributeValueServiceImpl implements PmsProductAttributeValueService {

	@Autowired
	private PmsProductAttributeValueMapper PmsProductAttributeValueMapper;

	@Override
	public List<PmsProductAttributeValue> listPmsProductAttributeValue(PmsProductAttributeValue record){

		return null;

	}

	@Override
	public PageResult listPmsProductAttributeValueByPage(PmsProductAttributeValue record){

		int total = PmsProductAttributeValueMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductAttributeValue> rows=PmsProductAttributeValueMapper.listPmsProductAttributeValueByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProductAttributeValue record){

		return 0;

	}

	@Override
	public void savePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){
		PmsProductAttributeValueMapper.insert(pmsProductAttributeValue);

	}

	@Override
	public PmsProductAttributeValue getPmsProductAttributeValue(long id){
		return PmsProductAttributeValueMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){
		PmsProductAttributeValueMapper.updateByPrimaryKeySelective(pmsProductAttributeValue);

	}

	@Override
	public void deletePmsProductAttributeValue(long id){
		PmsProductAttributeValueMapper.deleteByPrimaryKey(id);

	}

}