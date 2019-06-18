package com.ssm.shop.dao;

import com.ssm.shop.pojo.CmsSubject;

import java.util.List;

public interface CmsSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubject record);

    int insertSelective(CmsSubject record);

    CmsSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsSubject record);

    int updateByPrimaryKey(CmsSubject record);

    List<CmsSubject> listCmsSubjectByPage(CmsSubject record);

    int selectCount(CmsSubject record);
}