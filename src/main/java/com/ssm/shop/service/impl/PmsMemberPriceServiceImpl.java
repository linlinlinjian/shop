package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsMemberPriceMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsMemberPrice;
import com.ssm.shop.service.inter.PmsMemberPriceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsMemberPriceServiceImpl implements PmsMemberPriceService {

	@Autowired
	private PmsMemberPriceMapper PmsMemberPriceMapper;

	@Override
	public List<PmsMemberPrice> listPmsMemberPrice(PmsMemberPrice record){

		return null;

	}

	@Override
	public PageResult listPmsMemberPriceByPage(PmsMemberPrice record){

		int total = PmsMemberPriceMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsMemberPrice> rows=PmsMemberPriceMapper.listPmsMemberPriceByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsMemberPrice record){

		return 0;

	}

	@Override
	public void savePmsMemberPrice(PmsMemberPrice pmsMemberPrice){
		PmsMemberPriceMapper.insert(pmsMemberPrice);

	}

	@Override
	public PmsMemberPrice getPmsMemberPrice(long id){
		return PmsMemberPriceMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsMemberPrice(PmsMemberPrice pmsMemberPrice){
		PmsMemberPriceMapper.updateByPrimaryKeySelective(pmsMemberPrice);

	}

	@Override
	public void deletePmsMemberPrice(long id){
		PmsMemberPriceMapper.deleteByPrimaryKey(id);

	}

}