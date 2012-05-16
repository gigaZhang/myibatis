


function checkIsValidDate(str)
		{
			var pattern = /^(\d{4}||\d{2})-\d{1,2}-\d{1,2}$/;
			if(!pattern.test(str))	return false;
			
			var arrDate = str.split("-");
			var date =  new Date(arrDate[0],(arrDate[1]*1 -1)+"",arrDate[2]);
			
			if(date.getFullYear()*1 == arrDate[0]*1&& date.getMonth()*1 == (arrDate[1]*1 -1)*1&& date.getDate()*1 == arrDate[2]*1)
				return true;
			else
				return false;
		}
/**
 * 对于动态添加验证的
 */
function dynamicValidate(prefix, end, message)
		{
			var str = "";
			var arry = prefix.split(".");
			for(var j =0; j < arry.length; j++)
			{
				str += "[name*='" + arry[j] + "']";
			}
			str += "[name*='" + end + "']";
			var v = true;
			$(str).each(function(){
				 var name = $(this).attr('name');	
				 var html = "<label for='lable_" + name  + "' generated='true' class='error'>" + message + "</label>";
				 $(this).nextAll("lable[class=error][name^='lable_']").each(function(){
				 	$(this).remove();
				 });
				 if($(this).val() == '')
				 {
				 	$(html).insertAfter($(this));
				 	v = false;
				 	return ;
				 }
			});
			return v;
		}
/*
 * 对于动态的ISP的选择添加
 * 
 * 
 */
function dynamicIspSelect(prefix, ispCodeSurfix, ispNameSurfix)
{
			var str = "";
			var arry = prefix.split(".");
			for(var j =0; j < arry.length; j++)
			{
				str += "[name*='" + arry[j] + "']";
			}
			var codestr = "select" + str + "[name$='" + ispCodeSurfix +"']";
			$(codestr).live("change", function(){
				var name = $(this).attr("name").replace(ispCodeSurfix,'');
				arry = name.split(".");
				str = '';
				for(var j =0; j < arry.length; j++)
				{
					if(arry[j] != '')
						str += "[name*='" + arry[j] + "']";
				}
				var nameStr = "input[type=text]" +str + "[name$='" + ispNameSurfix +"']" ;
				var ispNameObj = $(nameStr);
				var txt =$(this).children("option[selected]").text();
				if($(this).val() == '')
				{
					ispNameObj.attr('value','');
					ispNameObj.attr('readonly','');
				}
				else
				{
					ispNameObj.attr('value',txt);
					ispNameObj.attr('readonly','readonly');
				}
			});
		}

