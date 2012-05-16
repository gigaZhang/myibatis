/*定义包*/
if(!window.PB)
{
	window.PB = new Object();
}
if(!window.PB.Monitor)
{
	window.PB.Monitor = new Object();
}
/**
*显示和隐藏每个模块的东西
**/
PB.Monitor.ShowInfo = function(flag)
{
	$("#" + flag + "_hidden_img").toggle();
	$("#" + flag + "_show_img").toggle();
	$("#" + flag + "_info_div").toggle();
}

/**
*保存信息的功能，
divId：父亲ID，如果不为空，那么就把返回的内容替换到这个ID里面。如果为空就找form的父亲div id
**/
PB.Monitor.InfoSave = function(formId, divId)
{
	var formParentId = "";
	if(divId == undefined)
	{
		formParentId = $("#"+formId).parent("div[id]").attr("id");
	}
	else
	{
		formParentId = divId;
	}
	var options = {
		    success: function(responseText) {
		    	$("#"+formParentId).html(responseText);
		    	PB.Tools.unloadingFunc( formParentId);
		    },
		    data : {'r':new Date().getTime()}
		};
	PB.Tools.loadingFunc(formParentId);
	$('#' + formId).ajaxSubmit(options);	
}
/**
*和PB.Monitor.InfoSave不一样的地方就是要检测输入的值
type 类型，根据类型判断是那种表单。
formId： 表单的ID
divId: 父亲表单
**/
PB.Monitor.InfoSaveWithCheck = function(type, formId,divId)
{
	var checkFunc;
	if(type == 1)
	{
		checkFunc = PB.Monitor.CheckMonitorInfo1;
	}
	else if (type==2)
	{
		checkFunc = PB.Monitor.CheckMonitorInfo2;
	}
	else if (type==3)
	{
		checkFunc = PB.Monitor.CheckTarget;
	}
	checkFunc(formId,divId);
	$("#" + formId).submit();
}
/**
布控基本信息头部的验证
**/
PB.Monitor.CheckTarget = function(formId, divId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.targetInfo.chnName':{
						required:true
					}
				},
				messages:{
					'info.targetInfo.chnName':{
						required:"请输入中文名称"
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSave(formId,divId);	
				}
	    	});
}
/**
布控基本信息头部的验证
**/
PB.Monitor.CheckMonitorInfo1 = function(formId, divId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.monitorInfo.caseName':{
						required:true
					},
					'info.monitorInfo.monitorMeanArr':{
						required:true
					},
					'info.monitorInfo.caseUnit':{
						required:true
					}
				},
				messages:{
					'info.monitorInfo.caseName':{
						required:"请输入案件名称"
					},
					'info.monitorInfo.monitorMeanArr':{
						required:"请选择侦控手段"
					},
					'info.monitorInfo.caseUnit':{
						required:"请输入交案单位"
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSave(formId,divId);	
				}
	    	});
}


PB.Monitor.CheckMonitorInfo2 = function(formId, divId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.monitorInfo.caseAimArr':{
						required:true
					},
					'info.monitorInfo.startTime':{
						required:true
					},
					'info.monitorInfo.endTime':{
						required:true
					}
				},
				messages:{
					'info.monitorInfo.caseAimArr':{
						required:'请选择侦控目的和要求'
					},
					'info.monitorInfo.startTime':{
						required:'请选择开始时间'
					},
					'info.monitorInfo.endTime':{
						required:'请选择结束时间'
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSave(formId,divId);	
				}
	    	});
}

/**
更新页面 侦控对象的基本情况 id 对象的ID
**/
PB.Monitor.TargetUpdateInput = function(id)
{	
	var name="target";
	var url = window.PB.ContextPath + '/sys/monitor/target/' + name + '!updateInput.do';
	$("#"+ name + "_info_div").load( url,{'info.targetInfo.id':id});
}
/**
	更新页面，侦控目标基本情况 id 对象id
**/
PB.Monitor.AimUpdateInput = function(id)
{	
	var name="aim";
	var url = window.PB.ContextPath + '/sys/monitor/aim/' + name + '!updateInput.do';
	$("#"+ name + "_info_div").load( url,{'info.monitorAim.id':id});
}

/**

更新页面，布控基本信息头部的更新 id 对象id
**/
PB.Monitor.MonitorInfo1UpdateInput = function(id)
{	
	var name="monitorinfo1";
	var url = window.PB.ContextPath + '/sys/monitor/info/' + name + '!updateInput.do';
	$("#"+ name + "_info_div").load( url,{'info.monitorInfo.id':id});
}

PB.Monitor.MonitorInfo2UpdateInput = function(id)
{	
	var name="monitorinfo2";
	var url = window.PB.ContextPath + '/sys/monitor/info/' + name + '!updateInput.do';
	$("#"+ name + "_info_div").load( url,{'info.monitorInfo.id':id});
}


/************对于多个关联的操作****************/

/**
跳转到更新页面
**/
PB.Monitor.InfoUpdateInput = function(info_type, id,replaceId)
{
	var url = window.PB.ContextPath + '/sys/monitor/' + info_type + '/' + info_type + '!updateInput.do';
	$.post(url, {'info.id':id},function(d){
		if(replaceId != undefined)
		{
			$("#" + replaceId).after(d);
			$("#" + replaceId).remove();
		}
		else{		
			$("#" + info_type + "_div").append(d);
		}
	});
}

