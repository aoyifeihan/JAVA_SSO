package com.sso.dao;


import com.sso.domain.User2Role;

public interface AuthUser2RoleDao {
    public abstract User2Role findByUserId(Long Id);
   
}