function initDisplay(value, display) {
	var disEle = new Array();
	for (p in display) {
		var selectshowid1 = display[p];
		if (value == p) {
			if (selectshowid1 != undefined) {
				var arr = selectshowid1.split(",");
				for (var t = 0; t < arr.length; t++) {
					$("#" + arr[t]).show();
					disEle[arr[t]] = "true";
				}
			}
		} else {
			if (selectshowid1 != undefined) {
				var arr = selectshowid1.split(",");
				for (var t = 0; t < arr.length; t++) {
					if(disEle[arr[t]] != "true")
						$("#" + arr[t]).hide();
				}
			}
		}
	}
}
function changeDisplay(value, display) {
	for (p in display) {
		var selectshowid1 = display[p];
		var arr = selectshowid1.split(",");
		for (var t = 0; t < arr.length; t++) {
			$("#" + arr[t]).hide();
		}
	}
	var selectshowid = display[value];
	if (selectshowid != undefined) {
		var arr = selectshowid.split(",");
		for (var t = 0; t < arr.length; t++) {
			$("#" + arr[t]).show();
		}
	}
}
function initDisableInput(value, disableInput) {
	for (p in disableInput) {
		var selectshowid1 = disableInput[p];
		if (value == p) {
			if (selectshowid1 != undefined) {
				var arr = selectshowid1.split(",");
				for (var t = 0; t < arr.length; t++) {
					$("#" + arr[t]).removeAttr("disabled");
				}
			}
		} else {
			if (selectshowid1 != undefined) {
				var arr = selectshowid1.split(",");
				for (var t = 0; t < arr.length; t++) {
					$("#" + arr[t]).attr("disabled","disabled");
				}
			}
		}
	}
}
function changeDisableInput(value, disableInput) {
	for (p in disableInput) {
		var selectshowid1 = disableInput[p];
		var arr = selectshowid1.split(",");
		for (var t = 0; t < arr.length; t++) {
			$("#" + arr[t]).attr("disabled","disabled");
		}
	}
	var selectshowid = disableInput[value];
	if (selectshowid != undefined) {
		var arr = selectshowid.split(",");
		for (var t = 0; t < arr.length; t++) {
			$("#" + arr[t]).removeAttr("disabled");
		}
	}
}
/**
	 * 控制radio的选择显示那个
	 * 
	 * 
	 * radioName  radio  的name
	 * display  对于那个值显示那个id {0:"id1", 1:"id2"}
	 * 
	 * 
	 */

	function checkboxSetDisplay(radioName, display)
	{
		var arry = radioName.split(".")
		var str = "input[type='checkbox']";
		for(var j =0; j < arry.length; j++)
		{
			str += "[name*='" + arry[j] + "']";
		}
		//隐藏所有
		$(str).each(function(){
			var obj1 = $(this);
			var selectshowid1 = display[obj1.attr("value")];
			if(obj1.attr("checked"))
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).show();
				}
			}
			else
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).hide();
				}
			}	
			
			$(this).bind("click", function(){
			var obj = $(this);
			if(obj.attr("checked"))
			{
				var selectshowid = display[obj.attr("value")];
				if(selectshowid != undefined)
				{
					$("#" + selectshowid).show();
				}
			}else
			{
				var selectshowid = display[obj.attr("value")];
				if(selectshowid != undefined)
				{
					$("#" + selectshowid).hide();
				}
			}
			});
		});
	}
	
	/**
	 * 控制radio的选择显示那个
	 * 
	 * 
	 * radioName  radio  的name
	 * display  对于那个值显示那个id {0:"id1", 1:"id2"}
	 * 
	 * 
	 */

	function radioSetDisplay(radioName, display)
	{
		var arry = radioName.split(".")
		var str = "input[type='radio']";
		for(var j =0; j < arry.length; j++)
		{
			str += "[name*='" + arry[j] + "']";
		}
		//隐藏所有
		$(str).each(function(){
			var obj1 = $(this);
			var selectshowid1 = display[obj1.attr("value")];
			if(obj1.attr("checked"))
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).show();
				}
			}
			else
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).hide();
				}
			}	
			
			$(this).bind("click", function(){
			for(p in display){
	 			$("#"+display[p]).hide();
			}
			var obj = $(this);
			if(obj.attr("checked"))
			{
				var selectshowid = display[obj.attr("value")];
				if(selectshowid != undefined)
				{
					$("#" + selectshowid).show();
				}
			}
			});
		});
	}
	
	

	/**
	 * 
	 * selectName 对于select的name属性的值 display 对于那个值显示那个id {'02':"id1", '01':"id2"}
	 * 
	 */
function selectSetDisplay(selectName, display, disableInput) {
	var arry = selectName.split(".")
	var str = "select";
	for (var j = 0; j < arry.length; j++) {
		str += "[name*='" + arry[j] + "']";
		
	}
	// 隐藏所有
	$(str).each(function() {
		var obj1 = $(this);
		initDisplay(obj1.attr("value"), display);
		if(disableInput != undefined)
			initDisableInput(obj1.attr("value"), disableInput);
		$(this).bind("change", function() {
			changeDisplay($(this).val(), display);
			if(disableInput != undefined)
				changeDisableInput($(this).val(), disableInput);
		});
	});
}


