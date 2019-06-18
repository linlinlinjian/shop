package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductFullReduction;

import java.util.List;

public interface PmsProductFullReductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductFullReduction record);

    int insertSelective(PmsProductFullReduction record);

    PmsProductFullReduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductFullReduction record);

    int updateByPrimaryKey(PmsProductFullReduction record);

    List<PmsProductFullReduction> listPmsProductFullReductionByPage(PmsProductFullReduction record);

    int selectCount(PmsProductFullReduction record);
}