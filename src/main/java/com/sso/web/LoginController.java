package com.sso.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sso.dao.AuthLoginDao;
import com.sso.dao.UserDao;
import com.sso.domain.User;
import com.sso.service.LoginService;
import com.sso.util.DateUtils;
import com.sso.util.JsonView;
import com.sso.util.MD5Tools;

/**
 * �û�������
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	/**
	 * ��¼��token����
	 */
	@Resource(name = "LoginService")
	private LoginService loginService;

	@RequestMapping(value = "/passport", method = RequestMethod.POST)
	public ModelAndView passport(HttpServletResponse response, HttpSession session, String type) {

		if ("json".equals(type)) {
			User user = new User();
			return JsonView.Render(user, response);// �����նˣ�����ע��ɹ��� JSON ��

		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/View/index.jsp");
			return mav;

		}

	}

	/**
	 * ��¼����
	 * 
	 * @param �û���
	 * @param ����
	 * @return �ɹ�ʧ��
	 * @throws ParseException
	 */
	@RequestMapping(value = "/checkIn", method = RequestMethod.POST)
	@ResponseBody
	public String checkIn(String username, String password) throws Exception {

		User tempUser = loginService.checkIn(username, password);
		String strResult = "";
		if (tempUser != null) {
			strResult = SetInfo("ok", tempUser.getToken());
		} else {
			strResult = SetInfo("error", "");
		}
		return strResult;
	}

	/**
	 * ע�᷽��
	 * 
	 * @param �û���
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView Register(User user) {
		loginService.Register(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/View/index.jsp");
		return mav;

	}

	/**
	 * ����û����Ƿ����
	 * 
	 * @param �û���Email
	 * @return
	 */
	@RequestMapping(value = "/checkRegister", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkRegister(String email) {
		boolean flag = loginService.checkRegister(email);
		String strResult = "";
		if (flag)
			strResult = SetInfo("ok");
		else
			strResult = SetInfo("�Ѿ�ע�ᣬ������û���");
		return strResult;
	}

	private String SetInfo(String info)
	{
		return SetInfo(info, "");
	}

	/**
	 * ˽�з����������ַ���
	 * 
	 * @param info
	 * @return
	 */
	private String SetInfo(String info, String token) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("result", info);
		jsonMap.put("token", token);
		return JSONObject.toJSONString(jsonMap);

	}

}