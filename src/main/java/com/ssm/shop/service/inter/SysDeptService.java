package com.ssm.shop.service.inter;

import com.ssm.shop.pojo.SysDept;
import com.ssm.shop.service.CurdService;

import java.util.List;


/**
 * 机构管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param
	 * @return
	 */
	List<SysDept> findTree();
}
