package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductAttributeValue;

import java.util.List;

public interface PmsProductAttributeValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeValue record);

    int insertSelective(PmsProductAttributeValue record);

    PmsProductAttributeValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductAttributeValue record);

    int updateByPrimaryKey(PmsProductAttributeValue record);

    List<PmsProductAttributeValue> listPmsProductAttributeValueByPage(PmsProductAttributeValue record);

    int selectCount(PmsProductAttributeValue record);
}