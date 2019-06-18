package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductFullReduction;

public interface PmsProductFullReductionService {

	List<PmsProductFullReduction> listPmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction);

	PageResult listPmsProductFullReductionByPage(PmsProductFullReduction pmsProductFullReduction);

	int selectCount(PmsProductFullReduction pmsProductFullReduction);

	void savePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction);

	void deletePmsProductFullReduction(long id);

	void updatePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction);

	PmsProductFullReduction getPmsProductFullReduction(long id);

}