<%@ page language="java" import="java.util.*,jcx.db.*" pageEncoding="utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="/WEB-INF/inc/simpletld.inc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/ddmapmanage/css/style.css" rel="stylesheet" type="text/css" />


<title>优活女人</title>
</head>

<body>
<%

	
%>
<table width="100%" border="0" style="height:7px; background:#F4FDFE">
 <s:form action="" theme="simple" name="homeform">    
 <s:hidden name="home.site" theme="simple"></s:hidden>
  <s:hidden name="home.returntype" theme="simple"></s:hidden>
  <tr class="title_1">
    <td><i>优活女人</i></td>
  </tr>
  
  <tr>
  <td>
	  <table width="100%" border="0" style="height:7px; background:#F4FDFE">
	  <tr>
	  	<!--<td width="30%" valign="top">
	  		<iframe src="/ddmapmanage/proj/home/alltopiclist.jsp?mapno=${home.mapno }" height="630px"></iframe>
	  	</td>-->
	  	<td width="70%" valign="top">
	  
	  		<s:select name="home.mapno" list="#{'':'请选择','21':'上海','25':'南京'}"></s:select>
	  		<s:select name="home.module" onchange="submitQuery('moduleMenu')" list="#{'优活女人-顶部':'优活女人-顶部','优活女人-时尚':'优活女人-时尚','优活女人-丽人':'优活女人-丽人','优活女人-消费':'优活女人-消费','优活女人-母婴':'优活女人-母婴','优活女人-图库':'优活女人-图库','优活女人-列表页面':'优活女人-列表页面','优活女人-折扣首页':'优活女人-折扣首页','优活女人-网购导航':'优活女人-网购导航','优活女人-网购首页':'优活女人-网购首页','优活女人-Top20':'优活女人-Top20','优活女人-图库首页':'优活女人-图库首页','优活女人-街拍首页':'优活女人-街拍首页','优活女人-时尚首页':'优活女人-时尚首页','优活女人-商场商圈':'优活女人-商场商圈','优活女人-互动通':'优活女人-互动通'}"></s:select>
	  		<c:if test="${home.mapno > '0'}">
				<s:select name="home.item" list="items" onchange="submitQuery('moduleMenu')"  headerKey="" headerValue="请选择区域" listValue="mhcname" listKey="mhcid"></s:select>
				   <input type="button" name="btn" value="测试数据" onclick="submitQuery('Initial')"/>     
				<c:if test="${home.txtcounts > '0'}">
				
					位置：<s:select name="home.place" list="places"  onchange="submitQuery('moduleMenu')" listValue="place" listKey="place"></s:select>
					<c:if test="${home.color eq '1'}">
					
						<select name="home.hot">
							<option value="">请选择标题色</option>
							<option value="0">撤消</option>
							<option value="FF0000" style='color:#FF0000'>颜色</option>
							<option value="C74C10" style='color:#C74C10'>颜色</option>
							<option value="938271" style='color:#938271'>颜色</option>
							<option value="539391" style='color:#539391'>颜色</option>
							<option value="533591" style='color:#533591'>颜色</option>
							<option value="6b239b" style='color:#6b239b'>颜色</option>
							<option value="e33391" style='color:#e33391'>颜色</option>
							<option value="239393" style='color:#239393'>颜色</option>
							<option value="133591" style='color:#133591'>颜色</option>
						</select>
					  </c:if>

					<br>
					<b>标  题：</b><s:textfield name="home.title" theme="simple" size="52"></s:textfield><s:select name="effect" list="#{'':'请选择效果','1':'飘红','2':'加粗','3':'飘红加粗','4':'取消'}"></s:select>
					<br>
					<b>U R L  ：</b><s:textfield name="home.url" theme="simple" size="52"></s:textfield>
					<br>
					<c:if test="${home.item eq '2459' or home.item eq '2446'}">
										<b>第一个数字 ：</b><s:textfield name="fashion1" theme="simple" size="52"></s:textfield><br>
										<b>第二个数字 ：</b><s:textfield name="fashion2" size="52"></s:textfield><br>
										<b>小  编 ：</b><s:textfield name="fashion3" size="52"></s:textfield><br>
					</c:if>
					<c:if test="${home.keyword eq '1'}">
						<b>关键字：</b><s:textfield name="home.key" theme="simple"></s:textfield>
						<b>关键字URL：</b><s:textfield name="home.keyurl" theme="simple"></s:textfield><br>
					</c:if>
					<c:if test="${home.keyword eq '0'}">
						<s:hidden name="home.key" theme="simple"></s:hidden>
						<s:hidden name="home.keyurl" theme="simple"></s:hidden>
					</c:if>
					<c:if test="${home.place < home.piccounts+1 }">
						<b>描 述 ：</b><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textarea name="home.desc" rows="7" cols="50"></s:textarea>
						<br>
						<b>图 片 ：</b><s:textfield name="home.filename" theme="simple" size="52"></s:textfield>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<iframe src="/myIbatis/proj/upload/FileUpload.jsp?imgtype=channelimgpath" width="385px" height="70px"></iframe>
					</c:if>
					<c:if test="${home.place > home.piccounts }">
						<s:hidden name="home.desc" theme="simple"></s:hidden>
						<s:hidden name="home.filename" theme="simple"></s:hidden>
					</c:if>
					<br><input type="button" name="btn" value="修改" onclick="submitQuery('addRecommand')"/>
				
				<table width="43%" border="0">
				        <tr>
				            <td class="title_3" width="10%"><b>现有内容</b></td>
				        </tr>
						<c:forEach items="${piclist}" var="pic" varStatus="counter">
						<tr>
							<td>
								<b>位置${counter.count}：</b>
								<c:if test="${pic.filename eq ''}">
									<a href="javascript:updateEditor('${counter.count}','${pic.title }','${pic.url }','${pic.desc }','${pic.filename }')">${pic.title }</a>
								</c:if>
								<c:if test="${pic.filename ne ''}">
									
									<a href="javascript:updateEditor('${counter.count}','${pic.title }','${pic.url }','','','${pic.desc }','${pic.filename }')">
									<img src="${pic.filename }" width="50" height="50" alt="${pic.title }" />
									</a>
								</c:if>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${home.total > 0 }">
						<c:forEach items="${txtlist}" var="txt" varStatus="counter" begin="${home.cure }">
						<tr>
							<td>
								<b>位置${counter.count+home.piccounts}</b>
								<c:if test="${txt.tips ne null}">
									(${txt.tips})
								</c:if>
							   ：<c:if test="${home.keyword eq '1'}">
									[${txt.key}]
								</c:if>
								<a href="javascript:updateEditor('${counter.count+home.piccounts}','${txt.title }','${txt.url }','${txt.key }','${txt.keyurl }','','')">${txt.title }</a>
							</td>
						</tr>	
						</c:forEach>
						</c:if>
	
				</table>
				</c:if>
						<c:if test="${home.item > '0'}">
							<br>
							<input type="button" name="btn" value="预览该区域" onClick="windowopen('${home.preview }${home.mapno} ')">
							<input type="button" name="btn" value="生成该区域" onclick="submitQuery('bringFile')"/>
							<!-- <input type="button" name="btn" value="全部生成" onclick="submitQuery('bringFileAll')"/> -->
						</c:if>

			</c:if>
			</br></br>
	
			 
	  	</td>
	  </tr>
	  </table>
  </td>
 </tr>
  ${msg}
  </s:form>
