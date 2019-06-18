package com.ssm.shop.service.impl;

import com.ssm.shop.dao.PmsProductAttributeCategoryMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttributeCategory;
import com.ssm.shop.service.inter.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

	@Autowired
	private PmsProductAttributeCategoryMapper PmsProductAttributeCategoryMapper;

	@Override
	public List<PmsProductAttributeCategory> listPmsProductAttributeCategory(PmsProductAttributeCategory record){

		return null;

	}

	@Override
	public PageResult listPmsProductAttributeCategoryByPage(PmsProductAttributeCategory record){

		int total = PmsProductAttributeCategoryMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductAttributeCategory> rows=PmsProductAttributeCategoryMapper.listPmsProductAttributeCategoryByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProductAttributeCategory record){

		return 0;

	}

	@Override
	public void savePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory){
		PmsProductAttributeCategoryMapper.insert(pmsProductAttributeCategory);

	}

	@Override
	public PmsProductAttributeCategory getPmsProductAttributeCategory(long id){
		return PmsProductAttributeCategoryMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory){
		PmsProductAttributeCategoryMapper.updateByPrimaryKeySelective(pmsProductAttributeCategory);

	}

	@Override
	public void deletePmsProductAttributeCategory(long id){
		PmsProductAttributeCategoryMapper.deleteByPrimaryKey(id);

	}

}