package com.ssm.shop.dao;

import com.ssm.shop.pojo.CmsSubjectCategory;

import java.util.List;

public interface CmsSubjectCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectCategory record);

    int insertSelective(CmsSubjectCategory record);

    CmsSubjectCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsSubjectCategory record);

    int updateByPrimaryKey(CmsSubjectCategory record);

    List<CmsSubjectCategory> listCmsSubjectCategoryByPage(CmsSubjectCategory record);

    int selectCount(CmsSubjectCategory record);
}