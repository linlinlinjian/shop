package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.PmsBrandMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsBrand;
import com.ssm.shop.service.inter.PmsBrandService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

	@Autowired
	private PmsBrandMapper PmsBrandMapper;

	@Override
	public List<PmsBrand> listPmsBrand(PmsBrand pmsBrand){

		return null;

	}

	@Override
	public PageResult listPmsBrandByPage(PmsBrand record){

		int total = PmsBrandMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<PmsBrand> rows=PmsBrandMapper.listPmsBrandByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(PmsBrand record){

		return 0;

	}

	@Override
	public void savePmsBrand(PmsBrand pmsBrand){
		if(pmsBrand.getId()==null || pmsBrand.getId()==0){
			PmsBrandMapper.insert(pmsBrand);
		}else{
			PmsBrandMapper.updateByPrimaryKey(pmsBrand);
		}

	}

	@Override
	public PmsBrand getPmsBrand(long id){
		return PmsBrandMapper.selectByPrimaryKey(id);	}

	@Override
	public void updatePmsBrand(PmsBrand pmsBrand){
		PmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);

	}

	@Override
	public void deletePmsBrand(long id){
		PmsBrandMapper.deleteByPrimaryKey(id);

	}

}