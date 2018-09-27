package com.sso.dao;

import com.sso.domain.AuthLogin;

public interface AuthLoginDao {
	public abstract void insertAuthLogin(AuthLogin authLogin);
	public abstract void updateAuthLogin(AuthLogin authLogin);

	public abstract AuthLogin queryAuthLoginByName(String username);  
}