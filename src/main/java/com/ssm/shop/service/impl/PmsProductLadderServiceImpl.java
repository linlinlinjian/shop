package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsProductLadderMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductLadder;
import com.ssm.shop.service.inter.PmsProductLadderService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsProductLadderServiceImpl implements PmsProductLadderService {

	@Autowired
	private PmsProductLadderMapper PmsProductLadderMapper;

	@Override
	public List<PmsProductLadder> listPmsProductLadder(PmsProductLadder record){

		return null;

	}

	@Override
	public PageResult listPmsProductLadderByPage(PmsProductLadder record){

		int total = PmsProductLadderMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductLadder> rows=PmsProductLadderMapper.listPmsProductLadderByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProductLadder record){

		return 0;

	}

	@Override
	public void savePmsProductLadder(PmsProductLadder pmsProductLadder){
		PmsProductLadderMapper.insert(pmsProductLadder);

	}

	@Override
	public PmsProductLadder getPmsProductLadder(long id){
		return PmsProductLadderMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductLadder(PmsProductLadder pmsProductLadder){
		PmsProductLadderMapper.updateByPrimaryKeySelective(pmsProductLadder);

	}

	@Override
	public void deletePmsProductLadder(long id){
		PmsProductLadderMapper.deleteByPrimaryKey(id);

	}

}