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
    
    <title>问卷结果列表</title>
    
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
   <form name="indaResultForm" action="" method="post">	
  	<input name="indagateResult.indar_id" type="hidden" value=""/>
  <div class="STYLE1">问卷调查结果列表页面</div>
  	<table width="100%"  cellpadding="0" cellspacing="0">
  		<tr bgcolor="#DCE8ED"> 
  			<td height="35px" >问卷结果编号</td>
  			<td>填写人</td>
  			<td>开始时间</td>
  			<td>结束时间</td>
  			<td>共有时长</td>
  			<td>操作</td>
  		</tr> 
  		<c:forEach items="${requestScope.inda_ResultList}" var="indagate_result" varStatus="step">
    	<tr bgcolor="${step.count%2==0?'#DCF3F2':'#E7DFF9' }">
  			<td  height="25px">${indagate_result.indar_no }</td>
  			<td><a>${indagate_result.indar_person }</a></td>
  			<td>${indagate_result.indar_start_time }</td>
  			<td>${indagate_result.indar_end_time }</td>
  			<td>${indagate_result.indar_time }</td>
  			<td width="125px"><input  onClick="getIndagateRInfo('${indagate_result.indar_id}')" type="button" value="查看详细"/>&nbsp;<!-- <input type="button" onClick="deleteIndagateResultInfo('${indagate_result.indar_id}')" value="删除"/> --></td>
  		</tr>
      </c:forEach>
      <tr bgcolor="#8995FE">
		  		<td colspan="8" height="30" align="right" valign="middle"><a href="proj/questionnaire/naire_new.jsp"></a></td>
		  		
  			</tr>
  	</table>
  </form>
  <script>
  	function getIndagateRInfo(indar_id){
  			document.indaResultForm["indagateResult.indar_id"].value=indar_id;
  			document.indaResultForm.action="indagateResultAction!getInda_ResultDetail.action";
  			document.indaResultForm.submit();
  		}
  </script>
  </body>
</html>
