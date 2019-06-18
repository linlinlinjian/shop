package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsSkuStock;

public interface PmsSkuStockService {

	List<PmsSkuStock> listPmsSkuStock(PmsSkuStock pmsSkuStock);

	PageResult listPmsSkuStockByPage(PmsSkuStock pmsSkuStock);

	int selectCount(PmsSkuStock pmsSkuStock);

	void savePmsSkuStock(PmsSkuStock pmsSkuStock);

	void deletePmsSkuStock(long id);

	void updatePmsSkuStock(PmsSkuStock pmsSkuStock);

	PmsSkuStock getPmsSkuStock(long id);

}