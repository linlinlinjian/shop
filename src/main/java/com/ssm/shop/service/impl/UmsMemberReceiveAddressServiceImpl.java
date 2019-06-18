package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.UmsMemberReceiveAddressMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMemberReceiveAddress;
import com.ssm.shop.service.inter.UmsMemberReceiveAddressService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

	@Autowired
	private UmsMemberReceiveAddressMapper UmsMemberReceiveAddressMapper;

	@Override
	public List<UmsMemberReceiveAddress> listUmsMemberReceiveAddress(UmsMemberReceiveAddress record){

		return null;

	}

	@Override
	public PageResult listUmsMemberReceiveAddressByPage(UmsMemberReceiveAddress record){

		int total = UmsMemberReceiveAddressMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<UmsMemberReceiveAddress> rows=UmsMemberReceiveAddressMapper.listUmsMemberReceiveAddressByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(UmsMemberReceiveAddress record){

		return 0;

	}

	@Override
	public void saveUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){
		UmsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);

	}

	@Override
	public UmsMemberReceiveAddress getUmsMemberReceiveAddress(long id){
		return UmsMemberReceiveAddressMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress){
		UmsMemberReceiveAddressMapper.updateByPrimaryKeySelective(umsMemberReceiveAddress);

	}

	@Override
	public void deleteUmsMemberReceiveAddress(long id){
		UmsMemberReceiveAddressMapper.deleteByPrimaryKey(id);

	}

}