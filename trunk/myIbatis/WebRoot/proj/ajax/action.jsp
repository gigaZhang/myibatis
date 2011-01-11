<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>study ajax</title>
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
  <%
  	String username = request.getParameter("username");
  	String password = request.getParameter("password");
  	if("lph".equals(username) && "lph".equals(password)){
  		out.print("<script>alert('登录成功！');window.parent.location.href=window.parent.location.href;</script>");
  	}else{
  		out.print("<script>alert('登录失败！');window.parent.location.href=window.parent.location.href;</script>");
  	}
   %>
  </body>
 </html>