package com.sso.dto;

public class ResponseDTO<T> {
private long code;
private T data;
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
}
