package com.sso.domain;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户信息
 */
public class User implements Serializable{
    // 成员变量
    private Long id;
    private String eMail;
    private String passWord;
    private String nickName;
	private String telPhone;
	
    private Date insertTime;
    private Date updateTime;
    private Date registerTime;
    private String textVail;
    private String token;
    private String ErrorInfo;
    public String getErrorInfo() {
		return ErrorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		ErrorInfo = errorInfo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTextVail() {
		return textVail;
	}
	public void setTextVail(String textVail) {
		this.textVail = textVail;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

 
    
}