package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductAttributeValue;

public interface PmsProductAttributeValueService {

	List<PmsProductAttributeValue> listPmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);

	PageResult listPmsProductAttributeValueByPage(PmsProductAttributeValue pmsProductAttributeValue);

	int selectCount(PmsProductAttributeValue pmsProductAttributeValue);

	void savePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);

	void deletePmsProductAttributeValue(long id);

	void updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue);

	PmsProductAttributeValue getPmsProductAttributeValue(long id);

}