function checkBoxDisableByValue(selectName, disableV)
{
	var arry = selectName.split(".")
	var str = "input[type='checkbox']";
	for(var j =0; j < arry.length; j++)
	{
		str += "[name*='" + arry[j] + "']";
	}
		//隐藏所有
	$(str).each(function(){
		var outO = $(this);
		if(outO.val() == disableV)
		{
			if(outO.attr("checked"))
			{
				$(str).each(function(){
						$(this).attr("checked",'');
						$(this).attr("disabled","true");
					});
					outO.attr("checked",'true');
					outO.attr("disabled","");
					
			}
			else
			{
					$(str).each(function(){
						$(this).attr("disabled","");
					});
			}
		}
		else
		{
			if(outO.attr("checked"))
			{
				$(str).each(function(){
						if($(this).val()==disableV)
						{
							$(this).attr("checked",'');
						}
					});
					
			}
			
		}
		
		$(this).bind("click", function(){
			if(outO.val() == disableV)
			{
				if(outO.attr("checked"))
				{
					$(str).each(function(){
						$(this).attr("checked",'');
						$(this).attr("disabled","true");
					});
					outO.attr("checked",'true');
					outO.attr("disabled","");
					
				}
				else
				{
					$(str).each(function(){
						$(this).attr("disabled","");
					});
				}
			}
			else
			{
				
			}		
		});
	});
}

	function radioSetDisable(radioName, display)
	{
		var arry = radioName.split(".")
		var str = "input[type='radio']";
		for(var j =0; j < arry.length; j++)
		{
			str += "[name*='" + arry[j] + "']";
		}
		//隐藏所有
		$(str).each(function(){
			var obj1 = $(this);
			var selectshowid1 = display[obj1.attr("value")];
			if(obj1.attr("checked"))
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).attr('disabled','');
				}
			}
			else
			{
				if(selectshowid1 != undefined)
				{
					$("#" + selectshowid1).attr('disabled','disabled');
				}
			}	
			
			$(this).bind("click", function(){
			for(p in display){
	 			$("#"+display[p]).attr('disabled','disabled');
			}
			var obj = $(this);
			if(obj.attr("checked"))
			{
				var selectshowid = display[obj.attr("value")];
				if(selectshowid != undefined)
				{
					$("#" + selectshowid).attr('disabled','');
				}
			}
			});
		});
	}
	


//备用
function regUserUploadFile(id)
{
	$.ajaxFileUpload({
                url:'<%=path%>/ruadmin/reguseruploadfile.do', 
                secureuri:false,
                fileElementId:'uploadfile',
                dataType: 'json',
                success: function (data, status)
                {
                    if(typeof(data.error) != 'undefined')
                    {
                        if(data.error != '')
                        {
                            alert(data.error);
                        }else
                        {
                            alert(data.msg);
                        }
                    }
                },
                error: function (data, status, e)
                {
                    alert(e);
                }
            }
        );
}
function  buildArray2Str(arr)
{
	var str = "";
	for(var i = 0; i < arr.length; i++)
	{
		if(i != 0)
			str += ",";
		str += arr[i];
	}
	return str;
}

function openDialog(location, arg)
{
	openDialog(location, arg, 300,400)
}

function openDialog(location, arg,width, height)
{
	window.showModalDialog(location, arg,"dialogWidth=" + width +"px,dialogHeight=" + height + "px")
}

function openWindow(location)
{
	openWindow2(location, 600,300,50,50);
}
function openWindow(location, width, height, left, top) {
	window.open(location, "noticeWin", "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=auto,resizable=yes,location=no, status=no");
}

function openWindow2(location, width, height, left, top) {
	window.open(location, "noticeWin", "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=auto,resizable=yes,location=no, status=no");
}
function openWindow(location,name, width, height, left, top)
{
	window.open(location, name, "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=auto,resizable=yes,location=no, status=no");
}

function openWindow(location,name, width, height)
{
	var top = (screen.availHeight - height)/2;
	var left = (screen.availWidth-width) /2;
	window.open(location, name, "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=no,resizable=yes,location=no, status=no");
}
/**
 * 对单人分析的打开页面
 * @param location
 * @param name
 * @param width
 * @param height
 */
