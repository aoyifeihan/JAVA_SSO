package com.sso.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sso.dao.AuthLoginDao;
import com.sso.dao.HouseDataConfigDao;
import com.sso.domain.HouseDataConfig;
import com.sso.domain.User;
import com.sso.util.JsonView;
import com.sso.util.data.CustomerContextHolder;

@Controller
@RequestMapping(value = "/ManyDBTest")
public class ManyDBTestController {
	@Resource
	private HouseDataConfigDao houseDataConfigDao;

	@RequestMapping(value = "/testManySource", method = RequestMethod.GET)
	public String passport(HttpServletResponse response, HttpSession session, String type) {
		String tempX = CustomerContextHolder.getCustomerType();
		System.out.printf(tempX == null ? "" : tempX);
//		CustomerContextHolder.setCustomerType("fangjiaSource");
//		String tempX2 = CustomerContextHolder.getCustomerType();
		List<HouseDataConfig> temp = houseDataConfigDao.queryAllHouseDataConfig();
		HouseDataConfig tempX1 = temp.get(0);
		return "";

	}
}
