package com.sso.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;


import com.sso.dao.*;

import com.sso.domain.*;

import com.sso.dto.UserInfoDTO;
import com.sso.service.LoginService;
import com.sso.service.UserInfoService;
import com.sso.util.JWT;
import com.sso.util.MD5Tools;
import com.sso.util.StringExtend;
import com.sso.util.redis.RedisUtil;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private AuthUser2RoleDao authUser2Role;
	@Resource
	private AuthRoleDao authroleDao;
	 
	@Override
	public User getInfo(UserInfoDTO user) {
		// TODO Auto-generated method stub
		
		RedisUtil redis = new RedisUtil();
		AuthLogin loginInfo = (AuthLogin) redis.get(user.getToken());
		User2Role user2role= authUser2Role.findByUserId(loginInfo.getUserId());
		Role role = authroleDao.findByRoleId(user2role.getRoleid());
		return null;
	}

 

}
