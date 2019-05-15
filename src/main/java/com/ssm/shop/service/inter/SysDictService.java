package com.ssm.shop.service.inter;

import java.util.List;
import com.ssm.shop.pojo.SysDict;
import com.ssm.shop.service.CurdService;

/**
 * 字典管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
