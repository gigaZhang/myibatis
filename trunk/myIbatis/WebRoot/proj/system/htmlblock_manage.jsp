<%@ page language="java" import="java.util.*,jcx.db.*" pageEncoding="utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="/WEB-INF/inc/simpletld.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>页面区块管理</title>
</head>

<body>

<table width="100%" border="0" style="height:7px; background:#F4FDFE" align="center">
 <s:form action="" theme="simple" name="blockform">    

  <tr class="title_1">
    <td><i>页面区块管理</i></td>
  </tr>
  
  <tr>
  <td>
	  <table width="100%" border="0" style="height:7px; background:#F4FDFE">
	  <tr>
	  	<td width="100%" valign="top">
	  		<s:select name="mapno" onchange="submitQuery('submitQuery')" list="#{'':'请选择','21':'上海','25':'南京','571':'杭州','20':'广州','27':'武汉'}"></s:select>
	  		<select name="mhcmodule" onchange="submitQuery('submitQuery')">
				<option value="">请选择</option>
				<c:forEach items="${moduleList}" var="ml" varStatus= "tag">
					<option value="${ml.mhc_module}" <c:if test="${mhcmodule==ml.mhc_module}"> selected </c:if> >${ml.mhc_module}</option>
				</c:forEach>
			</select>
	  		<select name="mhcid" onchange="submitQuery('submitQuery')">
			  	<option value="">添加区域</option>
				<c:forEach items="${nameList}" var="nl" varStatus= "tag">
					<option value="${nl.mhc_id}" <c:if test="${mhcid==nl.mhc_id}"> selected </c:if> >${nl.mhc_name}</option>
				</c:forEach>
			</select>
			<c:if test="${mhcid eq ''}">
				<c:if test="${mhcmodule ne ''}">
					<input type="button" name="btn" value="全部初始化" onClick="submitQuery('initialMstHtmlCreator')">
					<input type="button" name="btn" value="全部删除" onClick="submitQuery('deleteMstHtmlCreator')">
				</c:if>
			</c:if>
	  	</td>
	  </tr>
	  <tr>
	  	<td>
	  		<table width="100%" border="1">
				<s:hidden name="creator.mhc_id" theme="simple"/>区域ID：${creator.mhc_id}
				<b>区域名：</b><s:textfield name="creator.mhc_name" theme="simple"></s:textfield>
				<b>输入文件：</b><s:textfield name="creator.mhc_url" theme="simple"></s:textfield>
				<b>输出文件：</b><s:textfield name="creator.mhc_outurl" theme="simple"></s:textfield>
				<b>频道：</b><s:textfield name="creator.mhc_module" theme="simple"></s:textfield>
				<br>
				<b>图片数：</b><s:textfield name="creator.pic_counts" theme="simple" size="4"></s:textfield>
				<b>文本数：</b><s:textfield name="creator.txt_counts" theme="simple" size="4"></s:textfield>
				<b>效果：</b><s:textfield name="creator.mhc_color" theme="simple" size="4"></s:textfield>
				<b>关键字：</b><s:textfield name="creator.mhc_keyword" theme="simple" size="4"></s:textfield>
				<b>标题限制：</b><s:textfield name="creator.mhc_titsize" theme="simple" size="5"></s:textfield>
				<b>描述限制：</b><s:textfield name="creator.mhc_descsize" theme="simple" size="5"></s:textfield>
				<b>排序：</b><s:textfield name="creator.mhc_order" theme="simple" size="5"></s:textfield>
				<br>
				<b>预览地址：</b><s:textfield name="creator.mhc_preview" theme="simple" size="50"></s:textfield>
				<br>
				<b>发布地址：</b><s:textfield name="creator.mhc_published" theme="simple" size="50"></s:textfield>
				<br>
				<b>输出路径：</b><s:textfield name="creator.mhc_outpath" theme="simple" size="50"></s:textfield>
				<br>
				<b>模板路径：</b><s:textfield name="creator.mhc_inpath" theme="simple" size="30"></s:textfield>
				<b>统计代码：</b><s:textfield name="creator.mhc_stat" theme="simple" size="9"></s:textfield>
	  		</table>
	  		<c:if test="${creator.mhc_id > '0'}">
	  			<input type="button" name="btn" value="修改" onClick="submitQuery('updateMstHtmlCreator')">
	  			<input type="button" name="btn" value="初始" onClick="submitQuery('initialMstHtmlCreator')">
	  			<input type="button" name="btn" value="关闭" onClick="submitQuery('closeMstHtmlCreator')">
	  		</c:if>
	  		<c:if test="${creator.mhc_id == NULL || creator.mhc_id eq ''}">
	  			<input type="button" name="btn" value="添加" onClick="submitQuery('insertMstHtmlCreator')">
	  		</c:if>
	  		<br><br>
	  	</td>
	  </tr>
	  <tr>
	  	<td>
	  		<table width="100%" border="0">
	  			<tr>
					<td class="title_3">位置</td>
					<td class="title_3">提示</td>
					<td class="title_3">城市</td>
				</tr>
				<c:forEach items="${mheList}" var="mhe" varStatus="counter">
					<tr>
						<td>${mhe.mhe_name}</td>
						<td>
							<input type="text" name="tips" value="${mhe.mhe_tips}">
							<input type="hidden" name="mheids" value="${mhe.mhe_id}"/>
						</td>
						<td>${mhe.mhe_mapno}</td>
					</tr>
				</c:forEach>
			</table>
	  	</td>
	  </tr>
	  <tr>
	  	<td>
	  		<input type="button" name="btn" value="修改提示" onClick="submitQuery('updateTips')">
	  	</td>
	  </tr>
	  </table>
  </td>
 </tr>
 
  ${msg}
  </s:form>
</table><div align="center"> 
<script>
s();
function submitQuery(c){
	if(c == 'insertMstHtmlCreator' || c == 'updateMstHtmlCreator'){
		if (document.blockform["creator.mhc_color"].value == '')
			document.blockform["creator.mhc_color"].value = '0';
		if (document.blockform["creator.mhc_keyword"].value == '')
			document.blockform["creator.mhc_keyword"].value = '0';
		if (document.blockform["creator.pic_counts"].value == '')
			document.blockform["creator.pic_counts"].value = '0';	
		if (document.blockform["creator.txt_counts"].value == '')
			document.blockform["creator.txt_counts"].value = '0';	
		if (document.blockform["creator.mhc_titsize"].value == '')
			document.blockform["creator.mhc_titsize"].value = '30';
		if (document.blockform["creator.mhc_descsize"].value == '')
			document.blockform["creator.mhc_descsize"].value = '50';
		if (document.blockform["creator.mhc_inpath"].value == '')
			document.blockform["creator.mhc_inpath"].value = '/proj/home/stencil/ddhome/';		
	}
	if(c == 'closeMstHtmlCreator'){
		if(confirm('关闭会将该区域数据清空,确认操作？')){
			document.blockform.action="htmlblock!"+c+".action";
			document.blockform.submit();
		}else 
			return;
	}else if(c == 'deleteMstHtmlCreator'){
		if(confirm('关闭会将该区域数据清空,确认操作？')){
			document.blockform.action="htmlblock!"+c+".action";
			document.blockform.submit();
		}else 
			return;
	}else{
		document.blockform.action="htmlblock!"+c+".action";
		document.blockform.submit();
	}
	
}


function s(){
	if (document.blockform.mapno.value == ''){
		document.blockform.mapno.value = '21';
		document.blockform.action="htmlblock!submitQuery.action";
		document.blockform.submit();
	}
	
}


</script> 
</div></body>
</html>
