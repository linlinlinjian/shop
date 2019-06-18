package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.SmsCoupon;

public interface SmsCouponService {

	List<SmsCoupon> listSmsCoupon(SmsCoupon smsCoupon);

	PageResult listSmsCouponByPage(SmsCoupon smsCoupon);

	int selectCount(SmsCoupon smsCoupon);

	void saveSmsCoupon(SmsCoupon smsCoupon);

	void deleteSmsCoupon(long id);

	void updateSmsCoupon(SmsCoupon smsCoupon);

	SmsCoupon getSmsCoupon(long id);

}