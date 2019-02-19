package org.buzheng.demo.esm.domain;

import java.sql.Date;

/**
 * 系统用户
 * @author Adam
 *
 */
public class SysUser {
	
	private Long userId;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private Long roleId;
	
	private String roleName;
	
	private Long groupId;
	
	private String groupName;
	
	private Date addTime;
	
	private String phone;
		
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", name=" + name + ", roleId="
				+ roleId + ", groupId=" + groupId + ", addTime=" + addTime
				+ ", roleName=" + roleName + "]";
	}

}
