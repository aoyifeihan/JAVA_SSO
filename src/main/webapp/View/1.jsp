<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>iview example</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/vue.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/axios.min.js"></script>
</head>
<body>
	<div id="app">
		<button @click="checkIn()">Click me!</button>

	</div>
	<script>
		new Vue(
				{
					el : "#app",
					data : {},

					methods : {
						checkIn:function ()
		 				{
							var params = new URLSearchParams();
							params.append('username', '1');
							params.append('password', '1');
							var thvue = this;
							//发起一个user请求，参数为给定的ID
							axios.get('${pageContext.request.contextPath}/othersys/getToken',params)
							.then(function(respone){
								thvue.setCookie("token",respone.data.token)
								//top.location = '${pageContext.request.contextPath}/main/checkpassport';
							})
							.catch(function(error){
							    console.log(error);
							});
		 				},
						//设置cookie
						setCookie : function(name,value) {
					
							
							var exdays = 30;
							var d = new Date();
							d.setTime(d.getTime()
									+ (exdays * 24 * 60 * 60 * 1000));
							var expires = "expires=" + d.toUTCString();
							document.cookie = name+"="+value+"; expires="
									+ d.toGMTString();
							var cookiesEnabled = document.cookie
									.indexOf("token=") != -1;
							if (!cookiesEnabled) {
								//没有启用cookie   
								alert("没有启用cookie ");
							} else {
								//已经启用cookie   
								//alert("已经启用cookie ");
							}

						},
						//获取cookie
						getCookie : function(cname) {
							var name = cname + "=";
							var ca = document.cookie.split(';');
							for (var i = 0; i < ca.length; i++) {
								var c = ca[i];
								while (c.charAt(0) == ' ')
									c = c.substring(1);
								if (c.indexOf(name) != -1)
									return c.substring(name.length, c.length);
							}
							return "";
						} 
					}
				})
	</script>
</body>
</html>