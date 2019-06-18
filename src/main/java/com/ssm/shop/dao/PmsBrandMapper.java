package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsBrand;

import java.util.List;

public interface PmsBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);

    List<PmsBrand> listPmsBrandByPage(PmsBrand record);

    int selectCount(PmsBrand record);
}