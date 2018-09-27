package com.sso.dao;

import com.sso.domain.User;

public interface AuthUserDao {
    public abstract User findByUsername(String username,String password);
    public abstract User registerUser(User user);
    public abstract User checkRegister(String email);
}