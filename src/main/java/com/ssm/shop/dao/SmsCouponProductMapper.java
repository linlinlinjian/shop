package com.ssm.shop.dao;

import com.ssm.shop.pojo.SmsCouponProduct;

public interface SmsCouponProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponProduct record);

    int insertSelective(SmsCouponProduct record);

    SmsCouponProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponProduct record);

    int updateByPrimaryKey(SmsCouponProduct record);
}