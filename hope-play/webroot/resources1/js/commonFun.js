/**
 * 
 * @param dlgid  窗口ID
 * @param jboxType  类型  inline/div/iframe/load 
 * @param href  关联URL
 * @param width 
 * @param height
 * @param center  是否中心 boolean型
 * @param minimizable    boolean型
 * @param resize   boolean型
 * @param model   boolean型   是否屏蔽背景 
 * @param draggable   boolean型
 * @param scrolling   boolean型  是否滚动条
 * @param buttons   按键   
 * buttons={
 *			'关闭': function() {
 *			$('#jb'+dlgid).disposejBox();
 *		},
 *		'确认': function() {
 *			callBack(); //需要执行的js方法
 *			$('#jb'+dlgid).disposejBox();
 *		}
 *	};
 *date传送连接数据  只有 jboxType为load写法{id:id,name:name} 
 * @return
 */
function jBoxOpen(dlgid,jboxType,href,data,title,width,height,center,minimizable,resize,model,draggable,scrolling,buttons){
	if(jboxType==""){
		jboxType="load";
	}
	jBox.open(dlgid,jboxType,href,data,title,'width='+width+',height='+height+',center='+center+',minimizable='+minimizable+',resize='+resize+',model='+model+',draggable='+draggable+',scrolling='+scrolling,buttons);
	
}

/**
 * 
 * @param dlgid  窗口ID
 * @param jboxType  类型  inline/div/iframe/load 
 * @param href  关联URL
 * @param width 
 * @param height
 * @param buttons   按键   
 * buttons={
 *			'关闭': function() {
 *			$('#jb'+dlgid).disposejBox();
 *		},
 *		'确认': function() {
 *			callBack(); //需要执行的js方法
 *			$('#jb'+dlgid).disposejBox();
 *		}
 *	};
 */
function jBoxOpenSimple(dlgid,jboxType,href,data,title,width,height,buttons){
	if(jboxType==""){
		jboxType="load";
	}
	var randomNum=GetRandomNum(0,10000);
	if(typeof buttons == "object")
	{
		jBox.open(dlgid,jboxType,href,data,title,'width='+width+',height='+height+',center=true,minimizable=true,resize=true,model=true,draggable=true,scrolling=true',buttons);
	}
	else
	{
		var buttons1={
				'确认': function() {
					if(typeof buttons == 'string')
					{
						$('#' + buttons).trigger("submit");
					}
					else
					{
						buttons();
					}
				}
		};
		jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons1);
	}
	
	
	
}

function selectTree(dlgid, url, width, height, title, closeFlag, formId,
		areaCodeId, areaNameId) {
	jBox.open('iframe-jBoxID'+dlgid,'load',url,title,'width='+width+',height='+height+',center=true,minimizable=true,resize=true,draggable=true,scrolling=true');
}


function showDialog(dlgid,url,width,height,title,closeFlag,fun){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				fun();
				$('#jb'+dlgid).disposejBox();
			}
	};
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
}
$.ajaxSetup ({
    cache: false //关闭AJAX相应的缓存
});
//创建没有传值
function createUiDialog(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				callBack();
				$('#jb'+dlgid).disposejBox();
			}
	};
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
	
}
//创建没有传值
function createUiDialogViliDate(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				callBack();
				//$('#jb'+dlgid).disposejBox();
			}
	};
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
	
}

//创建没有传值 ajax
function createUiDialogAjax(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			
			'确认': function() {
				callBack();
				//$('#jb'+dlgid).disposejBox();
			}
	};
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
}

//修改根据点击传值
function updateUiDialog(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				callBack();
				$('#jb'+dlgid).disposejBox();
			}
	};
	var selectId=getselectCheckEd();
	data={randomNum:randomNum,selectId:selectId};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
}

