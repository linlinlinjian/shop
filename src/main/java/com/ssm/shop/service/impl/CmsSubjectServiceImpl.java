package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.CmsSubjectMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubject;
import com.ssm.shop.service.inter.CmsSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {

	@Autowired
	private CmsSubjectMapper CmsSubjectMapper;

	@Override
	public List<CmsSubject> listCmsSubject(CmsSubject record){

		return null;

	}

	@Override
	public PageResult listCmsSubjectByPage(CmsSubject record){

		int total = CmsSubjectMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<CmsSubject> rows=CmsSubjectMapper.listCmsSubjectByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(CmsSubject record){

		return 0;

	}

	@Override
	public void saveCmsSubject(CmsSubject cmsSubject){
		CmsSubjectMapper.insert(cmsSubject);

	}

	@Override
	public CmsSubject getCmsSubject(long id){
		return CmsSubjectMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateCmsSubject(CmsSubject cmsSubject){
		CmsSubjectMapper.updateByPrimaryKeySelective(cmsSubject);

	}

	@Override
	public void deleteCmsSubject(long id){
		CmsSubjectMapper.deleteByPrimaryKey(id);

	}

}