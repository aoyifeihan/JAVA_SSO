package com.sso.dao;

import com.sso.domain.*;

public interface AuthLoginDao {
	public abstract void insertAuthLogin(AuthLogin username);

	public abstract AuthLogin queryAuthLoginByName(String username);  
}