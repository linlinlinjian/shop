package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsMemberPrice;

import java.util.List;

public interface PmsMemberPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsMemberPrice record);

    int insertSelective(PmsMemberPrice record);

    PmsMemberPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsMemberPrice record);

    int updateByPrimaryKey(PmsMemberPrice record);

    List<PmsMemberPrice> listPmsMemberPriceByPage(PmsMemberPrice record);

    int selectCount(PmsMemberPrice record);;
}