function openWindow4Analysis(location,name, width, height)
{
	var top = (screen.availHeight - height)/2;
	var left = (screen.availWidth-width) /2;
	window.open(location, name, "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=yes,resizable=yes,location=no, status=no");
}
function openWindow2(location,name, width, height)
{
	var top = (screen.availHeight - height)/2;
	var left = (screen.availWidth-width) /2;
	window.open(location, name, "height=" + height + ", width=" + width + ", top=" + top + ", left=" + left + ", toolbar=no, menubar=no, scrollbars=auto,resizable=no,location=no, status=no");
}
showRightMessage = PB.Tools.showRightMessage;
showErrorMessage = PB.Tools.showErrorMessage;
showConfirm = PB.Tools.showConfirm;
showPromptMessage= PB.Tools.showPromptMessage;
commonSysEditData = PB.Tools.commonSysEditData
commonSysDelData = PB.Tools.commonSysDelData;
unloadingFunc = PB.Tools.unloadingFunc;

function respwd(url){
	$.messager.confirm('重置提示', '你确认要重置密码吗？', function(r){
			if (r){
					$.post(url,function(data){
						if(data == "success"){
							showRightMessage('重置结果','重置成功');
						}else{
							showErrorMessage('重置结果', '重置失败');
						}
					});
				}
			});
}
function checkUpload(obj,path){
	var str=obj.substring(obj.lastIndexOf(".")+1);
	return checkFiles(str,path);
}

function checkFiles(str,path)
{
	//var obj=document.getElementById("addform_info_fileType");
	//var value=obj.options[obj.selectedIndex].text;//这里也是取值
	var strRegex = "(xls|txt)$";
	var re=new RegExp(strRegex);
	if (re.test(str.toLowerCase())){
		loadingFunc(path);
		return true;
	}
	else{
	    showRightMessage('操作失败','上传文件必须为Excel或txt格式'); 
	    return false;
	}
} 






function createAutoCoplete(id,url, option)
{
	var curOption = {        
		    delay:10,
			minChars:2,
			matchSubset:1,
			matchContains:1,
			cacheLength:10,
			autoFill:true
		};
	jQuery.extend(curOption, option);
	$('#' + id).autocomplete(url,option);
}
/**
 * 打开接入方式的的对话框
 */
function openAccessDialog(basePath, id, name)
{
	openDialog(basePath + '/ruadmin/common/usercommon!showAccessSelect.do?r=' + new Date().getTime(), {'id':$('#' + id), 'name': $("#" + name)}, 320,360);
	//openWindow(basePath + '/ruadmin/common/usercommon!showAccessSelect.do?r=' + new Date().getTime());
}

function openSysAccessDialog(basePath, id, name)
{
	openDialog(basePath + '/ruadmin/common/usercommon!showAccessSelect.do?r=' + new Date().getTime(), {'id':$('#' + id), 'name': $("#" + name)}, 320,360);
}

function openSysAccessDialog(basePath, id, name,userid)
{
	openDialog(basePath + '/sys/common/sysusercommon!showAccessSelect.do?r=' + new Date().getTime() + '&regUser.id=' + userid, {'id':$('#' + id), 'name': $("#" + name)}, 320,360);
}


function getPopLay(url,array,buttonName){
	Boxy.load(url,array,buttonName);
}

function back(url){
	window.location.href=url;
}
function test(ids,code,path){
		openWindow(path+"/ruadmin/icp/applyicp!getMessage.do?appObj.modelIds="+ids+"&appObj.code="+code+"");
}
function loadingFunc(path, domid)
{
	var opt = {
            message : path==undefined?'正在查询，请稍等.......':'<img src="' +path + '/images/loading.gif" />',
            css : {
                width : '160px'
            },
            cursor : 'wait',
            fadeOut:0,
            fadeIn:0
        };
	if(domid != undefined)
	 {
	 		$("#" + domid).block(opt);
	 }
	 else
	 {
	 	 $.blockUI( opt);
	 }
	
}


    
    function saveQueryLog(formId, data, func) {
		var options = {
		    success: function(responseText) {
		    	if(func != undefined){
		    		func(responseText);
		    	}
		    },
		    data : data
		};
		$('#' + formId).ajaxSubmit(options);
    }
	
