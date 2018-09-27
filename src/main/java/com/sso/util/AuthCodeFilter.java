package com.sso.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.maven.wagon.observers.Debug;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sso.domain.AuthLogin;

/**
 * OncePerRequestFilter 确保一个请求只经过一个filter,而不需要重复执行
 * 
 * @author
 * 
 */
public class AuthCodeFilter extends OncePerRequestFilter {
	Pattern _pattenUrl;
	Pattern _pattenContentType;
	boolean _enbale = true;

	@Override
	protected void initFilterBean() throws ServletException {
		FilterConfig conf = this.getFilterConfig();
		String enable = conf.getInitParameter("enable");
		String regex = conf.getInitParameter("exclude_url");
		String regexContentType = conf.getInitParameter("content_type");
		// Debug.printFormat("{2} init-param: enable={0};exclude_url={1}",
		// enable, regex, this.getClass().getName());

		_pattenContentType = Pattern.compile(regexContentType, Pattern.CASE_INSENSITIVE);
		_enbale = StringExtend.getBoolean(enable);
		// 初始化正则验证器
		if (_pattenUrl == null) {
			// 忽略大小写
			_pattenUrl = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

			// Debug.printFormat("{2}初始化；Enable={1};content-type正则：{3}；url正则
			// ={0};", regex, _enbale,
			// this.getClass().getSimpleName(), regexContentType);
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {

		
		// 指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 响应类型
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
		// 响应头设置
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, x-requested-with,X-Token, X-Custom-Header, HaiYi-Access-Token");
		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpStatus.SC_NO_CONTENT);
		}

		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		// 是否启用筛选器
		if (!_enbale) {
			filter.doFilter(request, response);
			return;
		}

		// 1 处理 request 请求信息
		// 1.1 不验证的资源
		Matcher matcher = _pattenUrl.matcher(url);
		if (matcher.find()) {
			filter.doFilter(request, response);
			return;
		}

		String token = "";

		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {

				if ("token".equals(cookie.getName())) {
					token = cookie.getValue();
					if (!"undefined".equals(token)) {
						AuthLogin auth2 = JWT.unsign(token, AuthLogin.class);
					}
					filter.doFilter(request, response);// 跳转
					break;
				}

			}

		} else {
			filter.doFilter(request, response);
		}

	}
}