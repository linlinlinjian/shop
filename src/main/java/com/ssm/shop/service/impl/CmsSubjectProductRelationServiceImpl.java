package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.CmsSubjectProductRelationMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectProductRelation;
import com.ssm.shop.service.inter.CmsSubjectProductRelationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CmsSubjectProductRelationServiceImpl implements CmsSubjectProductRelationService {

	@Autowired
	private CmsSubjectProductRelationMapper CmsSubjectProductRelationMapper;

	@Override
	public List<CmsSubjectProductRelation> listCmsSubjectProductRelation(CmsSubjectProductRelation record){

		return null;

	}

	@Override
	public PageResult listCmsSubjectProductRelationByPage(CmsSubjectProductRelation record){

		int total = CmsSubjectProductRelationMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<CmsSubjectProductRelation> rows=CmsSubjectProductRelationMapper.listCmsSubjectProductRelationByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(CmsSubjectProductRelation record){

		return 0;

	}

	@Override
	public void saveCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation){
		CmsSubjectProductRelationMapper.insert(cmsSubjectProductRelation);

	}

	@Override
	public CmsSubjectProductRelation getCmsSubjectProductRelation(long id){
		return CmsSubjectProductRelationMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateCmsSubjectProductRelation(CmsSubjectProductRelation cmsSubjectProductRelation){
		CmsSubjectProductRelationMapper.updateByPrimaryKeySelective(cmsSubjectProductRelation);

	}

	@Override
	public void deleteCmsSubjectProductRelation(long id){
		CmsSubjectProductRelationMapper.deleteByPrimaryKey(id);

	}

}