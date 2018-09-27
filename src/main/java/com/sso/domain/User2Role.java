package com.sso.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户信息
 */
public class User2Role {
    // 成员变量
    private Long id;
    private Long userid;
    private Long roleid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
    
}