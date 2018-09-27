package com.sso.domain;

import java.util.Date;

public class Role {
	private Long Id;
	private String RoleName;
	private String RoleType;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getRoleType() {
		return RoleType;
	}
	public void setRoleType(String roleType) {
		RoleType = roleType;
	}
	public Date getInsertTime() {
		return InsertTime;
	}
	public void setInsertTime(Date insertTime) {
		InsertTime = insertTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	private Date InsertTime;
	private Date UpdateTime;
}
