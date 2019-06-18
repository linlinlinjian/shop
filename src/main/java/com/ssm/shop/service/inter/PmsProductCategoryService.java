package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductCategory;

public interface PmsProductCategoryService {

	List<PmsProductCategory> listPmsProductCategory(PmsProductCategory pmsProductCategory);

	PageResult listPmsProductCategoryByPage(PmsProductCategory pmsProductCategory);

	PageResult findTree(PmsProductCategory pmsProductCategory);

	int selectCount(PmsProductCategory pmsProductCategory);

	void savePmsProductCategory(PmsProductCategory pmsProductCategory);

	void deletePmsProductCategory(long id);

	void updatePmsProductCategory(PmsProductCategory pmsProductCategory);

	PmsProductCategory getPmsProductCategory(long id);

}