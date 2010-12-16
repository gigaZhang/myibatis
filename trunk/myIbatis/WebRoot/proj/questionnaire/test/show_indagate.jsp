<%@ page language="java" import="java.util.*,com.questionnaire.*" pageEncoding="gbk"%>
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
  <%
  	IGetIndagate getIndagate = new GetIndagateImpl();
  	Map getMap = getIndagate.getIndagate(26);
  	
  %>
 <form action="/ddmapmanage/proj/questionnaire/test/test.jsp" name="indaResultform" method="post">
 	<input name="inda_id" type="hidden" value="<%=getMap.get("inda_id") %>"/> 
 	<input name="indar_person" type="hidden" value="lph"/>
  <div id="all"">
    <div style="font-size:25px;fint-family:Times New Roman;margin:0px 0px 0px 540px;"><B><%=getMap.get("inda_title") %></B></div>
    <div style="font-size:22px;fint-family:Times New Roman;margin:0px 0px 0px 550px;"><%=getMap.get("inda_theme") %></div>
   <div id="titleDiv" style="margin:0px 0px 0px 400px;">
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷发起人:<%=getMap.get("inda_person") %></div>
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷开始日期:<%=getMap.get("inda_start_time") %></div>
    		<div style="float:left;margin:0px 0px 0px 20px;">问卷结束日期:<%=getMap.get("inda_end_time") %></div>
    		<div style="margin:0px 20px 0px 10px;">频道:<%=getMap.get("channel") %></div>
    	
    		
    </div>
    </div><hr>
    <input type="hidden" name="quesCount" value="<%=((List)getMap.get("quesInfoList")).size() %>"/>
    <div id="ques&ansDiv">
    	<%
    		List quesList = (List)getMap.get("quesInfoList");
    		for(int i=0;i<quesList.size();i++){
    			Map quesMap = (Map)quesList.get(i);
    			%>
    			<div style="border:1px blue dashed;"><li>问:<%=quesMap.get("ques_content") %></li><br>
    			<input type="hidden" name="ques_<%=i %>" value="<%=quesMap.get("ques_id") %>"/>
    			<input type="hidden" name="quest_<%=i %>" value="<%=quesMap.get("quest_id") %>"/>
    			<%
    			List ansList = (List)quesMap.get("ansList");
    			for(int j=0;j<ansList.size();j++){
    				Map ansMap = (Map)ansList.get(j);
    				if("3".equals(quesMap.get("quest_id").toString())){
    					if(j==0){
    					%>
    						<input type="radio" checked name="ans_<%=i %>"  value="<%=ansMap.get("ans_id") %>"/><%=ansMap.get("ans_content") %>
    					<%
    					}else{
    					%>
    						<input type="radio"  name="ans_<%=i %>"  value="<%=ansMap.get("ans_id") %>"/><%=ansMap.get("ans_content") %>
    					<%
    					}
    				}else if("4".equals(quesMap.get("quest_id").toString())){
    					if(j==0){
    					%>
    						<input type="checkbox" checked name="ans_<%=i %>" value="<%=ansMap.get("ans_id") %>"/><%=ansMap.get("ans_content") %>
    					<%
    					}else{
    						%>
    						<input type="checkbox" name="ans_<%=i %>" value="<%=ansMap.get("ans_id") %>"/><%=ansMap.get("ans_content") %>
    					<%
    					}
    				}
    			} 
    			if("1".equals(quesMap.get("quest_id").toString())){
    				%>
    					<select name="ans_<%=i %>">
    						<%
    						for(int j=0;j<((List)quesMap.get("ansList")).size();j++){
    						Map ansMap = (Map)((List)quesMap.get("ansList")).get(j);
			    			%>
			    			<option value="<%=ansMap.get("ans_id") %>"><%=ansMap.get("ans_content") %></option>
			    			<%} %>
	    				</select>
    				<%
    			}
    			if("2".equals(quesMap.get("quest_id").toString())){
    			%>
    			<textarea name="ans_<%=i %>"></textarea>
    			<%
    			}
    			%>
    			<br><span style="color:red"><%=quesMap.get("ques_description") %></span>
    			</div>
    			<Br>
    			<%
    			
    		}
    	 %>
    
    </div>
    
    
    <div><input type="submit"  value="提交问卷"/></div>
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

