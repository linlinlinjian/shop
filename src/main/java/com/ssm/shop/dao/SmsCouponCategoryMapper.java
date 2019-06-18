package com.ssm.shop.dao;

import com.ssm.shop.pojo.SmsCouponCategory;

public interface SmsCouponCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponCategory record);

    int insertSelective(SmsCouponCategory record);

    SmsCouponCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCouponCategory record);

    int updateByPrimaryKey(SmsCouponCategory record);
}