//修改根据点击传值
function updateUiDialogViliDate(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				callBack('jb'+dlgid);
				//$('#jb'+dlgid).disposejBox();
			}
	};
	var selectId=getselectCheckEd();
	data={randomNum:randomNum,selectId:selectId};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
}
function updateParamDialog(dlgid,href,width,height,title,modal,autoOpen,param,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				callBack('jb'+dlgid);
				//$('#jb'+dlgid).disposejBox();
			}
	};
	var selectId=getselectCheckEd();
	data={randomNum:randomNum,selectId:selectId,param:param};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
}
//显示根据点击传值
function showUiDialog(dlgid,href,width,height,title,modal,autoOpen){
	var randomNum=GetRandomNum(0,10000);
	buttons={};
	 var selectId= getselectCheckEd();
	data={randomNum:randomNum,selectId:selectId};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
	
}
//点击页面超连接关闭
function showIdTypeUiDialog(dlgid,href,data,width,height,title,modal){
	buttons={
			
	};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,false,true,true,buttons);
}
//显示数
function showTreeUiDialog(dlgid,href,width,height,title,modal,autoOpen,locationCode,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			
			'确认': function() {
				callBack();
				$('#jb'+dlgid).disposejBox();
			}
	};
	
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,false,true,buttons);
}

//是否启用
var onOff;

function getOnOff(){
	if(onOff!=null){
		return onOff;
	}
}

/**
 * 多table的tr选择
 * 只支持一项table tr选择
 * @param id
 * @param trObj
 * @param tableName
 * @return
 */
function selectElementYhh1(id,trObj,tableName){
  if(!tableSelectMap.containsKey(tableName+','+id)){
	  $("#"+tableName).find("#tr"+id).addClass("mainmiddleonclicktr"); 
      for (var i = 0; i < tableSelectMap.size(); i++) {
        var key=tableSelectMap.ArrayIterative(i);
        $("#"+key.split(',')[0]).find("#tr"+ key.split(',')[1]).removeClass("mainmiddleonclicktr");
        tableSelectMap.remove(key);
      }
      tableSelectMap.put(tableName+','+id,"");
  }	else{
	  $("#"+tableName).find("#tr"+id).removeClass("mainmiddleonclicktr");
      tableSelectMap.remove(tableName+','+id);
  }
}


function selectElementYhh(id,isOff){
  if(!tableSelectMap.containsKey(id)){
  	 $("#tr"+id).addClass("mainmiddleonclicktr"); 
      for (var i = 0; i < tableSelectMap.size(); i++) {
        var key=tableSelectMap.ArrayIterative(i);
        $("#tr"+key).removeClass("mainmiddleonclicktr");
        tableSelectMap.remove(key);
      }
      tableSelectMap.put(id,"");
      onOff = isOff;
  }	else{
      $("#tr"+id).removeClass("mainmiddleonclicktr");
      tableSelectMap.remove(id);
  }
}


//点击选择
var tableSelectMap=new Map();
function selectElement(id,trObj){
//  var temp=tableSelectMap.indexOfKey(id);
  if(!tableSelectMap.containsKey(id)){
	  
  	 $("#tr"+id).addClass("mainmiddleonclicktr"); 
      for (var i = 0; i < tableSelectMap.size(); i++) {
        var key=tableSelectMap.ArrayIterative(i);
        $("#tr"+key).removeClass("mainmiddleonclicktr");
        tableSelectMap.remove(key);
      }
      tableSelectMap.put(id,"");
  }	else{
      $("#tr"+id).removeClass("mainmiddleonclicktr");
      tableSelectMap.remove(id);
  }
}

function getselectCheckEd(){
  var check="";
  if(tableSelectMap.size()==0){
		return check;
	}
  for (var i = 0; i < tableSelectMap.size(); i++) {
      var key=tableSelectMap.ArrayIterative(i);
      if( check!=""){
          check=check+",";
      }
      check=check+key;
  }
  //alert(check);
  return check;
}

