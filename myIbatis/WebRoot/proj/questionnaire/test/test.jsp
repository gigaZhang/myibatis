<%@ page language="java" import="java.util.*,com.questionnaire.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
   <%
   	//request.getAttribute("indaResultform");
   	Map getMap = new HashMap();
   	String size = request.getParameter("quesCount").toString();
   	String inda_id = request.getParameter("inda_id").toString();
   	String indar_person = request.getParameter("indar_person").toString();
   	List<Map> quesList = new ArrayList<Map>();
   	for(int i = 0; i<Integer.parseInt(size);i++){
   		Map quesMap = new HashMap();
   		List<Map> ansList = new ArrayList<Map>();
   		String ques_id = request.getParameter("ques_"+i).toString();
   		String quest_id = request.getParameter("quest_"+i).toString();
   		if("2".equals(quest_id)){
   			Map ansMap = new HashMap();
   			String ans_content = request.getParameter("ans_"+i);
   			ansMap.put("ans_content",ans_content);
   			ansList.add(ansMap);
   		}else{
   			String[] ans_id = request.getParameterValues("ans_"+i);
   			for(int j=0;j<ans_id.length;j++){
   				Map ansMap = new HashMap();
   				ansMap.put("ans_id",ans_id[j]);
   				ansList.add(ansMap);
   			}
   		}
   		quesMap.put("ansList",ansList); 
   		quesMap.put("quest_id",quest_id);
   		quesMap.put("ques_id",ques_id);
   		quesList.add(quesMap);
   	}
   	getMap.put("quesList",quesList);
   	getMap.put("indar_person",indar_person);
   	getMap.put("inda_id",inda_id);
   	
   	IPostIndagate postInda = new PostIndagateImpl();
   	postInda.postIndagate(getMap);
   	out.println("<script>alert('恭喜，提交成功');window.opener=null;window.open('','_self','');window.close(); </script>");
    %>
    
  </body>
</html>
