package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuStock record);

    int insertSelective(PmsSkuStock record);

    PmsSkuStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuStock record);

    int updateByPrimaryKey(PmsSkuStock record);

    List<PmsSkuStock> listPmsSkuStockByPage(PmsSkuStock record);

    int selectCount(PmsSkuStock record);
}