</table>
<script>
s();
function submitQuery(c){
	if (c == 'addRecommand'){
	  if(document.homeform["home.item"].value != '2073') {
		document.homeform["home.title"].value = document.homeform["home.title"].value.replace("\"","“").replace("\"","”").replace("'","’");
	  }
	}
	document.homeform.action="home!"+c+".action";
	document.homeform["home.returntype"].value = 'LIVING_GIRL';
	document.homeform.submit();
}


function getFileName(file,desc){

	if (file != ''){
		document.homeform["home.filename"].value = "d:/"+file;
	}
	
	//alert(topicform.img.value);
	//ddtopicform.check.checked = false;
}


function s(){
	
	if (document.homeform["home.mapno"].value == ''){
		document.homeform["home.returntype"].value = 'LIVING_GIRL';
		document.homeform["home.module"].value = '优活女人-顶部';
		document.homeform["home.mapno"].value = '21';
		document.homeform.action="home!moduleMenu.action";
		document.homeform.submit();
	}
}

function updateEditor(place,title,url,key,keyurl,desc,filename){
	document.homeform["home.place"].value = place;
	document.homeform["home.title"].value = title;
	document.homeform["home.title"].value = document.homeform["home.title"].value.replace("<font style=color:#FF0000>","").replace("</font>","").replace("<b>","").replace("</b>","").replace("<img src=http://timg.ddmapimg.com/topic/1293168230136.jpg>","");
	document.homeform["home.url"].value = url;
	if (document.homeform["home.url"].value.split("%"))
		document.homeform["home.url"].value = escape(url).replace("\%3A",":").replace("%3F","?").replace(new RegExp('%3D','g'),"=").replace(new RegExp('%26','g'),"&");
	else 
		document.homeform["home.url"].value = url;
		
	if (desc != '' || filename != ''){
		document.homeform["home.desc"].value = desc;
		document.homeform["home.filename"].value = filename;
	}
	if (key != '' || keyurl != ''){
		
		document.homeform["home.key"].value = key;
		document.homeform["home.keyurl"].value = keyurl;
	}
	
	if(document.homeform["home.item"].value == '2446' || document.homeform["home.item"].value == '2459'){
				var titles = document.homeform["home.title"].value.split(",");
				document.homeform["home.title"].value = titles[0];
				document.homeform.fashion1.value = titles[1];
				document.homeform.fashion2.value = titles[2];
				document.homeform.fashion3.value = titles[3];
				return;
	}

	document.homeform.action="home!moduleMenu.action";
	document.homeform.submit();
}

function checkAll(){
   var flag = 0;
	firstCheckName=homeform.selectid;
	checkName=homeform.site;
    if(checkName!=null)
   {
    if(firstCheckName.checked==true)
    {
     for(; flag < checkName.length; flag++){
       checkName[flag].checked = true;
     }
     if(flag==0) checkName.checked = true;
    }
    else
    {
   for(; flag < checkName.length; flag++){
       checkName[flag].checked = false;
     }
     if(flag==0) checkName.checked = false;
    }
  }
 }

function windowopen(url){
	if (url == 'homePublished'){
		document.homeform["home.returntype"].value = 'LIVING_GIRL';
		document.homeform.action="home!published.action";
		document.homeform.submit();
	}else 
		window.open(url);
}

	function settopic(topic,url){
		document.homeform["home.title"].value = topic;
		document.homeform["home.url"].value = url;
	}
	

				
</script>
</body>
</html>