package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.UmsMemberMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMember;
import com.ssm.shop.service.inter.UmsMemberService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

	@Autowired
	private UmsMemberMapper UmsMemberMapper;

	@Override
	public List<UmsMember> listUmsMember(UmsMember record){

		return null;

	}

	@Override
	public PageResult listUmsMemberByPage(UmsMember record){

		int total = UmsMemberMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<UmsMember> rows=UmsMemberMapper.listUmsMemberByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(UmsMember record){

		return 0;

	}

	@Override
	public void saveUmsMember(UmsMember umsMember){
		UmsMemberMapper.insert(umsMember);

	}

	@Override
	public UmsMember getUmsMember(long id){
		return UmsMemberMapper.selectByPrimaryKey(id);	}

	@Override
	public UmsMember login(UmsMember record) {
		return UmsMemberMapper.login(record);
	}

	@Override
	public void updateUmsMember(UmsMember umsMember){
		UmsMemberMapper.updateByPrimaryKeySelective(umsMember);

	}

	@Override
	public void deleteUmsMember(long id){
		UmsMemberMapper.deleteByPrimaryKey(id);

	}

}