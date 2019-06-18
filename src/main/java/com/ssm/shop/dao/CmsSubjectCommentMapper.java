package com.ssm.shop.dao;

import com.ssm.shop.pojo.CmsSubjectComment;

import java.util.List;

public interface CmsSubjectCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectComment record);

    int insertSelective(CmsSubjectComment record);

    CmsSubjectComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsSubjectComment record);

    int updateByPrimaryKey(CmsSubjectComment record);

    List<CmsSubjectComment> listCmsSubjectCommentByPage(CmsSubjectComment record);

    int selectCount(CmsSubjectComment record);
}