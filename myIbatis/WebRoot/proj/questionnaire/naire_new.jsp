<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建问卷调查</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		input{background-color:expression(this.type=='button'?'transparent':'');}
		input{border:1px solid;margin:auto auto auto 5px;}
		select{border:1px solid;}
	</style>
	<script>
		var i = 1;
		var quesType = "";
		function addQues(){
			var j = 1;
			var qdiv = document.createElement("div");//放问题的div
			qdiv.setAttribute("id",i);
			qdiv.innerHTML="<b>问题"+i+"、("+quesType+"类型)</b>";
			
			
			var input_ques = document.createElement("textarea");//问题的textarea
			//input_ques.setAttribute("type","textarea");
			input_ques.setAttribute("title","问题内容...");
			input_ques.setAttribute("name","queslist["+i+"].ques_content");
			input_ques.setAttribute("value","问题内容...");
			input_ques.onblur=function(){
				if(this.value==""){
					this.value="问题内容...";
				}
			}
			input_ques.onfocus=function(){
				if(this.value=="问题内容..."){
					this.value="";
				}
			}
			
			
			
			var input_ques_desc = document.createElement("textarea");//问题描述的textarea
			//input_ques_desc.setAttribute("type","text");
			input_ques_desc.setAttribute("title","问题描述...");
			input_ques_desc.setAttribute("name","queslist["+i+"].ques_description");
			input_ques_desc.setAttribute("value","问题描述...");
			input_ques_desc.onfocus=function(){
				if(this.value=="问题描述..."){
					this.value="";
				}
			}
			input_ques_desc.onblur=function(){
				if(this.value==""){
					this.value="问题描述...";
				}
			}
			
			
			var input_ques_type = document.createElement("input");//问题类型的input--hidden
			input_ques_type.setAttribute("type","hidden");
			input_ques_type.setAttribute("value",document.form.selectQuesType.value);
			input_ques_type.setAttribute("name","queslist["+i+"].quest_id");
			
			var btn_add_answer = document.createElement("input");//添加答案按钮
			btn_add_answer.setAttribute("type","button");
			btn_add_answer.setAttribute("value","添加答案");
			
			var btn_det_ques = document.createElement("input");//删除题目按钮
			btn_det_ques.setAttribute("type","button");
			btn_det_ques.setAttribute("value","删除该题");
			//为删除该题按钮注册点击事件
			btn_det_ques.onclick=function(){
				document.getElementById("questionDiv").removeChild(qdiv);
			}
			//为添加答案按钮注册点击事件
			btn_add_answer.onclick=function(){
				var adiv = document.createElement("div");//放答案的div
				adiv.setAttribute("id","ansDiv"+ j);
				
				var input_ans = document.createElement("input");//答案的input
				input_ans.setAttribute("type","text");
				input_ans.setAttribute("id","ans"+j);
				
				var btn_detAns = document.createElement("input");//删除答案按钮
				btn_detAns.setAttribute("type","button");
				btn_detAns.setAttribute("value","删除该答案");
				btn_detAns.onclick=function(){
					qdiv.removeChild(adiv);
				}
				adiv.innerText="----------选项"+j+"、";
				adiv.appendChild(input_ans);
				
				adiv.appendChild(btn_detAns);
				qdiv.appendChild(adiv);
				input_ans.setAttribute("name","queslist["+adiv.parentElement.id+"].ansList["+j+"].ans_content");
				
				j++;
			}
			qdiv.appendChild(input_ques);
			qdiv.appendChild(input_ques_desc);
			qdiv.appendChild(input_ques_type);
			if(quesType!="文本"){
			qdiv.appendChild(btn_add_answer);
			}
			qdiv.appendChild(btn_det_ques);
			document.getElementById("questionDiv").appendChild(qdiv);
			i++;
		}
		
		function changeQuesType(){
			var typeObj = document.form.selectQuesType.value;
			if(typeObj == "1"){
				quesType = "下拉列表";
			}else if(typeObj == "2"){
				quesType = "文本";
			}else if(typeObj == "3"){
				quesType = "单选";
			}else if(typeObj == "4"){
				quesType = "多选";
			}else{
				alert("请选择题目类型");
				return;
			}
			addQues();
		}
		
	</script>
  </head>
  
  <body>
  
 <form action="" name="form" method="post">
  <div id="all" style="border:1px #333 dashed;">
    <div style="font-size:22px;fint-family:Times New Roman;background-color:#8995FE">新建问卷调查</div>
	<div style="height:2;"><hr style="width:100%;"></div>
    <div id="contentDiv">
    	<div id="titleDiv" style="background-color:#DCF3F2;">
    		<div style="float:left;magin:0 0 10px 10px">问卷标题:<input type="text" name="indagate.inda_title"/></div>
    		<div style="float:left;">问卷主题:<input type="text" name="indagate.inda_theme"/></div>
    		<div style="float:left;">问卷发起人:<input type="text" name="indagate.inda_person"/></div>
    		<div >问卷开始日期:<input type="text" name="indagate.inda_start_time"/></div><br/>
    		<div style="float:left;">问卷标题:<input type="text" name="indagate.inda_end_time"/></div>
    		<div>频道:<input type="text" name="indagate.channelId" value="0" /></div>
    	</div>
    	<div><hr style="width:100%;"></div>
    	<div id="addQuesDiv" style="margin:10px 10px 10px 10px; background-color:#E7DFF9;">
	    	<li>请选择题目类型</li>
	    	<select name="selectQuesType">
	    		<option value="3">单选</option>
	    		<option value="4">多选</option>
	    		<option value="1">下拉列表</option>
	    		<option value="2">文本</option>
	    	</select>
	    	<input style="background-color:transparent" value="添加题目" onClick="changeQuesType()" type="button" />
    	</div>
    	<div id="questionDiv" style="background-color:#E7DFF9;">
    		
    	</div>
    </div>
    <div id="footer" style="background-color:#8995FE;">
    <input type="button" style="background-color:transparent;" onClick="subSave()" value="保存"></div>
  </div>  
  </form>
  <script>
  	function checkNotNull(){
  		var allRight = true;
  		var textareaValue = document.getElementsByTagName("textarea");
  		var inputValue = document.getElementsByTagName("input");
  		for(var i in textareaValue){
  			if(typeof(textareaValue[i].value) != "undefined"){
	  			if(textareaValue[i].value == "" || textareaValue[i].value == null || textareaValue[i].value == "问题内容..." || textareaValue[i].value == "问题描述..."){
	  				textareaValue[i].focus();
	  				allRight = false;
	  				return;
	  			}
  			}
  		}
  		for(var i in inputValue){
  			if(typeof(inputValue[i].value) != "undefined"){
	  			if(inputValue[i].value == "" || inputValue[i].value == null){
	  				inputValue[i].focus();
	  				allRight = false;
	  				return;
	  			}
	  		}
  		}
  		return allRight;
  		
  	}
  	function subSave(){
  		if(checkNotNull()){
	  		document.form.action="indagateAction!saveIndagate.action";
	  		document.form.submit();
	  	}else{
	  		alert("填写信息不完善，请完善！");
	  	}
  	}
  </script>
  </body>
</html>

