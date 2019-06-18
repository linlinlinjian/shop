package com.ssm.shop.service.impl;

import com.ssm.shop.dao.PmsProductAttributeMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttribute;
import com.ssm.shop.service.inter.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

	@Autowired
	private PmsProductAttributeMapper PmsProductAttributeMapper;

	@Override
	public List<PmsProductAttribute> listPmsProductAttribute(PmsProductAttribute record){

		return null;

	}

	@Override
	public PageResult listPmsProductAttributeByPage(PmsProductAttribute record){

		int total = PmsProductAttributeMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductAttribute> rows=PmsProductAttributeMapper.listPmsProductAttributeByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProductAttribute record){

		return 0;

	}

	@Override
	public void savePmsProductAttribute(PmsProductAttribute pmsProductAttribute){
		PmsProductAttributeMapper.insert(pmsProductAttribute);

	}

	@Override
	public PmsProductAttribute getPmsProductAttribute(long id){
		return PmsProductAttributeMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute){
		PmsProductAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);

	}

	@Override
	public void deletePmsProductAttribute(long id){
		PmsProductAttributeMapper.deleteByPrimaryKey(id);

	}

}