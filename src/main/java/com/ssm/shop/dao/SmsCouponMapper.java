package com.ssm.shop.dao;

import com.ssm.shop.pojo.SmsCoupon;

import java.util.List;

public interface SmsCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCoupon record);

    int insertSelective(SmsCoupon record);

    SmsCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCoupon record);

    int updateByPrimaryKey(SmsCoupon record);

    List<SmsCoupon> listSmsCouponByPage(SmsCoupon record);

    int selectCount(SmsCoupon record);
}