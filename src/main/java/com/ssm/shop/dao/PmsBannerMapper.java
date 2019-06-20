package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsBanner;

import java.util.List;

public interface PmsBannerMapper {
    int deleteByPrimaryKey(long id);

    int insert(PmsBanner record);

    int insertSelective(PmsBanner record);

    PmsBanner selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(PmsBanner record);

    int updateByPrimaryKey(PmsBanner record);

    List<PmsBanner> listPmsBannerByPage(PmsBanner record);

    int selectCount(PmsBanner record);
}