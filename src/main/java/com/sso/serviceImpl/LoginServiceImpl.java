package com.sso.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import com.sso.dao.AuthTokenConfigDao;
import com.sso.dao.AuthLoginDao;
import com.sso.dao.AuthUserDao;
import com.sso.domain.AuthLogin;
import com.sso.domain.User;
import com.sso.service.LoginService;
import com.sso.util.JWT;
import com.sso.util.MD5Tools;
import com.sso.util.StringExtend;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private AuthLoginDao authLoginDao;
	@Resource
	private AuthUserDao userDao;
	@Resource
	private AuthTokenConfigDao authTokenConfigDao;

	/*
	 * 登录
	 */
	@Override
	public User checkIn(String username, String password) {
	 	String md5Password = MD5Tools.encode(password);
		User tempUser = userDao.findByUsername(username, md5Password);
		if (tempUser != null) {
			InsertLoginAndJWT(tempUser);
		} else {
			tempUser = new User();
			tempUser.seteMail(username);
			tempUser.setErrorInfo("登录失败");

		}
		return tempUser;
	}

	/**
	 * 插入到登录Login表中
	 * 
	 * @param tempUser
	 */
	private void InsertLoginAndJWT(User tempUser) {
		// 得到默认配置时间
		int day = authTokenConfigDao.getDayConfig();
		long userId = tempUser.getId();
		long tableIndexL = (userId % 10l);
		String tabIndex = StringExtend.autoGenericCode(Long.toString(tableIndexL), 2);
		// 创建Login对象，分配JWT token
		AuthLogin authLogin = new AuthLogin();
		Date now = new Date();
		authLogin.setBeginDate(now);
		authLogin.setEndDate(DateUtils.addDays(now, day));
		authLogin.setIsExpire(1);
		authLogin.seteMail(tempUser.geteMail());
		authLogin.setTabIndex(tabIndex);
		String jwttoken = JWT.sign(authLogin, 60L * 1000L * day);
		authLogin.setToken(jwttoken);
		tempUser.setToken(jwttoken);
		authLoginDao.updateAuthLogin(authLogin);
		authLoginDao.insertAuthLogin(authLogin);

	}

	@Override
	public void Register(User user) {
		if (!checkRegister(user.geteMail()))
			user.setTextVail("用户已经注册！");
		String md5Password = MD5Tools.encode(user.getPassWord());
		user.setPassWord(md5Password);

		Date now = new Date();
		user.setRegisterTime(now);
		user.setInsertTime(now);
		user.setUpdateTime(now);

		userDao.registerUser(user);

	}

	@Override
	public boolean checkRegister(String email) {
		User user = userDao.checkRegister(email);
		if (user != null)
			return false;
		else
			return true;

	}

	@Override
	public String passPort(AuthLogin user) {
		return null;
	}

}
