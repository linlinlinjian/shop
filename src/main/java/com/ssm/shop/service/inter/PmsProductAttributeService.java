package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttribute;

public interface PmsProductAttributeService {

	List<PmsProductAttribute> listPmsProductAttribute(PmsProductAttribute pmsProductAttribute);

	PageResult listPmsProductAttributeByPage(PmsProductAttribute pmsProductAttribute);

	int selectCount(PmsProductAttribute pmsProductAttribute);

	void savePmsProductAttribute(PmsProductAttribute pmsProductAttribute);

	void deletePmsProductAttribute(long id);

	void updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute);

	PmsProductAttribute getPmsProductAttribute(long id);

}