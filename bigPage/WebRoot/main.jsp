<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>main</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/bigPage/js/jquery.js"></script>
<script type="text/javascript" src="/bigPage/js/jquery.bigpage.js"></script>
<link type="text/css" rel="stylesheet" href="/bigPage/css/bigpage.css" >

</head>
<body>
	<table class="tb1">
		<tr class="qh" >
			<td rowspan=7>
				一次性传入数据	
			</td>
			<td>
				<a href="page1.html" target="_blank" >传入数组数据1</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td>
				<a href="page2.html" target="_blank" >传入数组数据2</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td>
				<a href="page3.html" target="_blank" >传入字符串数据</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td>
				<a href="page4.html" target="_blank" >修改默认的pageSize</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td>
				<a href="page5.html" target="_blank" >修改默认的toPage(页码)</a>
			</td>	
		</tr>	
		<tr class="qh" >
			<td>
				<a href="page6.html" target="_blank" >自定义渲染组件并应用到table(隔行变色)</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td>
				<a href="page1.action" target="_blank" >ajax从后台一次性取数据</a>
			</td>	
		</tr>											
		<tr class="qh1" >
			<td rowspan=2>
				ajax后台去数据<br/>
				（用法与一次性传入数据一样，重复的不再赘述）
			</td>
			<td>
				<a href="page2.action" target="_blank" >ajax分页每次取数据</a>
			</td>	
		</tr>
		<tr class="qh1" >
			<td>
				<a href="page3.action" target="_blank" >ajax分页加查询条件</a>
			</td>	
		</tr>
		<tr class="qh" >
			<td rowspan=6>
				google类似的分页样式
			</td>
			<td>
				<a href="page4.action" target="_blank" >查看</a>
			</td>	
		</tr>		
		
	</table>
</body>
</html>