//点击自定义列表名称选择
var tableCustomSelectMap=new Map();
function selectElementMore(id,trObj,tableName){
//var temp=tableCustomSelectMap.indexOfKey(tableName);
if(!tableCustomSelectMap.containsKey(tableName)){
//if(temp==""){
	  temp=new Map();
	  tableCustomSelectMap.put(tableName,temp);
}
var selectMap=tableCustomSelectMap.get(tableName);
selectMap=selectMap.value;
//var tmap=selectMap.indexOfKey(id);
	 if(!selectMap.containsKey(id)){
	 		$("#"+tableName+id).addClass("mainmiddleonclicktr"); 
	      for (var i = 0; i < selectMap.size(); i++) {
	        var key=selectMap.ArrayIterative(i);
	        $("#"+tableName+key).removeClass("mainmiddleonclicktr");
	        selectMap.remove(key);
	      }
	       
	      selectMap.put(id,"");
	      tableCustomSelectMap.put(tableName,selectMap);
	  }	else{
		  $("#"+tableName+id).removeClass("mainmiddleonclicktr"); 
	      selectMap.remove(id);
	      tableCustomSelectMap.put(tableName,selectMap);
	  }
}

function getselectCheckEdMore(tableName){
var check="";
if(tableCustomSelectMap.size()>0){
	var selectMap=tableCustomSelectMap.get(tableName);
	selectMap=selectMap.value;
	for (var i = 0; i < selectMap.size(); i++) {
	    var key=selectMap.ArrayIterative(i);
	    if( check!=""){
	        check=check+",";
	    }
	    check=check+key;
	}
}
return check;
}




//点击多选选择
var tableMultipleSelectMap=new Map();
function selectMultipleElement(id,trObj){
//var temp=tableMultipleSelectMap.indexOfKey(id);
if(!tableMultipleSelectMap.containsKey(id)){
//if(temp==""){
	  $("#tr"+id).addClass("mainmiddleonclicktr"); 
    tableMultipleSelectMap.put(id,"");
}	else{
	  $("#tr"+id).removeClass("mainmiddleonclicktr"); 
    tableMultipleSelectMap.remove(id);
}
}

function getselectMultipleCheckEd(){
var check="";
if(tableMultipleSelectMap.size()==0){
	return check;
}
for (var i = 0; i < tableMultipleSelectMap.size(); i++) {
    var key=tableMultipleSelectMap.ArrayIterative(i);
    if( check!=""){
        check=check+",";
    }
    check=check+key;
}
//alert(check);
return check;
}
//checkEd 1 :全选    0 全部撤销选择
function checkAllTableEd(checkEd,elementsByName){
	if(checkEd){
		var objArr=document.getElementsByName(elementsByName);
		for(var i=0;i<objArr.length;i++){
			  $("#tr"+objArr[i].value).addClass("mainmiddleonclicktr"); 
			//objArr[i].style='mainmiddleonclicktr';
			  tableMultipleSelectMap.put(id,"");
		}
	}else {
		var objArr=document.getElementsByName(elementsByName);
		for(var i=0;i<objArr.length;i++){
			 $("#tr"+objArr[i].value).removeClass("mainmiddleonclicktr"); 
			//objArr[i].style.backgroundColor='';
		}
		 tableMultipleSelectMap=new Map();
	}
}
//随机数
function GetRandomNum(Min,Max){
    var Range = Max - Min;
    var Rand = Math.random();
    return(Min + Math.round(Rand * Range));
}

function creat(){
var a = GetRandomNum(0,9); 
document.getElementById('links').innerHTML=a;
}
var bombWin = null;
function NewWindow(mypage,myname,w,h,scroll){
	LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
	TopPosition = (screen.height) ? (screen.height-h)/2 : 0;
	settings ='height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',resizable';
	bombWin = window.open(mypage,myname,settings);
	bombWin.focus();
}

var bombWin = null;
function NewWindowToZora(mypage,myname,w,h,scroll){
	settings ='height='+h+',width='+w+',top=0,left=0,scrollbars='+scroll+',resizable';
	bombWin = window.open(mypage,myname,settings);
	bombWin.focus();
}

function showMessageDiv(id,title,content,width,higth){
	showjDiv($("#"+id), title,content, width, higth);
}

