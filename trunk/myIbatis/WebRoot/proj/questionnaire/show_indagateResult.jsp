<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问卷调查结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		//input{border:solid 1px #999999;}
	</style>
  </head>
  
  <body>
  
 <form action="" name="indaResultform" method="post">
 	<input name="indagateResult.inda_id" type="hidden" value="${requestScope.indaInfo.inda_id }"/> 
 	<input name="indagateResult.indar_person" type="hidden" value="lph"/>
 	<input name="indagateResult.indar_start_time" type="hidden" value="2010-12-03"/>
 	<input name="indagateResult.indar_end_time" type="hidden" value="2010-12-04"/>
 	<input name="indagateResult.indar_time" type="hidden" value="1302"/>
  <div id="all"">
  	<div style="background-color:#8995Ff;text-align:center;">
    <div style="font-size:25px;fint-family:Times New Roman;"><B>${requestScope.indaInfo.inda_title }</B></div>
    <div style="font-size:22px;fint-family:Times New Roman;">${requestScope.indaInfo.inda_theme }</div>
  	<div id="titleDiv" style="text-align:center;">
    		<div style="float:left; margin:auto 30px auto auto;">问卷发起人:${requestScope.indaInfo.inda_person }</div>
    		<div style="float:left; margin:auto 30px auto auto;">问卷开始日期:${requestScope.indaInfo.inda_start_time }</div>
    		<div style="float:left; margin:auto 30px auto auto;">问卷结束日期:${requestScope.indaInfo.inda_end_time }</div>
    		<div >频道:${requestScope.indaInfo.channelId }</div>
    </div>
    </div>
    </div>
    <hr>
    <div id="ques&ansDiv">
    	<!-- 循环问卷上的问题 -->
    	<c:forEach var="question" items="${requestScope.indaInfo.queslist}" varStatus="statusi">
    	<!-- 判断问卷上的问题是否是多选题 -->
    	<c:if test="${question.quest_id!=4}">
    	<!-- 循环问卷结果上的结果，包括问题，答案等信息 -->
    	<c:forEach var="resultr" items="${requestScope.getIndagaterrList}">
    	<!-- 当问卷上的问题和问卷结果上的问题相同时 -->
     	<c:if test="${resultr.ques_id==question.ques_id}">
    		<div style="border:1px blue dashed;background-color:${statusi.count%2==0?'#DCF3F2':'#E7DFF9'}"><li>问：${question.ques_content }</li><br>
    		<!-- 循环问卷问题中的答案 -->
    		<c:forEach var="answer" items="${question.ansList}" varStatus="statusj">
			    			<c:if test="${question.quest_id==3}">
			    				<c:if test="${resultr.ans_id==answer.ans_id}">
			    					<input type="radio" checked name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
			    				</c:if>
			    				<c:if test="${resultr.ans_id!=answer.ans_id}">
			    					<input type="radio"  name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
			    				</c:if>
			    			</c:if>
    		</c:forEach>
    		
    		<c:if test="${question.quest_id==1}">
    			<select name="indagateResult.rqueslist[${statusi.count-1 }].ansArray">
	    			<c:forEach var="answer" items="${question.ansList}" varStatus="statusj">
	    			
			    				<c:if test="${resultr.ans_id==answer.ans_id}">
			    					<option selected  value="${answer.ans_id}">${answer.ans_content }</option>
			    				</c:if>
			    				<c:if test="${resultr.ans_id!=answer.ans_id}">
			    					<option  value="${answer.ans_id}">${answer.ans_content }</option>
			    				</c:if>
			    		
	    				
	    			</c:forEach>
    			</select>
    		</c:if>
	    	<c:if test="${question.quest_id==2}">
	    		<textarea name="indagateResult.rqueslist[${statusi.count-1 }].ansList[0].ans_content">${resultr.answer.ans_content }</textarea>
	    	</c:if>	
    		<br><span style="color:red">${question.ques_description }</span>
    		</div>
    		<Br><br>
    		</c:if>
    		
    		</c:forEach>
    		</c:if>
    		<c:if test="${question.quest_id==4}">
	    		<div style="border:1px blue dashed;background-color:${statusi.count%2==0?'#DCF3F2':'#E7DFF9'}"><li>问：${question.ques_content }</li><br>
	    			<c:forEach var="answer" items="${question.ansList}" varStatus="statusj">
	    			<c:set var="isIte" value="0" scope="page"></c:set>
	    			<c:forEach var="resultr" items="${requestScope.getIndagaterrList}">
	    				<c:if test="${answer.ans_id==resultr.ans_id}">
							<input type="checkbox" checked="checked" name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
							<c:set var="isIte" value="1" scope="page"></c:set>
						</c:if>
	    			</c:forEach>
	    			<c:if test="${isIte==0}">
	    			<input type="checkbox"  name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
	    			</c:if>
	    			</c:forEach>
	    			<br><span style="color:red">${question.ques_description }</span>
	    		</div><Br><br>
    		</c:if>
    		
    	</c:forEach>
    </div>
    <a href="javascript:history.go(-1);">返回一页</a>
    <div style="background-color:#8995FE; height:40px"><!-- <input type="button" onclick="subSave(${fn:length(requestScope.indaInfo.queslist)})" value="提交问卷"/> --></div>
  <script>
  	
  	var object = document.getElementsByTagName("input");
  	var objectRadioCheck = document.getElementsByTagName("input");
  	for(var i=0;i<object.length;i++){
  		if(object[i].type=="checkbox"){
  			object[i].onclick=function(){
  				if(this.checked==true){
  					this.checked=false;
  				}else{
  					this.checked=true;
  				}
  			}
  		}else{
  			
  		}
  	}
  	var object1 = document.getElementsByTagName("textarea");
  	for(var i=0;i<object1.length;i++){
  		object1[i].readOnly=true;
  	}
  	var object2 = document.getElementsByTagName("select");
  	for(var i=0;i<object2.length;i++){
  		var value = object2[i].value;
  		 object2[i].onchange = function(){
   			this.value=value;
    	 }
  	}
  	function subSave(obj){
  		//if(checkNotNull(obj)){
  		document.indaResultform.action="indagateResultAction!saveIndagateReuslt.action";
  		document.indaResultform.submit();
  		//}else{
  		//	alert("问卷调查不完善，请完善！");
  		//}
  	}
  	function checkNotNull(obj){
  		var result = true;
  		for(var i=0;i<obj;i++){
  			var va = document.indaResultform["indagateResult.rqueslist["+i+"].ansArray"].value;
  			if(typeof(va) != "undefined"){
	  			if(va=="" || va==null ){
		  			result = false;
			  		return;	
	  			}		
  			}
  		}
  		return result;
  	}
  </script>
  </form>
  </body>
</html>

