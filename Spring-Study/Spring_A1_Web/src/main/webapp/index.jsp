<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.lumlb.spring.service.UserService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
    
    <%
    	String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
   		WebApplicationContext ctx = (WebApplicationContext)application.getAttribute(key);
    	out.print(ctx + "<br>");
    	
    	UserService userService = (UserService)ctx.getBean("userService");
    	userService.save();
    	
    	
    	ctx = WebApplicationContextUtils.getWebApplicationContext(application);
    	out.print(ctx);
    	
    	out.print("<br>" + ctx.getClass().getSimpleName());
    %>
  </body>
</html>