/**
保存信息并替换以前的id

*/
PB.Monitor.InfoSaveRepace = function(formId, replaceId)
{
	var options = {
		    success: function(responseText) {
		    	$("#"+replaceId).after(responseText);
		    	$("#"+replaceId).remove();
		    	PB.Tools.unloadingFunc( replaceId);
		    },
		    data : {'r':new Date().getTime()}
		};
	PB.Tools.loadingFunc(replaceId);
	$('#' + formId).ajaxSubmit(options);	
}

PB.Monitor.InfoCheckSaveRepace = function(type, formId, replaceId)
{
	var checkFunc;
	if(type == 1)
	{
		checkFunc = PB.Monitor.CheckRelatedPerson;
	}
	else if (type ==2)
	{
		checkFunc =  PB.Monitor.CheckMonitorClue;
	}
	else if (type = 3)
	{
		checkFunc = PB.Monitor.CheckMonitorCtor;
	}
	checkFunc(formId,replaceId);
	$("#" + formId).submit();
}


PB.Monitor.CheckRelatedPerson = function(formId, replaceId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.relation':{
						required:true
					}
				},
				messages:{
					'info.relation':{
						required:"请输入关系名称"
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSaveRepace(formId,replaceId);	
				}
	    	});
}
/**
检测布控线索
**/
PB.Monitor.CheckMonitorClue = function(formId, replaceId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.idCode':{
						required:true
					}
				},
				messages:{
					'info.idCode':{
						required:"请输入布控身份"
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSaveRepace(formId,replaceId);	
				}
	    	});
}
/**
检测联系人
**/
PB.Monitor.CheckMonitorCtor = function(formId, replaceId){
	$("#" + formId).validate({
	    		onkeyup:false,
				rules:{
					'info.name':{
						required:true
					},
					'info.shortCellNumber':{
						required:true
					}
				},
				messages:{
					'info.name':{
						required:"请输入联系人姓名"
					},
					'info.shortCellNumber':{
						required:"请输入手机短号"
					}
				},
				
				submitHandler:function(form){
					PB.Monitor.InfoSaveRepace(formId,replaceId);	
				}
	    	});
}
/**
对于多个列表删除的操作
type: 类型 也作为后台Action的名称
oper:操作
index:第几个
id:删除对象的Id
**/
PB.Monitor.DeleteInfo = function(type,oper,index,id)
{	
	var divId = type + "_" + oper + index;
	if(id != undefined && id !='' )
	{
		var url = window.PB.ContextPath + '/sys/monitor/' + type + '/' + type + '!del.do';
		$.post(url,{'info.id':id},function(d){
			if(d=='true')
			{
				$("#" + divId).remove();
			}
			else
			{
				alert("删除失败!");
			}
		})
	}
	else
	{
		$("#" + divId).remove();
	}
}
/**
系统中添加操作输入界面
**/
PB.Monitor.AddInputInfo = function(info_type, baseId)
{
	var info_num = $("#" + info_type + "_num").val();
	info_num++;
	$("#" + info_type + "_num").val(info_num);
	var url = window.PB.ContextPath + '/sys/monitor/' + info_type + '/' + info_type + '!addInput.do';
	$.post(url, {'infoNum':info_num,'info.monitorBase.id':baseId},function(d){
		$("#" + info_type + "_div").append(d);
	});
}



PB.Monitor.AddAndSubmit = function()
{
	var targetName = $("#MonitorTarget").val();
	if(targetName == '')
	{
		PB.Tools.showErrorMessage("提示","请输入侦控对象。");
		$("#MonitorTarget").focus();
		return;
	}
	var url = window.PB.ContextPath + '/sys/monitor/base/monitorcu!addAndSubmit.do';
	$.post(url,{
		'info.id':$("#MonitorBaseId").val(),
		'info.monitorTarget':targetName,
		'info.continueFlag':$("#ContinueFlag").val()
	},function(d){
		if(d=='true')
		{
			PB.Tools.showRightMessage("提示","提交成功。",function(){
				PB.MainUI.showPageInRight('/sys/monitor/base/monitormy/monitormy!listPage.do');
			});
		}
		else
		{
			PB.Tools.showErrorMessage("提示",d);
		}
	
	});
}
PB.Monitor.AddAndSubmitById = function(id)
{
	var url = window.PB.ContextPath + '/sys/monitor/base/monitorcu!addAndSubmitById.do?info.id='+id;
	$.messager.confirm('申请提示', '你确认要提交申请吗？', function(r){
	if(r){
		$.post(url,function(data){
			if(data=='true')
		{
			PB.Tools.showRightMessage("提示","提交成功。",function(){
				PB.MainUI.showPageInRight('/sys/monitor/base/monitormy/monitormy!listPage.do');
			});
		}
		else
		{
			PB.Tools.showErrorMessage("提示",data);
		}
		});
	}
	});
}
/**添加那位临时状态
**/
PB.Monitor.AddCreateStatus = function(){
var targetName = $("#MonitorTarget").val();
	if(targetName == '')
	{
		PB.Tools.showErrorMessage("提示","请输入侦控对象。");
		$("#MonitorTarget").focus();
		return;
	}
	var url = window.PB.ContextPath + '/sys/monitor/base/monitorcu!add.do';
	$.post(url,{
		'info.id':$("#MonitorBaseId").val(),
		'info.monitorTarget':targetName,
		'info.continueFlag':$("#ContinueFlag").val()
	},function(d){
		if(d=='true')
		{
			PB.Tools.showRightMessage("提示","操作成功。",function(){
				PB.MainUI.showPageInRight('/sys/monitor/base/monitormy/monitormy!listPage.do');
			});
		}
		else
		{
			PB.Tools.showErrorMessage("提示","添加失败。");
		}
	});
}