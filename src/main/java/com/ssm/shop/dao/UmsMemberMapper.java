package com.ssm.shop.dao;

import com.ssm.shop.pojo.UmsMember;

import java.util.List;

public interface UmsMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    UmsMember login(UmsMember record);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);

    List<UmsMember> listUmsMemberByPage(UmsMember record);

    int selectCount(UmsMember record);
}