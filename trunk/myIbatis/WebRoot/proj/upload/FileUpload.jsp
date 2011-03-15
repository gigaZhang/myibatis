<%@ page language="java" contentType = "text/html;GBK" import="java.util.*,jcx.db.*" pageEncoding="GBK"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%> 
<%@page import="com.freemarker.tool.MST_StringUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns ="http://www.w3.org/1999/xhtml"> 
<jsp:include page="/g_in_db.jsp"></jsp:include>
<%
	String p = request.getParameter("imgtype");
	String c = request.getParameter("createmark");
	String imgsize = request.getParameter("imgsize");
	String editor = request.getParameter("editor");
	String shopid = request.getParameter("shopid");
	String check = request.getParameter("check");
	String tp_id = request.getParameter("tp_id");
	String dirid = request.getParameter("dirid");
	
	if(MST_StringUtil.isStringNull(p))
		p = "";
	
	if(MST_StringUtil.isStringNull(c))
		c = "";
	
	if (MST_StringUtil.isStringNull(imgsize))
		imgsize = "1";
	
 %>

 
<head> 
    <title> Struts 2 File Upload </title > 
</head> 
		
	  	<s:form action ="fileUpload" name="fileform" theme="simple" method ="POST" enctype ="multipart/form-data"> 

	  		<input type=hidden name="imgtype" value="<%=p%>"/>
	  		<input type=hidden name="createmark" value="<%=c%>"/>
	  		<input type=hidden name="imgsize" value="<%=imgsize%>"/>
	  		<input type=hidden name="editor" value="<%=editor%>"/>
	  		<input type=hidden name="dirid" value="<%=dirid%>"/>
	  		<input type=hidden name="shopid" value="<%=shopid%>"/>
	  		<input type=hidden name="returntype" value=""/>
	  		<input type=hidden name="tp_id" value="<%=tp_id %>"/>
	  		<% for (int i=0;i<Integer.parseInt(imgsize);i++){
	  			
	  		%>
	       	 <s:file name ="myFile" label ="图片<%=i+1%>" theme="simple"/>
	       	 <%if (Integer.parseInt(imgsize) > 1){ %>
	     	  	 图片描述：<input type="text" name="imgdesc"/>
	     	 <%}else{ %>
	     	 	<input type=hidden name="imgdesc"/>
	     	 <%} %>
	    
			不打水印<input type="checkbox" name="check">
		 <br>
	        <%
	        	//	if (i == 1)
	        		//	out.print("</br>");
	           } %>
		<s:submit value="上传" theme="simple"></s:submit>
	    </s:form>
	    
	    <%if (check != null && check.equals("on")) {%>
		 <script>
		 	fileform.check.checked = true;
		 </script>
		 <%} %>
	    <script>
	   		 parent.getFileName("${fileName}","${desc}","${editor}");
	    </script>
	    
	   
</html> 

