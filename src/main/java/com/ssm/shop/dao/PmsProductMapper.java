package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProduct;

import java.util.List;

public interface PmsProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    int insertSelective(PmsProduct record);

    PmsProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);

    List<PmsProduct> listPmsProductByPage(PmsProduct record);

    int selectCount(PmsProduct record);
}