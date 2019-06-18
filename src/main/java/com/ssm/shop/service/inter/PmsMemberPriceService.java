package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsMemberPrice;

public interface PmsMemberPriceService {

	List<PmsMemberPrice> listPmsMemberPrice(PmsMemberPrice pmsMemberPrice);

	PageResult listPmsMemberPriceByPage(PmsMemberPrice pmsMemberPrice);

	int selectCount(PmsMemberPrice pmsMemberPrice);

	void savePmsMemberPrice(PmsMemberPrice pmsMemberPrice);

	void deletePmsMemberPrice(long id);

	void updatePmsMemberPrice(PmsMemberPrice pmsMemberPrice);

	PmsMemberPrice getPmsMemberPrice(long id);

}