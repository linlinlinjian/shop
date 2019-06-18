package com.ssm.shop.dao;

import com.ssm.shop.pojo.UmsMemberLevel;

import java.util.List;

public interface UmsMemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLevel record);

    int insertSelective(UmsMemberLevel record);

    UmsMemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberLevel record);

    int updateByPrimaryKey(UmsMemberLevel record);

    List<UmsMemberLevel> listUmsMemberLevelByPage(UmsMemberLevel record);

    int selectCount(UmsMemberLevel record);
}