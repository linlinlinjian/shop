package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMember;

public interface UmsMemberService {

	List<UmsMember> listUmsMember(UmsMember umsMember);

	PageResult listUmsMemberByPage(UmsMember umsMember);

	int selectCount(UmsMember umsMember);

	void saveUmsMember(UmsMember umsMember);

	void deleteUmsMember(long id);

	void updateUmsMember(UmsMember umsMember);

	UmsMember getUmsMember(long id);

	UmsMember login(UmsMember record);
}