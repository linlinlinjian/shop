package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsProductFullReductionMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductFullReduction;
import com.ssm.shop.service.inter.PmsProductFullReductionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsProductFullReductionServiceImpl implements PmsProductFullReductionService {

	@Autowired
	private PmsProductFullReductionMapper PmsProductFullReductionMapper;

	@Override
	public List<PmsProductFullReduction> listPmsProductFullReduction(PmsProductFullReduction record){

		return null;

	}

	@Override
	public PageResult listPmsProductFullReductionByPage(PmsProductFullReduction record){

		int total = PmsProductFullReductionMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsProductFullReduction> rows=PmsProductFullReductionMapper.listPmsProductFullReductionByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsProductFullReduction record){

		return 0;

	}

	@Override
	public void savePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){
		PmsProductFullReductionMapper.insert(pmsProductFullReduction);

	}

	@Override
	public PmsProductFullReduction getPmsProductFullReduction(long id){
		return PmsProductFullReductionMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){
		PmsProductFullReductionMapper.updateByPrimaryKeySelective(pmsProductFullReduction);

	}

	@Override
	public void deletePmsProductFullReduction(long id){
		PmsProductFullReductionMapper.deleteByPrimaryKey(id);

	}

}