package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.CmsSubjectCommentMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.CmsSubjectComment;
import com.ssm.shop.service.inter.CmsSubjectCommentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CmsSubjectCommentServiceImpl implements CmsSubjectCommentService {

	@Autowired
	private CmsSubjectCommentMapper CmsSubjectCommentMapper;

	@Override
	public List<CmsSubjectComment> listCmsSubjectComment(CmsSubjectComment record){

		return null;

	}

	@Override
	public PageResult listCmsSubjectCommentByPage(CmsSubjectComment record){

		int total = CmsSubjectCommentMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<CmsSubjectComment> rows=CmsSubjectCommentMapper.listCmsSubjectCommentByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(CmsSubjectComment record){

		return 0;

	}

	@Override
	public void saveCmsSubjectComment(CmsSubjectComment cmsSubjectComment){
		CmsSubjectCommentMapper.insert(cmsSubjectComment);

	}

	@Override
	public CmsSubjectComment getCmsSubjectComment(long id){
		return CmsSubjectCommentMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateCmsSubjectComment(CmsSubjectComment cmsSubjectComment){
		CmsSubjectCommentMapper.updateByPrimaryKeySelective(cmsSubjectComment);

	}

	@Override
	public void deleteCmsSubjectComment(long id){
		CmsSubjectCommentMapper.deleteByPrimaryKey(id);

	}

}