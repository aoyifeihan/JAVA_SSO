package com.sso.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sso.dao.AuthLoginDao;
import com.sso.dao.AuthUserDao;
import com.sso.domain.AuthLogin;
import com.sso.domain.User;
import com.sso.dto.ResponseDTO;
import com.sso.dto.TokenDTO;
import com.sso.dto.UserInfoDTO;
import com.sso.service.LoginService;
import com.sso.service.UserInfoService;
import com.sso.util.DateUtils;
import com.sso.util.JWT;
import com.sso.util.JsonView;
import com.sso.util.MD5Tools;
import com.sso.util.StringExtend;
import com.sso.util.data.CustomerContextHolder;
import com.sso.util.redis.RedisUtil;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	/**
	 * 登录、token服务
	 */
	@Resource(name = "UserInfoService")
	private UserInfoService userInfoService;
 
	/**
	 * @param token验证
	 * @return 返回{"code":20000,"data":{"roles":["admin"],"name":"admin","avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"}}
	 * @throws Exception
	 */
	@RequestMapping(value = "/GetUserInfo", method = RequestMethod.GET)
	@ResponseBody
	public String GetUserInfo(String token) throws Exception {
		
		String strResult="{\"code\":20000,\"data\":{\"roles\":[\"admin\"],\"name\":\"admin\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"}}";
//		userInfoService.getInfo(user);
//		RedisUtil redis = RedisUtil.getInstance();
//		AuthLogin loginInfo = (AuthLogin) redis.get(user.getToken());
//		loginInfo.getUserId()
		return strResult;
	}

 

}