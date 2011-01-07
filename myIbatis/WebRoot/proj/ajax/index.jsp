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

	<style>
		input{border-top:0px solid #b0bec7;border-bottom:1px solid #b0bec7;border-left:0px solid #b0bec7;border-right:0px solid #b0bec7;}
		
	</style>
  </head>
  
  <body>
 	<form name="testfr" action="/myIbatis/proj/ajax/action.jsp" target="dologin"  method="post">
 		DOOR:<input  type="text" name="username"></input><Br>
 		KAY:<input type="text" name="password"></input><Br>
 		 <input type="submit"  value="登录" />
 	</form>
 	<iframe name="dologin" style="display:none"></iframe>
  </body>
</html>
