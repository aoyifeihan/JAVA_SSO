package com.sso.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sso.util.ConfigUtil;
import com.sso.util.HttpUtil;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/othersys")
public class OtherSysController {

	/**
	 * 登录方法
	 * 
	 * @param 用户名
	 * @param 密码
	 * @return 成功失败
	 * @throws ParseException
	 */
	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	@ResponseBody
	public String checkIn() throws Exception {
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("username", "1");
		temp.put("password", "1");
	
		String url =ConfigUtil.get("url");
		String temp2 = HttpUtil.doPost(url, temp);
		 Map<String,String> map1 = (Map<String,String>)JSON.parse(temp2);
		return temp2;
	}

}