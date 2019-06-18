package com.ssm.shop.service.inter;

import com.ssm.shop.page.PageResult;
import com.ssm.shop.pojo.SysUser;
import com.ssm.shop.pojo.SysUserRole;
import com.ssm.shop.pojo.basePojo.BTEntitiy;
import com.ssm.shop.service.CurdService;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysUserService extends CurdService<SysUser> {

	SysUser findByName(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName);

	/**
	 * 查找用户的角色集合
	 * @param
	 * @return
	 */
	List<SysUserRole> findUserRoles(Long userId);

    PageResult findPages(SysUser user);

	int selectCount(SysUser user);

}
