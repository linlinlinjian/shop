package com.ssm.shop.dao;

import com.ssm.shop.pojo.CmsSubjectProductRelation;

import java.util.List;

public interface CmsSubjectProductRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectProductRelation record);

    int insertSelective(CmsSubjectProductRelation record);

    CmsSubjectProductRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsSubjectProductRelation record);

    int updateByPrimaryKey(CmsSubjectProductRelation record);

    List<CmsSubjectProductRelation> listCmsSubjectProductRelationByPage(CmsSubjectProductRelation record);

    int selectCount(CmsSubjectProductRelation record);
}