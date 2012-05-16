/*定义包*/
if(!window.PB)
{
	window.PB = new Object();
}

if(!window.PB.Tools)
{
	window.PB.Tools = new Object();
}


/**
 * 显示装载进度条 
 * 需要jquery.blockUI.js
 */
PB.Tools.loadingFunc = function(domid,msg)
{
	var opt = {
            message : msg?msg:'<img src="' +PB.ContextPath + '/resources1/images/loading.gif" width="100%" height="20" />',
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

/**
 * 隐藏装载进度条 
 * 需要jquery.blockUI.js
 */
PB.Tools.unloadingFunc = function(domid)
{
	 if(domid != undefined)
	 {
	 		$("#" + domid).unblock();
	 }
	 else
	 {
	 	$.unblockUI();
	 }
}

/**
 * 通用的查询，异步装载
 */
PB.Tools.commonSearchQuery = function(responsId, formId, data, func){
	var options = {
		    success: function(responseText) {
				PB.Tools.unloadingFunc( responsId);
		    	$("#" + responsId).html(responseText);
		    	if(func != undefined)
		    	{
		    		func(responseText);
		    	}
		    },
		    dataType:'html',
		    cache:false,
		    data : data
		    
		};
	PB.Tools.loadingFunc(responsId);
	$('#' + formId).ajaxSubmit(options);
	return true;
}



PB.Tools.commonSearchQueryURL = function(responsId, url, data, func){
	PB.Tools.loadingFunc(responsId);
	$.post(url,data,function(responseText){
		$("#" + responsId).html(responseText);
		PB.Tools.unloadingFunc( responsId);
	    if(func != undefined){
	    	func(responseText);
	    }
	});
}
/**
 * 正确对话框
 */
PB.Tools.showRightMessage = function(title, message, callback)
{
	$.ligerDialog.success( message,title,callback);
}

PB.Tools.showErrorMessage = function(title, message, callback)
{
	$.ligerDialog.alert( message, title,callback);
}

PB.Tools.showConfirm = function(title, msg, callback)
{
	$.ligerDialog.confirm(msg,title,callback);
}
PB.Tools.showPromptMessage = function(title, msg, fn)
{
	$.ligerDialog.prompt( msg, title,true, fn);
}


PB.Tools.commonSysDelData = function(table, idp, url,postData, callback)
{
	var rowids = table.getSelectedId();
	if((typeof rowids == "string" && rowids=="") ||
	 	(typeof rowids == "object" && rowids.length < 1) )
	{
		PB.Tools.showErrorMessage('删除提示','请选择你要删除的记录');
		return ;
	}
	PB.Tools.showConfirm ('删除提示', '你确认要删除该记录吗？', function(r){
	if (r){
					var str = rowids;
					if(typeof rowids == "object")
					{
							str = buildArray2Str(rowids);
							
					}
					$.post(url + '?' + idp + '=' + str,postData,function(data){
						if(data == "success"){
							PB.Tools.showRightMessage('删除结果','删除成功');
							if(callback != undefined)
							{
								callback();
							}
						}else{
							PB.Tools.showErrorMessage('删除结果', '删除失败');
						}
					});
				}
			});
}


PB.Tools.commonSysEditData = function(table, callback)
{
	var rowids = table.getSelectedId();
	
	 if((typeof rowids == "string" && rowids=="") ||
	 	(typeof rowids == "object" && rowids.length < 1) )
	{
		 PB.Tools.showErrorMessage('提示','请选择一条你要操作的记录');
		return ;
	}
	if(typeof rowids == "object" && rowids.length != 1)
	{
		PB.Tools.showErrorMessage('提示','请选择一条你要操作的记录');
		return ;
	}
	if(typeof rowids == "string")
	{
			callback(rowids);
	}
	else{
		callback(rowids[0]);
	}
}
/*显示身份对话框的功能*/
PB.Tools.selectIdType = function(id, name){
	
	if($("#idTypeSelectDiv").size()==0)
	{
		$("body").append('<div id="idTypeSelectDiv"></div>');
	}
	$("#idTypeSelectDiv").attr("selectid",id);
	$("#idTypeSelectDiv").attr("selectname",name);
	if($("#jbidTypeSelectDiv").size()> 0)
	{
		$('#jbidTypeSelectDiv').showjBox();
		return ;
	}
	
	var randomNum=GetRandomNum(0,10000);
	var buttons={};
	data={randomNum:randomNum,'selectid':id,'selectname':name,'divid':'idTypeSelectDiv'};
	var href = PB.ContextPath + '/util/idtypeselect.jsp';
	jBox.open("idTypeSelectDiv",'load',href,data,'请选择身份类型','width=400,height=300,center=true,minimizable=true,resize=true,model=false,draggable=true,scrolling=true',buttons);
} 
/*显示身份对话框回调到哪个类型里面*/
PB.Tools.selectIdTypeCallBack = function(idvalue, namevalue)
{
	var id=$("#idTypeSelectDiv").attr("selectid");
	var name=$("#idTypeSelectDiv").attr("selectname");
	$('#' + id).val(idvalue);
	$('#' + name).val(namevalue);
	$('#jbidTypeSelectDiv').hidejBox();
}

PB.Tools.selectIdTypeList = function(id, name){
	if($("#idTypeSelectDiv").size()==0)
	{
		$("body").append('<div id="idTypeSelectDiv"></div>');
	}
	$("#idTypeSelectDiv").attr("selectid",id);
	$("#idTypeSelectDiv").attr("selectname",name);
	if($("#jbidTypeSelectDiv").size()> 0)
	{
		$('#jbidTypeSelectDiv').showjBox();
		return ;
	}
	
	var randomNum=GetRandomNum(0,10000);
	var buttons={};
	data={randomNum:randomNum,'selectid':id,'selectname':name,'divid':'idTypeSelectDiv'};
	var href = PB.ContextPath + '/utility/util!selectIdTypeList.do';
	jBox.open("idTypeSelectDiv",'load',href,data,'请选择身份类型','width=600,height=450,center=true,minimizable=true,resize=true,model=false,draggable=true,scrolling=true',buttons);
};

/**
 * 实现全选功能。check(全选按钮), checkList(选择列表)参数均为jquery对象。
 */
PB.Tools.checkBox = function(check, checkList){
	
	check.bind('click', function(){
		checkList.each(function(){
		 	$(this).attr('checked',check.attr('checked'));
		});
	});
	
	checkList.each(function(){
		$(this).bind('click', function(){
			var bol = true;
			if(!$(this).attr('checked')){
				bol = false;
			}else{
				checkList.each(function(){
					if(!$(this).attr('checked')){
						bol = false;
					}
				});
			}
			check.attr('checked',bol);
	 	});
	});
	
};


function defaultDatePicker(startTm, endTm, monthlimits){
	if(!document.getElementById(startTm).value || !document.getElementById(endTm).value){
		
		var dates = new Date();
		var year = dates.getFullYear();
		var month = dates.getMonth() + 1;
		var date = dates.getDate();
//		var hours = dates.getHours();
		document.getElementById(endTm).value = format(year, month, date);
		if(month < monthlimits){
			year -= 1;
			month = (12 + month) - monthlimits;
		}else{
			month -= monthlimits;
		}
		
		document.getElementById(startTm).value = format(year, month, date);
		
	}
	
	function format(year, month, date){
		return year + '-' + ((month < 10 ? ('0' + (month)) : month)) + '-' + ((date < 10 ? ('0' + date) : date));
	}
}

/**
 * WdatePicker 日历范围选择
 */

PB.Tools.datePickerGroup = function(startTm, endTm, monthlimits){
	
	defaultDatePicker(startTm, endTm, monthlimits);
	
	document.getElementById(startTm).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd',
			alwaysUseStartDate:false,
			errDealMode:1,
			maxDate:'%y-%M-%d',
			onpicked: function(){
				document.getElementById(endTm).focus();
			}
		});
	};
	
	document.getElementById(endTm).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd',
			alwaysUseStartDate:true,
			errDealMode:1,
			minDate:'#F{$dp.$D(\'' + startTm + '\',{});}',
			maxDate:'#F{$dp.$D(\'' + startTm + '\',{M:+' + monthlimits + '})||\'%y-%M-%d\'}'
		});
	};
	
};
/*
PB.Tools.datePickerSelect = function(startLoginAt, endLoginAt, startLogoutAt, endLogoutAt, monthlimits){
	defaultDatePicker(startLoginAt, endLoginAt, monthlimits);
	defaultDatePicker(startLogoutAt, endLogoutAt, monthlimits);
	document.getElementById(startLoginAt).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd HH:mm',
			alwaysUseStartDate:false,
			errDealMode:1,
			maxDate:'%y-%M-%d %H:%m',
			onpicked: function(){
				document.getElementById(endLoginAt).focus();
			}
		});
	};
	
	document.getElementById(endLoginAt).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd HH:mm',
			alwaysUseStartDate:true,
			errDealMode:1,
			minDate:'#F{$dp.$D(\'' + startLoginAt + '\',{});}',
			maxDate:'#F{$dp.$D(\'' + startLoginAt + '\',{M:+' + monthlimits + '})||\'%y-%M-%d %H:%m\'}',
			onpicked: function(){
				document.getElementById(startLogoutAt).focus();
			}
		});
	};
	
	document.getElementById(startLogoutAt).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd HH:mm',
			alwaysUseStartDate:false,
			errDealMode:1,
			startDate: '#F{$dp.$D(\'' + startLoginAt + '\',{});}',
			minDate:'#F{$dp.$D(\'' + startLoginAt + '\',{});}',
			maxDate:'#F{$dp.$D(\'' + endLoginAt + '\',{M:+' + monthlimits + '})\'%y-%M-%d %H:%m\'}',
			//maxDate:'#F{$dp.$D(\'' + endLoginAt + '\',{M:+' + monthlimits + '})||\'%y-%M-%d %H:%m\'}',
			//maxDate:'#F{$dp.$D(\'' + endLoginAt + '\',{M:+' + monthlimits + '})||\'%y-%M-%d %H:%m\'}',
			onpicked: function(){
				document.getElementById(endLogoutAt).focus();
			}
		});
	};
	
	document.getElementById(endLogoutAt).onfocus = function(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			autoPickDate:true,
			dateFmt:'yyyy-MM-dd HH:mm',
			alwaysUseStartDate:true,
			errDealMode:1,
			minDate:'#F{$dp.$D(\'' + startLogoutAt + '\',{});}',
			maxDate:'#F{$dp.$D(\'' + startLogoutAt + '\',{M:+' + monthlimits + '})||\'%y-%M-%d %H:%m\'}'
		});
	};
};
*/
//var datePickerGroupSelect = PB.Tools.datePickerSelect;
var datePicker = PB.Tools.datePickerGroup;
var checkBoxList = PB.Tools.checkBox;
