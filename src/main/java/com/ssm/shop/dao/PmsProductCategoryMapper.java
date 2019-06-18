package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCategory record);

    int insertSelective(PmsProductCategory record);

    PmsProductCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductCategory record);

    int updateByPrimaryKey(PmsProductCategory record);

    List<PmsProductCategory> listPmsProductCategoryByPage(PmsProductCategory record);

    int selectCount(PmsProductCategory record);
}