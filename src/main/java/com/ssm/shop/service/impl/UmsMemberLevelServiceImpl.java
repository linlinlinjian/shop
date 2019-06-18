package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.UmsMemberLevelMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMemberLevel;
import com.ssm.shop.service.inter.UmsMemberLevelService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {

	@Autowired
	private UmsMemberLevelMapper UmsMemberLevelMapper;

	@Override
	public List<UmsMemberLevel> listUmsMemberLevel(UmsMemberLevel record){

		return null;

	}

	@Override
	public PageResult listUmsMemberLevelByPage(UmsMemberLevel record){

		int total = UmsMemberLevelMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<UmsMemberLevel> rows=UmsMemberLevelMapper.listUmsMemberLevelByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(UmsMemberLevel record){

		return 0;

	}

	@Override
	public void saveUmsMemberLevel(UmsMemberLevel umsMemberLevel){
		UmsMemberLevelMapper.insert(umsMemberLevel);

	}

	@Override
	public UmsMemberLevel getUmsMemberLevel(long id){
		return UmsMemberLevelMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateUmsMemberLevel(UmsMemberLevel umsMemberLevel){
		UmsMemberLevelMapper.updateByPrimaryKeySelective(umsMemberLevel);

	}

	@Override
	public void deleteUmsMemberLevel(long id){
		UmsMemberLevelMapper.deleteByPrimaryKey(id);

	}

}