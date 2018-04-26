package com.sso.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * ÓÃ»§¿ØÖÆÆ÷
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
	@RequestMapping(value = "/checkpassport", method = RequestMethod.GET)
	public ModelAndView passport(HttpServletResponse response, HttpSession session, String type) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/View/login.jsp");
		return mav;

	}
}
