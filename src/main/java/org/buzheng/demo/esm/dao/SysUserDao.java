package org.buzheng.demo.esm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.buzheng.demo.esm.domain.SysUser;

public interface SysUserDao {

	void save(SysUser user);
	
	void update(SysUser user);
	
	void delete(String userId);
	
	SysUser findByUserId(String userId);
	
	List<SysUser> findAll();
	
	List<SysUser> findPage();
	
	List<SysUser> findPageByParams(@Param("params") Map<String, Object> params);
	
	int countByUsername(String username);
	
	void updateRoleNull(String roleId);
	
	void updatePassword(String userId, String password);
	
	SysUser loadUserByUsernameAndPassword(String username, String password);
}
