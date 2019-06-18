package com.ssm.shop.dao;

import com.ssm.shop.pojo.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberReceiveAddress record);

    int insertSelective(UmsMemberReceiveAddress record);

    UmsMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberReceiveAddress record);

    int updateByPrimaryKey(UmsMemberReceiveAddress record);

    List<UmsMemberReceiveAddress> listUmsMemberReceiveAddressByPage(UmsMemberReceiveAddress record);

    int selectCount(UmsMemberReceiveAddress record);
}