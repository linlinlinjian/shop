package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.CmsSubjectCategoryMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectCategory;
import com.ssm.shop.service.inter.CmsSubjectCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CmsSubjectCategoryServiceImpl implements CmsSubjectCategoryService {

	@Autowired
	private CmsSubjectCategoryMapper CmsSubjectCategoryMapper;

	@Override
	public List<CmsSubjectCategory> listCmsSubjectCategory(CmsSubjectCategory record){

		return null;

	}

	@Override
	public PageResult listCmsSubjectCategoryByPage(CmsSubjectCategory record){

		int total = CmsSubjectCategoryMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<CmsSubjectCategory> rows=CmsSubjectCategoryMapper.listCmsSubjectCategoryByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(CmsSubjectCategory record){

		return 0;

	}

	@Override
	public void saveCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory){
		CmsSubjectCategoryMapper.insert(cmsSubjectCategory);

	}

	@Override
	public CmsSubjectCategory getCmsSubjectCategory(long id){
		return CmsSubjectCategoryMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateCmsSubjectCategory(CmsSubjectCategory cmsSubjectCategory){
		CmsSubjectCategoryMapper.updateByPrimaryKeySelective(cmsSubjectCategory);

	}

	@Override
	public void deleteCmsSubjectCategory(long id){
		CmsSubjectCategoryMapper.deleteByPrimaryKey(id);

	}

}