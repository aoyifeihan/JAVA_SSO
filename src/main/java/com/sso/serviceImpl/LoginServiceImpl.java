package com.sso.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import com.sso.dao.AuthTokenConfigDao;
import com.sso.dao.AuthLoginDao;
import com.sso.dao.UserDao;
import com.sso.domain.AuthLogin;
import com.sso.domain.User;
import com.sso.service.LoginService;
import com.sso.util.JWT;
import com.sso.util.MD5Tools;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private AuthLoginDao authLoginDao;
	@Resource
	private UserDao userDao;
	@Resource
	private AuthTokenConfigDao authTokenConfigDao;

	@Override
	public User checkIn(String username, String password) {
		User tempUser = null;
		AuthLogin authLogin = authLoginDao.queryAuthLoginByName(username);
		if (authLogin == null) {
			String md5Password = MD5Tools.encode(password);
			tempUser = userDao.findByUsername(username, md5Password);
			if (tempUser != null) {
				InsertLoginAndJWT(tempUser);
			}

		} else {
			tempUser = new User();
			tempUser.seteMail(authLogin.geteMail());
			tempUser.setToken(authLogin.getToken());
		}

		return tempUser;
	}

	private void InsertLoginAndJWT(User tempUser) {
		int day = authTokenConfigDao.getDayConfig();
		AuthLogin authLogin = new AuthLogin();
		Date now = new Date();
		authLogin.setBeginDate(now);
		authLogin.setEndDate(DateUtils.addDays(now, day));
		authLogin.setIsExpire(1);
		authLogin.seteMail(tempUser.geteMail());
		String jwttoken = JWT.sign(authLogin, 60L * 1000L * 60L * 24L * day);
		authLogin.setToken(jwttoken);
		tempUser.setToken(jwttoken);
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
