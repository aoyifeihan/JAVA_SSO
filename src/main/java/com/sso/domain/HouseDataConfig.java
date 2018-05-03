package com.sso.domain;

import java.util.Date;

public class HouseDataConfig {
private String id;
private String city;
private String housetype;
private Date modifydata;
private int status;
private int isdelete;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getHousetype() {
	return housetype;
}
public void setHousetype(String housetype) {
	this.housetype = housetype;
}
public Date getModifydata() {
	return modifydata;
}
public void setModifydata(Date modifydata) {
	this.modifydata = modifydata;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}
}
