package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMemberLevel;

public interface UmsMemberLevelService {

	List<UmsMemberLevel> listUmsMemberLevel(UmsMemberLevel umsMemberLevel);

	PageResult listUmsMemberLevelByPage(UmsMemberLevel umsMemberLevel);

	int selectCount(UmsMemberLevel umsMemberLevel);

	void saveUmsMemberLevel(UmsMemberLevel umsMemberLevel);

	void deleteUmsMemberLevel(long id);

	void updateUmsMemberLevel(UmsMemberLevel umsMemberLevel);

	UmsMemberLevel getUmsMemberLevel(long id);

}