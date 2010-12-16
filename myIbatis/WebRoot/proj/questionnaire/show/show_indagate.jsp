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
    
    <title>问卷调查</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		
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
  	<div  style="background-color:#8995FE;">
    <div style="font-size:25px;fint-family:Times New Roman;margin:0px 0px 0px 540px;"><B>${requestScope.indaInfo.inda_title }</B></div>
    <div style="font-size:22px;fint-family:Times New Roman;margin:0px 0px 0px 550px;">${requestScope.indaInfo.inda_theme }</div>
   	
   	<div id="titleDiv" style="margin:0px 0px 0px 400px;">
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷发起人:${requestScope.indaInfo.inda_person }</div>
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷开始日期:${requestScope.indaInfo.inda_start_time }</div>
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷结束日期:${requestScope.indaInfo.inda_end_time }</div>
    		<div style="margin:0px 20px 0px 10px;">频道:${requestScope.indaInfo.channelId }</div>
    	
    </div>		
    </div>
    </div><hr>
    <div id="ques&ansDiv">
    	<c:forEach var="question" items="${requestScope.indaInfo.queslist}" varStatus="statusi">
    		<input type="hidden" name="indagateResult.rqueslist[${statusi.count-1 }].ques_id" value="${question.ques_id}"/>
    		<input type="hidden" name="indagateResult.rqueslist[${statusi.count-1 }].quest_id" value="${question.quest_id}"/>
    		<div style="border:1px blue dashed;background-color:${statusi.count%2==0?'#DCF3F2':'#E7DFF9'}"><li>问：${question.ques_content }</li><br>
    		<c:forEach var="answer" items="${question.ansList}" varStatus="statusj">
    			<c:if test="${question.quest_id==3}">
    				<input type="radio" name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
    			</c:if>
    			<c:if test="${question.quest_id==4}">
    				<input type="checkbox" name="indagateResult.rqueslist[${statusi.count-1 }].ansArray" value="${answer.ans_id}"/>${answer.ans_content }
    			</c:if>
    		</c:forEach>
    		<c:if test="${question.quest_id==1}">
    			<select name="indagateResult.rqueslist[${statusi.count-1 }].ansArray">
	    			<c:forEach var="answer" items="${question.ansList}" varStatus="statusj">
	    				<option  value="${answer.ans_id}">${answer.ans_content }</option>
	    			</c:forEach>
    			</select>
    		</c:if>
	    	<c:if test="${question.quest_id==2}">
	    		<textarea name="indagateResult.rqueslist[${statusi.count-1 }].ansList[0].ans_content"></textarea>
	    	</c:if>	
    		<br><span style="color:red">${question.ques_description }</span>
    		</div>
    		<Br><br>
    	</c:forEach>
    </div>
    
    
    <div style="background-color:#8995FE; height:40px;"><input type="button" onclick="subSave(${fn:length(requestScope.indaInfo.queslist)})" value="提交问卷"/></div>
  <script>
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

