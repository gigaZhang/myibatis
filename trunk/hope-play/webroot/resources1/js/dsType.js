// JavaScript Document
function spanClick(mySpan){
	var myCheck = mySpan.parentElement.childNodes[0];
	if(myCheck.checked){
		myCheck.checked = false;
	}else{
		myCheck.checked = true;
	}
	checkClick(myCheck);
}
function getTypeContent(){
	var content = "";
	var dsNames = document.getElementsByName("info.dsCodes");
	for(var i=0;i<dsNames.length;i++){
		if(dsNames[i].checked){
			content += '<label class="s_div"><span class="s_txt">'+dsNames[i].parentNode.innerText+'</span><span class="close_button" onclick="removeSelected(\''+
			$(dsNames[i]).attr("id")+'\')"></label>';
		}
	}
	return "已选数据源："+content;
}
function setCheck(myCheck){
	/*var dsNames = document.getElementsByName("info.dsCodes");
	for(var i=0;i<dsNames.length;i++){
		if(dsNames[i].id.indexOf(myCheck.id+"_") != -1){
			dsNames[i].checked = myCheck.checked;
		}
	}*/
}
function checkClick(myCheck){
	setCheck(myCheck);
	var content = getTypeContent();
	$("#typeContent").html(content);
}

//级联选中
function doCascadeCheck(checkObj){
	var objId = $(checkObj).attr("id");
	if($(checkObj).attr("checked")){
			$(this).attr("checked",true);
	}else{
		$(this).attr("checked",false);
	}
	updateParents(objId,$(checkObj).attr("checked"));
	updateChildren(objId,$(checkObj).attr("checked"));
	setCheckContent();
}

//点击span元素做check操作
function doSpanCheck(spanObj){
	var checkObj = $(spanObj).prev();
	if(checkObj.attr("checked")){
		checkObj.attr("checked",false);
	}else{
		checkObj.attr("checked",true);
	}
	doCascadeCheck(checkObj);	
}

//获得选中内容
function setCheckContent(){
	var content = "";
	$("input[name='info.dsAndDataTypes']").each(function(){
		if($(this).attr("checked")){
			content += '<label class="s_div" id="ckl_' + $(this).attr("id") + '"><span class="s_txt">'+$(this).next().attr("id")+'<a style="background:#61ac1e;color:#fff;cursor:pointer;" onclick="removeSelected(\''+
			$(this).attr("id")+'\')">&nbsp;x&nbsp;</a></span></label>';
		}
	});
	$("#typeContent").html(content);
}

function removeSelected(checkid)
{
	$("#ckl_" + checkid).remove();
	if(checkid== undefined || checkid=='' || checkid== null)
	{
		return;
	}
	$("#" + checkid).attr("checked",false);
	updateParents(checkid,false);
	updateChildren(checkid,false);
}
/**
 * 更新父亲元素
 * @param checkid
 * @param checked
 * @return
 */
function updateParents(checkid,checked)
{
	if(checkid== undefined || checkid=='' || checkid== null)
	{
		return;
	}
	$("#" + checkid).attr("checked",checked);
	if($("#" + checkid).parents("ul:first").find("li > a > :checkbox[checked]").size() > 0)
	{
		updateParents($("#" + checkid).parents("ul:first").prev("a").children("input[type=checkbox]:first").attr("id"),true);
	}
	else
	{
		updateParents($("#" + checkid).parents("ul:first").prev("a").children("input[type=checkbox]:first").attr("id"),false);
	}
}
/**
 * 更新子元素
 * @param checkid
 * @param checked
 * @return
 */
function updateChildren(checkid, checked)
{
	if(checkid== undefined || checkid=='' || checkid== null)
	{
		return;
	}
	$("#" + checkid).parents("li:first").find("ul > li :checkbox").each(function(){
		$(this).attr("checked",checked);
		updateChildren($(this).attr("id"),checked);
	});
}