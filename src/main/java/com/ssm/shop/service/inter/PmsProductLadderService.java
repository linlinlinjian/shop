package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.PmsProductLadder;

public interface PmsProductLadderService {

	List<PmsProductLadder> listPmsProductLadder(PmsProductLadder pmsProductLadder);

	PageResult listPmsProductLadderByPage(PmsProductLadder pmsProductLadder);

	int selectCount(PmsProductLadder pmsProductLadder);

	void savePmsProductLadder(PmsProductLadder pmsProductLadder);

	void deletePmsProductLadder(long id);

	void updatePmsProductLadder(PmsProductLadder pmsProductLadder);

	PmsProductLadder getPmsProductLadder(long id);

}