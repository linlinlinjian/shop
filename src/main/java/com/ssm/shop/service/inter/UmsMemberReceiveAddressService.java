package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.UmsMemberReceiveAddress;

public interface UmsMemberReceiveAddressService {

	List<UmsMemberReceiveAddress> listUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

	PageResult listUmsMemberReceiveAddressByPage(UmsMemberReceiveAddress umsMemberReceiveAddress);

	int selectCount(UmsMemberReceiveAddress umsMemberReceiveAddress);

	void saveUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

	void deleteUmsMemberReceiveAddress(long id);

	void updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

	UmsMemberReceiveAddress getUmsMemberReceiveAddress(long id);

}