function dateRestrictStart(dateEnd,dateFmt){
	var dateTm=dateFmt.replace("yy","%y");
	dateTm=dateTm.replace("MM","%M");
	dateTm=dateTm.replace("dd","%d");
	dateTm=dateTm.replace("HH","%H");
	dateTm=dateTm.replace("mm","%m");
	dateTm=dateTm.replace("ss","%s");
	WdatePicker({startDate:"%y-%M-%d",dateFmt:dateFmt,skin:"whyGreen",errDealMode:"0",onpicked:function(){},maxDate:"#F{$dp.$D(\'"+dateEnd+"\')}"});
}
function dateRestrictEnd(dateStart,dateFmt){
	var dateTm=dateFmt.replace("yy","%y");
	dateTm=dateTm.replace("MM","%M");
	dateTm=dateTm.replace("dd","%d");
	dateTm=dateTm.replace("HH","%H");
	dateTm=dateTm.replace("mm","%m");
	dateTm=dateTm.replace("ss","%s");
	WdatePicker({minDate:"#F{$dp.$D(\'"+dateStart+"\')}",maxDate:"%y-%M-%d",startDate:"%y-%M-%d",dateFmt:dateFmt,skin:"whyGreen",errDealMode:0});
}

//获得当前时间
function getToday(sep) {
	var today;
    currYear = new Date().getFullYear();
    currMonth = new Date().getMonth() + 1;
    if(currMonth < 10) {
    	currMonth = "0" + currMonth;
    }
    today = new Date().getDate();
    //if(today!=1){
       //today = today - 1;
    //}
    
    if(today < 10) {
    	today = "0" + today;
    }
    return(currYear + sep + currMonth + sep + today);
}

//全选
function selectAllInTable(srcCheckbox,checkboxName)
{
	var tableObj=null;
	for(tableObj=srcCheckbox.parentElement;tableObj.tagName!="TABLE";tableObj=tableObj.parentElement);
	var elements=tableObj.getElementsByTagName("input");
	for(var i=0;i<elements.length;i++)
	{
		if(elements[i].name==checkboxName)
			elements[i].checked=srcCheckbox.checked;
	}
}

//列表选择改变时(全选)
function changeChecked(srcCheckbox,checkAllName)
{
	var tableObj=null;
	var checkAll=null;
	for(tableObj=srcCheckbox.parentElement;tableObj.tagName!="TABLE";tableObj=tableObj.parentElement);
	var elements=tableObj.getElementsByTagName("input");
	var checkFlg=true;
	for(var i=0;i<elements.length;i++)
	{
		if(elements[i].name==checkAllName)
			checkAll=elements[i];
		if(elements[i].name==srcCheckbox.name&&!elements[i].checked)
			checkFlg=false;
	}
	if(checkFlg)
		checkAll.checked=true;
	else
		checkAll.checked=false;
}

/**
 * 功能：获得选中的id和name字符串数组(格式:['id1,id2,id3','name1,name2,name3'])
 */
function getCheckedIdName(ckid,ckname,ckallId,ckallName){
	var checkIdStr = "";
	var checkNameStr = "";
	
	//如果全选的值也要回传时使用
	if("undefined" != typeof(ckallId) && ckallId != "" && "undefined" != typeof(ckallName) && ckallName != ""){
		var ckallidObj = document.getElementsByName(ckallId);
		var ckallnameObj = document.getElementsByName(ckallName);
		if((ckallidObj && "undefined" != typeof(ckallidObj) && ckallidObj.length > 0)
				&& (ckallnameObj && "undefined" != typeof(ckallnameObj) && ckallnameObj.length > 0)
				&& ckallidObj[0].checked == true){
			checkIdStr += ckallidObj[0].value + ",";
			checkNameStr += ckallnameObj[0].value + ",";
		}
	}
	
	//拼接选中的id和name字符串(格式：id1,id2,id3,@name1,name2,name3,)
	var ids = document.getElementsByName(ckid);
	var names = document.getElementsByName(ckname);
	if(ids && ids.length > 0){
		for(var i = 0, n = ids.length; i < n; i++){
			if(ids[i].checked==true){
				checkIdStr += ids[i].value + ",";
				checkNameStr += names[i].value + ",";
			}
		}
	}

	//删除最后的,
	if(checkIdStr && checkIdStr.length > 0){
		checkIdStr = checkIdStr.substring(0, checkIdStr.length-1);
		checkNameStr = checkNameStr.substring(0, checkNameStr.length-1);
	}
	return (checkIdStr + "@" + checkNameStr).split("@");
}