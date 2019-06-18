package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductAttributeCategory;

import java.util.List;

public interface PmsProductAttributeCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeCategory record);

    int insertSelective(PmsProductAttributeCategory record);

    PmsProductAttributeCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductAttributeCategory record);

    int updateByPrimaryKey(PmsProductAttributeCategory record);

    List<PmsProductAttributeCategory> listPmsProductAttributeCategoryByPage(PmsProductAttributeCategory record);

   int selectCount(PmsProductAttributeCategory record);
}