
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
	jBox.open(dlgid,jboxType,href,data,title,'width='+width+',height='+height+',center=true,minimizable=true,resize=true,model=true,draggable=true,scrolling=true',buttons);
}

function selectTree(dlgid, url, width, height, title) {
	jBox.open('iframe-jBoxID'+dlgid,'load',url,title,'width='+width+',height='+height+',center=true,minimizable=true,resize=true,draggable=true,scrolling=true');
}


function showDialog(dlgid,url,width,height,title,closeFlag,fun){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				if(typeof fun == 'function')
					fun();
				$('#jb'+dlgid).disposejBox();
			}
	};
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',url,data,title,width,height,true,true,true,true,true,true,buttons);
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
/**
 * callBack function or formid
 */
createUiDialogViliDate = function(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			'确认': function() {
				if(typeof callBack == 'string')
				{
					$('#' + callBack).trigger("submit");
				}
				else
				{
					callBack();
				}
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
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,true,true,buttons);
	
}
//点击页面超连接关闭
function showIdTypeUiDialog(dlgid,href,data,width,height,title,modal){
	buttons={
			
	};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,false,true,true,buttons);
}
//显示数
function showTreeUiDialog(dlgid,href,width,height,title,modal,autoOpen,callBack){
	var randomNum=GetRandomNum(0,10000);
	buttons={
			
			'确认': function() {
				if(callBack())
					$('#jb'+dlgid).disposejBox();
			}
	};
	
	data={randomNum:randomNum};
	jBoxOpen(dlgid,'load',href,data,title,width,height,true,true,true,true,false,true,buttons);
}

//随机数
function GetRandomNum(Min,Max){
    var Range = Max - Min;
    var Rand = Math.random();
    return(Min + Math.round(Rand * Range));
}

