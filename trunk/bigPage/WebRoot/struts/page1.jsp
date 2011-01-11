<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>page1</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/bigPage/js/jquery.js"></script>
<script type="text/javascript" src="/bigPage/js/jquery.bigpage.js"></script>
<link type="text/css" rel="stylesheet" href="/bigPage/css/bigpage.css" >

<script type="text/javascript">
	$(function(){
		$("table").bigPage({ajaxData:{url:"data1.action",batch:false},pageSize:7,cssWidgets:["appendToTable","eventColor"],callback:function(){
			$("#curentPage").html(bigPage.toPage());
			$("#count").html(bigPage.pageNumber());		
		}});
	})
</script>
</head>
<body>
<br/>
<br/>
<div>源码：</div>
<div style="background-color: #f4f4f4" >
<pre>
	$(function(){
		$("tTable").bigPage({ajaxData:{url:"data1.action",batch:false},pageSize:7,cssWidgets:["appendToTable","eventColor"],callback:function(){
			$("#curentPage").html(bigPage.toPage());
			$("#count").html(bigPage.pageNumber());		
		}});
	})	
</pre>
</div>
<div>效果：</div>
<br/>
<div style="width: 600px" >
<table class="tb1">
	<thead>
		<tr>
			<th width="200px">网站名称</th>
			<th width="100px">网址</th>
			<th width="100px">知名度</th>
			<th width="120px">访问量</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<div class="dl">
	共&nbsp;<span id="count" style="color: red" >0</span>&nbsp;页
	<a class="page-start" href="#" id="firstA" >第一页</a>
	<a class="page-start" href="#" id="prevA" accesskey="p" >上一页</a>
	<a class="page-end" href="#"  id="nextA" accesskey="n" >下一页</a>
	<a class="page-end" href="#"  id="lastA"  >末一页</a>
	当前&nbsp;<span style="color: red" id="curentPage"></span>&nbsp;页
	 跳转到 <input id="toPageText" type="text" size="3" maxlength="3" > 页  <a class="page-next" href="#"  id="skipA"  >GO</a>
</div>
</div>
 	<script type="text/javascript">
		$(function(){
			$("#firstA").click(function(){
				if(window.bigPage)bigPage.firstPage();
			});
			$("#prevA").click(function(){
				if(window.bigPage)bigPage.prevPage();
			});
			$("#nextA").click(function(){
				if(window.bigPage)bigPage.nextPage();
			});
			$("#lastA").click(function(){
				if(window.bigPage)bigPage.lastPage();
			});
			$("#skipA").click(function(){
				if(window.bigPage)bigPage.skipPage($("#toPageText").val());
			});
		});
 	</script>
</body>
</html>