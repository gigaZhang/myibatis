<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <!-- <div style="font-size:30px;color:red;">制作播放器</div>-->
  <!-- <div>
    <object id="mPlayer1" width=300 height=300 classid="CLSID:6BF52A52-394A-11D3-B153-00C04F79FAA6">
		<param name="URL" value="f://b77c0be49f226269_2.wma">
        <param name="rate" value="1"><!-- 速率 -->
        <param name="balance" value="0"><!-- 均衡 -->
        <param name="currentPosition" value="0"><!-- 当前位置 -->
        <param name="defaultFrame" value><!-- 默认框架 -->
        <param name="playCount" value="100"><!-- 播放总数 -->
        <param name="autoStart" value="1">
        <param name="currentMarker" value="0">
        <param name="invokeURLs" value="1">
        <param name="baseURL" value>
        <param name="volume" value="100">
        <param name="mute" value="0">
        <param name="uiMode" value="mini">
        <param name="stretchToFit" value="0">
        <param name="windowlessVideo" value="0">
        <param name="enabled" value="1">
        <param name="enableContextMenu" value="1">
        <param name="fullScreen" value="0">
        <param name="SAMIStyle" value="4">
        <param name="SAMILang" value="2">
        <param name="SAMIFilename" value>
        <param name="captioningID" value>
        <param name="enableErrorDialogs" value="0">
        <param name="_cx" value="7779">
        <param name="_cy" value="1693">
      </object>
     </div>  -->
     
     <div><a href="indagateAction!getIndagateList.action">问卷调查</a></div>
     <div><a href="proj/test/test_json.jsp">json</a></div>
     <div><a href="proj/system/htmlblock_manage.jsp">自动推送后台</div>
     <div><a href="proj/system/living_girl.jsp">优活女人</div>
     <div><a href="test.html">日历/编辑器</div>
     
     <div></div>
     
  </body>
</html>
