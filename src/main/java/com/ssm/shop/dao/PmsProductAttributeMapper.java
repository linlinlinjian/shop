package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductAttribute;

import java.util.List;

public interface PmsProductAttributeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttribute record);

    int insertSelective(PmsProductAttribute record);

    PmsProductAttribute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductAttribute record);

    int updateByPrimaryKey(PmsProductAttribute record);

    List<PmsProductAttribute> listPmsProductAttributeByPage(PmsProductAttribute record);

    int selectCount(PmsProductAttribute record);
}