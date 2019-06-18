package com.ssm.shop.dao;

import com.ssm.shop.pojo.PmsProductLadder;

import java.util.List;

public interface PmsProductLadderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductLadder record);

    int insertSelective(PmsProductLadder record);

    PmsProductLadder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductLadder record);

    int updateByPrimaryKey(PmsProductLadder record);

    List<PmsProductLadder> listPmsProductLadderByPage(PmsProductLadder record);

    int selectCount(PmsProductLadder record);
}