<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%
// String titleName=GlobalKeys.getFunctionConfig("app_name");
// String areaCode = GlobalKeys.getFunctionConfig("area_code");
%>
<%@ include file="/view/commons/base.jsp" %>
<%-- <title><%=titleName%></title> --%>
<!-- jquery start -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources1/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/pb.base.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/pb.mainui.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/pb.tools.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/pb.monitor.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/pb.viewui.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/common-dialog.js" ></script>
<script src="<%=request.getContextPath()%>/resources1/js/MapJs.js" language="javascript"></script>
<script type=text/javascript src="<%=request.getContextPath()%>/resources1/js/commonFun.js"></script>

<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.blockUI.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.form.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.scrolltable.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.seantabs.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.othervalidate.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.validate.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/messages_cn.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.bgiframe.min.js" ></script>
<%-- <script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jquery.mulitselector.js" ></script> --%>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/ligerDialog.js" ></script>
<!-- 提示 
-->
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/common-tools.js" ></script>
<!-- 提示 -->
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/boxynew/jbox.js" ></script>

<!--  my jquery-->
<!-- 时间控件 -->
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/datePicker/WdatePicker.js" ></script>


<!-- css start -->
<!--sean css  -->
<link href="<%=  request.getContextPath()%>/resources1/css/default.css" rel="stylesheet" type="text/css" media="screen" />


<!--sean css end  -->


<link href="<%=  request.getContextPath()%>/resources1/css/pagination.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=  request.getContextPath()%>/resources1/css/scrolltable/scroll_table.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=  request.getContextPath()%>/resources1/css/msg.css" rel="stylesheet" type="text/css" media="screen" />


<link href="<%=  request.getContextPath()%>/resources1/js/boxynew/css/jbox.css" rel="stylesheet" type="text/css" media="screen" />
<!-- 提示样式 -->

<!-- 提示样式 

-->
<link rel="stylesheet" href="<%=  request.getContextPath()%>/resources1/css/liger/ligerMessageBox.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=  request.getContextPath()%>/resources1/css/liger/ligerDialog.css" rel="stylesheet" type="text/css" media="screen" />
<!--dhtml start -->
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/dhtml/dhtmlxcommon.js" ></script>
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/dhtml/dhtmlxtree.js" ></script>		
<link rel="stylesheet" href="<%=  request.getContextPath()%>/resources1/js/dhtml/dhtmlxtree.css" rel="stylesheet" type="text/css" media="screen" />	
<!-- dhtml end -->
<!-- jdiv start-->
<link href="<%=  request.getContextPath()%>/resources1/js/jDiv/css/jDiv.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="<%=  request.getContextPath()%>/resources1/js/jDiv//jDiv.js" ></script>	
<!-- jdiv end-->
<!-- 肖飞的样式 -->
<link href="<%=  request.getContextPath()%>/resources1/css/default.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=  request.getContextPath()%>/resources1/css/index_search.css" rel="stylesheet" type="text/css" />
<link href="<%=  request.getContextPath()%>/resources1/css/seantabs.css" rel="stylesheet" type="text/css" />

</head>

<body >
<script type="text/javascript">
	if(PB == undefined)
	{
		PB = new Object();
	}
	PB.ContextPath = '<%= request.getContextPath()%>';
	$(function(){
 		$(".searchdiv .search_btn").mousedown(function(){$(this).addClass("search_btn_down");}).mouseup(function(){$(this).removeClass("search_btn_down");});
	});	

</script>
