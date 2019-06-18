package com.ssm.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.shop.dao.SmsCouponMapper;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.SmsCoupon;
import com.ssm.shop.service.inter.SmsCouponService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SmsCouponServiceImpl implements SmsCouponService {

	@Autowired
	private SmsCouponMapper SmsCouponMapper;

	@Override
	public List<SmsCoupon> listSmsCoupon(SmsCoupon record){

		return null;

	}

	@Override
	public PageResult listSmsCouponByPage(SmsCoupon record){

		int total = SmsCouponMapper.selectCount(record);

		record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());

		List<SmsCoupon> rows=SmsCouponMapper.listSmsCouponByPage(record);

		return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);

	}

	@Override
	public int selectCount(SmsCoupon record){

		return 0;

	}

	@Override
	public void saveSmsCoupon(SmsCoupon smsCoupon){
		SmsCouponMapper.insert(smsCoupon);

	}

	@Override
	public SmsCoupon getSmsCoupon(long id){
		return SmsCouponMapper.selectByPrimaryKey(id);	}

	@Override
	public void updateSmsCoupon(SmsCoupon smsCoupon){
		SmsCouponMapper.updateByPrimaryKeySelective(smsCoupon);

	}

	@Override
	public void deleteSmsCoupon(long id){
		SmsCouponMapper.deleteByPrimaryKey(id);

	}

}