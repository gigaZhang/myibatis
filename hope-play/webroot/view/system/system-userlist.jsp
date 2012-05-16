<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="/view/commons/common_header.jsp" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>test-list</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
<script>
function searchQuery(data) {
	//查询
    var tmp = {"currentPage":$("#currentPageTmp").val(),"pageSize":$("#pageSizeTmp").val()};
	jQuery.extend(tmp, data);
	$("#sercheId").attr('action',"<%= request.getContextPath()%>/system/system!queryUser.do")
	//$("#sercheId").submit();
	PB.Tools.commonSearchQuery('mainmiddle', 'sercheId', tmp);

}

</script>
	</head>

<body>
 <s:form action="/system/system!queryUser.do" method="post" name="searchForm" id="sercheId">
		<div id="mainmiddle" >
		<div id="top">
			<a href="/system/system!addUser.do">增加用户</a>
		</div>
		
		<table class="scroll_table" border="0" cellspacing="0"  cellpadding="0" width="100%" >
			<thead>
    		 <tr> 
         		<th>用户名</th>
         		<th>密码</th>
         		<th>全名</th>
   			  </tr>
			</thead>
			<tbody>
		        <s:iterator id="rs" value="searchDto.resultList" status="ids">
			        <tr resid="${ids.index}" id="tr${ids.index}">
			            <td>${rs.userName}&nbsp;</td>
			            <td>${rs.password}&nbsp;</td>
			            <td>${rs.realName}&nbsp;</td>
			        </tr>
		        </s:iterator>
			</tbody>
		</table>
		<displaywrap:pagination2 name="_pagination" requestURI=""  formId="" loadFunction="loadingFunc" submitCall="searchQuery" />
		</div>
		<div id="tail"></div>
		
</s:form>

</body>

</html>
