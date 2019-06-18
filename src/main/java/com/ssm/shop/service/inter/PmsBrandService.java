package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsBrand;

public interface PmsBrandService {

	List<PmsBrand> listPmsBrand(PmsBrand pmsBrand);

	PageResult listPmsBrandByPage(PmsBrand pmsBrand);

	int selectCount(PmsBrand pmsBrand);

	void savePmsBrand(PmsBrand pmsBrand);

	void deletePmsBrand(long id);

	void updatePmsBrand(PmsBrand pmsBrand);

	PmsBrand getPmsBrand(long id);

}