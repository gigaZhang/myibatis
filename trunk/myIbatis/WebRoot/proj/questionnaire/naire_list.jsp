<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>list</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
	background-color:#8995FE;
	height:30px;
	
}
-->
    </style>
</head>
  <body>
  <form name=indaForm action="" method="post">	
  	<input name="indagateResult.inda_id" type="hidden" value=""/>
  	<input name="indagate.inda_id" type="hidden" value=""/>
  <div class="STYLE1">问卷调查管理页面</div>
  	<table width="100%" border="0.5" bordercolor="#999999" cellpadding="0" cellspacing="0">
  		<tr bgcolor="#DCE8ED"> 
  			<td height="35px" ><b>问卷编号</b></td>
  			<td><b>问卷标题</b></td>
  			<td><b>问卷主题</b></td>
  			<td><b>问卷发起人</b></td>
  			<td><b>问卷开始时间</b></td>
  			<td><b>问卷结束时间</b></td>
  			<td><b>所在频道</b></td>
  			<td><B>操作</B></td>
  		</tr> 
  		<c:forEach items="${requestScope.indagateList}" var="indagate" varStatus="step">
    	<tr bgcolor="${step.count%2==0?'#DCF3F2':'#E7DFF9' }">
  			<td  height="25px"><a onClick="getIndagateInfo('${indagate.inda_id}')">${indagate.inda_no }</a></td>
  			<td><a onClick="getIndagateInfo('${indagate.inda_id}')">${indagate.inda_title }</a></td>
  			<td>${indagate.inda_theme }</td>
  			<td>${indagate.inda_person }</td>
  			<td>${indagate.inda_start_time }</td>
  			<td>${indagate.inda_end_time }</td>
  			<td>${indagate.channelId }</td>
  			<td width="125px"><input onClick="getIndagateResultList('${indagate.inda_id}')" type="button" value="查看结果"/>&nbsp;<input type="button" onClick="deleteIndagateInfo('${indagate.inda_id}')" value="删除"/></td>
  		</tr>
      </c:forEach>
		    <tr bgcolor="#8995FE">
		  		<td colspan="8" height="30" align="right" valign="middle"><a href="proj/questionnaire/naire_new.jsp">新建问卷</a></td>
		  		
  			</tr>
  	</table>
  	
  	<script>
  		function getIndagateInfo(inda_id){
  			document.indaForm["indagate.inda_id"].value=inda_id;
  			document.indaForm.action="indagateAction!getIndagateInfo.action";
  			document.indaForm.submit();
  		}
  		function deleteIndagateInfo(inda_id){
  			document.indaForm["indagate.inda_id"].value=inda_id;
  			document.indaForm.action="indagateAction!deleteIndagateInfo.action";
  			document.indaForm.submit();
  		}
  		function getIndagateResultList(inda_id){
  			document.indaForm["indagateResult.inda_id"].value=inda_id;
  			document.indaForm.action="indagateResultAction!getInda_ResultList.action";
  			document.indaForm.submit();
  		}
  	</script>
  </form>
  </body>
</html>
  			