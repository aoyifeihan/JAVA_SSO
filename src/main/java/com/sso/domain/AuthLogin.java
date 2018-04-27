package com.sso.domain;

import java.util.Date;

/**
 * 用户信息
 */
public class AuthLogin {
	private String ip;
    private String token;
    private String eMail;
    

	private Date beginDate;
    private Date endDate;
    private int isExpire;
    private String tabIndex;
    // 成员变量
  
    public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getTabIndex() {
		return tabIndex;
	}
	public void setTabIndex(String tableIndex) {
		this.tabIndex = tableIndex;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getIsExpire() {
		return isExpire;
	}
	public void setIsExpire(int isExpire) {
		this.isExpire = isExpire;
	}
	 
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}