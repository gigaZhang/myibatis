<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>page4</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/bigPage/js/jquery.js"></script>
<script type="text/javascript" src="/bigPage/js/jquery.bigpage.js"></script>
<link type="text/css" rel="stylesheet" href="/bigPage/css/bigpage.css" >

<script type="text/javascript">
	$(function(){
		$("table").bigPage({ajaxData:{url:"data2.action",batch:true},pageSize:7,cssWidgets:["appendToTable","eventColor2"],callback:function(){
			$("#curentPage").html(bigPage.toPage());
			$("#count").html(bigPage.pageNumber());		
		}});
	})
	
	function search(){
		bigPage.trigger("update",{ajaxData:{url:"data2.action",params:{keyword:$("#keyword").val()},batch:true}});
	}
	function skipPage(num){
		if(window.bigPage) bigPage.skipPage(num);
	}
</script>
</head>
<body>
<br/>
<div>源码：</div>
<div style="background-color: #f4f4f4" >
<pre>
	$(function(){
		//使用cssWidgets：cssWidgets渲染样式可以实现google分页的效果
		$("tTable").bigPage({ajaxData:{url:"data2.action",batch:true},pageSize:7,cssWidgets:["appendToTable","eventColor2"],callback:function(){
			$("#curentPage").html(bigPage.toPage());
			$("#count").html(bigPage.pageNumber());		
		}});
	})	
	
	function search(){
		bigPage.trigger("update",{ajaxData:{url:"data2.action",params:{keyword:$("#keyword").val()},batch:true}});
	}	
</pre>
</div>
<div>效果：</div>
<br/>
<div style="width: 600px" >
<table class="tb1">
	<div>
		网站名称:&nbsp;<input id="keyword" type="text" value="" ><input type="button" id="searchBn" value="查询" onclick="search()" >
		<br/>
		<br/>
	</div>
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
	<table>
		<tr>
			<td><a href="#" id="prevA" accesskey="p" >上一页</a></td>
			<td id="nextPageTD" ><a href="#"  id="nextA" accesskey="n" >下一页</a></td>
			<td>&nbsp;共&nbsp;<span id="count" style="color: red" >0</span>&nbsp;页</td>
		</tr>
	</table>
</div>
</div>
 	<script type="text/javascript">
		$(function(){
			$("#prevA").click(function(){
				if(window.bigPage)bigPage.prevPage();
			});
			$("#nextA").click(function(){
				if(window.bigPage)bigPage.nextPage();
			});
		});
 	</script>
</body>
</html>