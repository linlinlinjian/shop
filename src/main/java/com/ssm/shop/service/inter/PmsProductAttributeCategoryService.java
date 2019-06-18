package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttributeCategory;

public interface PmsProductAttributeCategoryService {

	List<PmsProductAttributeCategory> listPmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

	PageResult listPmsProductAttributeCategoryByPage(PmsProductAttributeCategory pmsProductAttributeCategory);

	int selectCount(PmsProductAttributeCategory pmsProductAttributeCategory);

	void savePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

	void deletePmsProductAttributeCategory(long id);

	void updatePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

	PmsProductAttributeCategory getPmsProductAttributeCategory(long id);

}