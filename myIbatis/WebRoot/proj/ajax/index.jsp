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
	<script type="test/javascript" src="dwr/interface/JDate.js"></script>
	<script type="test/javascript" src="dwr/engine.js"></script>
	<script>
		function init(){
			JDate.getYear(load);
		}
		function load(date){
			alert(data+1900+'年')；
		}
	</script>
	
  </head>
  
  <body onload="init()">
 	<form>
 		DOOR:<input type="text" name="username"></input><Br>
 		KAY:<input type="text" name="password"></input><Br>
 		 <button type="submit" value="登录" />登录</button>
 	</form>
  </body>
</html>
