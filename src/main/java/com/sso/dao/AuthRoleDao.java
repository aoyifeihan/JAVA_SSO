package com.sso.dao;

import com.sso.domain.Role;

public interface AuthRoleDao {
    public abstract Role findByRoleId(Long Id);
   
}