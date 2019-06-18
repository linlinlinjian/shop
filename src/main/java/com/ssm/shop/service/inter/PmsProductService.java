package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProduct;

public interface PmsProductService {

	List<PmsProduct> listPmsProduct(PmsProduct pmsProduct);

	PageResult listPmsProductByPage(PmsProduct pmsProduct);

	int selectCount(PmsProduct pmsProduct);

	void savePmsProduct(PmsProduct pmsProduct);

	void deletePmsProduct(long id);

	void updatePmsProduct(PmsProduct pmsProduct);

	PmsProduct getPmsProduct(long id);

}