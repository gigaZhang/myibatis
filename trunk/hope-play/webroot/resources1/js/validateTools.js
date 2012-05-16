// JavaScript Document

//扩展jQuery方法
//判断输入框内容是长度限制
 

$.fn.extend({
			validateInputLength:function(length,message){// length:字符长度,message:提示信息
				var value = $.trim($(this).val());
				if(value.length>length){
					alert(message);
					$(this).focus();
					return true;
				}
				return false;
			},
			checkIsExist:function(url,params,callback){
				$.post(url,params, callback);
			},
			
			showLocationInfo:function(url,serviceCode,callback){
				var parames = {
					'locationCode':serviceCode,
					't':new Date().getTime()
				}; 
				$.post(url,parames,callback);
			}
			,showAutoDate: function(){
				var callback = function(event, date, formatted){
					var res="";
					var dateStr = new String(date);
					if(dateStr.length>4){
					var year = dateStr.substring(0,2);
					var month = dateStr.substring(2,4);
					var day = dateStr.substring(4,6);
					
					if(year.charAt(0)=="0"){
						year = "20"+year;
					}
//					2009-10-23 17:19:01
					res = year+"-"+month+"-"+day+" 00:00";
					}else{
						var year = new Date().getYear();
						var month = dateStr.substring(0,2);
						var day = dateStr.substring(2,4);
						res = year+"-"+month+"-"+day+" 00:00";
					}
					$(this).val(res);
					
				};
				$(this).autocomplete('/police/common/common!createDates.do');
				$(":text, textarea").result(callback).next().click(function() {
					$(this).prev().search();
				});
				
			}
});


 
 



//2个时间段相差多少天 时间格式为2009-01-01 00:00
function getDaysBetween2Time(begin, end){
	if(!isLongDateToM(begin))	{
		alert("日期格式不正确");
		return -1;
	}
	if(!isLongDateToM(end))	{
		alert("日期格式不正确");
		return -1;
	}
	if(isLongDateToM(end) )	{
		return (date2Long(end) - date2Long(begin))/(1000*1*60*60*24);
	}
}
//把dateString 转为long 时间格式为2009-01-01 00:00
function date2Long(str){
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2})$/; 
	var r = str.match(reg); 
	if(r==null)return false; 
	var d= new Date(r[1], r[3]-1,r[4],r[5],r[6],0);
	return d.getTime();
}

//时间比较
function dateCompare(dateA,dateB)
{
	var regA = date2Long(dateA);
	var regB = date2Long(dateB); 
	if(regA > regB){
		return true; 
	}else{
		return false; 
	}
}
//大于等于多少天错误
function differenceDay(begin,dateB,day){
		if(!isLongDateToM(begin))	{
			alert("日期格式不正确");
			return -1;
		}
		if(!isLongDateToM(end))	{
			alert("日期格式不正确");
			return -1;
		}
		if(isLongDateToM(end) )	{
			 if((date2Long(end) - date2Long(begin))/(1000*1*60*60*24)>= day){
			 		return false;
			}else{
				return true;
			}
		}
		return false;
}


//判断输入内容是否为空    
function IsNull(formId,elId,message){
	var str=$.trim($('#'+formId).find('#'+elId).val());  
    if(str.length==0){    
        alert(message);  
        $('#'+formId).find('#'+elId).focus();
        return false;
    }else {
    	return true;
    }
}   
   
//判断日期类型是否为YYYY-MM-DD格式的类型    
function IsDate(){     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
        var r = str.match(reg);     
        if(r==null)    
            alert('对不起，您输入的日期格式不正确!'); //请将“日期”改成你需要验证的属性名称!    
        }    
}     
   
//判断日期类型是否为YYYY-MM-DD hh:mm:ss格式的类型    
function IsDateTime(){     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;     
        var r = str.match(reg);     
        if(r==null)    
        alert('对不起，您输入的日期格式不正确!'); //请将“日期”改成你需要验证的属性名称!    
    }    
}     
   
//判断日期类型是否为hh:mm:ss格式的类型    
function IsTime()     
{     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
    reg=/^((20|21|22|23|[0-1]\d)\:[0-5][0-9])(\:[0-5][0-9])?$/     
        if(!reg.test(str)){    
            alert("对不起，您输入的日期格式不正确!");//请将“日期”改成你需要验证的属性名称!    
        }    
    }    
}     
   
//判断输入的字符是否为英文字母    
function IsLetter()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[a-zA-Z]+$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的英文字母类型格式不正确!");//请将“英文字母类型”改成你需要验证的属性名称!    
        }    
        }    
}     
   
//判断输入的字符是否为整数    
function IsInteger()     
{       
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[-+]?\d*$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的整数类型格式不正确!");//请将“整数类型”要换成你要验证的那个属性名称！    
        }    
        }    
}   

//判断输入的字符是否为整数    
function IsNumber(formId,id,msg)     
{       var str=$('#'+formId).find('#'+id).val();

        if(str.length!=0){    
        reg=/^[-+]?\d*$/;   
        if(!reg.test(str)){    
            alert(msg);//请将“整数类型”要换成你要验证的那个属性名称！    
            return false;
        }else{
        	return true;
        }
        }    
}  
   
//判断输入的字符是否为双精度    
function IsDouble(val)     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[-\+]?\d+(\.\d+)?$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的双精度类型格式不正确!");//请将“双精度类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
   
//判断输入的字符是否为:a-z,A-Z,0-9    
function IsString()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[a-zA-Z0-9_]+$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的字符是否为中文    
function IsChinese()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[\u0391-\uFFE5]+$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   

//校验是否全由数字组成
function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
function isRegisterUserName(s)
{
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验用户姓名：只能输入1-30个以字母开头的字串
function isTrueName(s)
{
    var patrn=/^[a-zA-Z]{1,30}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验密码：只能输入6-20个字母、数字、下划线
function isPasswd(s)
{
    var patrn=/^(\w){6,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验普通电话、传真号码：可以“+”开头，除数字外，可含有“-”
function isTel(s)
{
    //var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/;
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验手机号码：必须以数字开头，除数字外，可含有“-”
function isMobil(s)
{
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}
//校验邮政编码
function isPostalCode(s)
{
    //var patrn=/^[a-zA-Z0-9]{3,12}$/;
    var patrn=/^[a-zA-Z0-9 ]{3,12}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验是否IP地址
function isIP(s) 
{
    var patrn=/^[0-9.]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}
//检验是否为正确的正整数或小数,6-10位
function isDigit(s)   
{   
	var patrn=/^[0-9]{1}([0-9]|[.]){1,9}$/;   
	if(!patrn.exec(s)) return false;  
	return true;  
}   
//校验登录名：只能输入4-16个以字母开头、可带数字、“.”的字串 
function isRegisterUserName(s)   
{   
	var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){3,15}$/;   
	if(!patrn.exec(s)) return false;  
	return true;  
}
//校验密码
function isPwd(s)   
{   
	var patrn=/^[a-zA-Z0-9]{4,16}$/; 
	if(!patrn.exec(s)) return false;  
	return true;  
}
//校验是否为中文,1-10个
function isChn(s){
	var patrn=/[^u4e00-u9fa5],{0,}$/;
	if(!patrn.exec(s)) return false;  
	return true;
}
//校验email格式
function isEmail(s){
	var patrn=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(!patrn.exec(s)) return false;  
	return true;
}
//去左空格;
function ltrim(s){
    return s.replace( /^\\s*/, "");
}
//去右空格;
function rtrim(s){
    return s.replace( /\\s*$/, "");
}
//去左右空格;
function trim(s){
    return rtrim(ltrim(s));
}
//是否为空值;
function IsEmpty(_str){
    var tmp_str = trim(_str);
    return tmp_str.length == 0;
}

//select选中给定值
function getSelected(obj,values){
	for(i=0;i<obj.options.length;i++)
	{
  		if(obj.options[i].value==values){
  			obj.options[i].selected=true;
  			break;
  		}
  	}
}
//将复选框的选定值写入另一个复选框
function moveSelect(obj,obj1){
	var size=obj.options.length;
	var i=0;
	while(i<size)
	{
  		if(obj.options[i].selected==true)
		{
			obj1.length++;
			obj1.options[obj1.options.length-1].value=obj.options[i].value;
			obj1.options[obj1.options.length-1].text=obj.options[i].text;
			obj.options.remove(i);
  			size=obj.options.length;
  		}
		else
		{
			i++;
		}
  	}
}
//得到页面id
function gid(id) {
return document.getElementById?document.getElementById(id):null;   
}

//得到页面name
function gname(name) {
return document.getElementsByTagName?document.getElementsByTagName(name):new Array()
}

//浏览器判断
function Browser() {
var ua, s, i;
this.isIE = false;
this.isNS = false;
this.isOP = false;
this.isSF = false;
ua = navigator.userAgent.toLowerCase();
s = "opera";
if ((i = ua.indexOf(s)) >= 0) {
  this.isOP = true;return;
}
s = "msie";
if ((i = ua.indexOf(s)) >= 0) {
  this.isIE = true;return;
}
s = "netscape6/";
if ((i = ua.indexOf(s)) >= 0) {
  this.isNS = true;return;
}
s = "gecko";
if ((i = ua.indexOf(s)) >= 0) {
  this.isNS = true;return;
}
s = "safari";
if ((i = ua.indexOf(s)) >= 0) {
  this.isSF = true;return;
}
}
//ajax得到XMLHttpRequest
function getXMLHttpRequest(){
		var req=false;
		if(window.XMLHttpRequest){
			req=new XMLHttpRequest();
			if(req.overrideMimeType)
				req.overrideMimeType("text/xml");
		}else if(window.ActiveXObject){
			try{
				req=new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					req=new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){}
			}
		}
	  return req;
}
//ajax通讯
function doRequest(url){
	var req=getXMLHttpRequest();
	req.open('get',url,false);//true 异步  false 同步
	req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	req.send(null);//发送参数如果有参数req.send("username="+user_name);用request取得
	return req.responseText;
}

String.prototype.Trim = function() 
{ 
	return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 

String.prototype.LTrim = function() 
{ 
	return this.replace(/(^\s*)/g, ""); 
} 

String.prototype.RTrim = function() 
{ 
	return this.replace(/(\s*$)/g, ""); 
} 
function array_max(){   
	var i, max = this[0]; 
	for (i = 1; i < this.length; i++){
		if (max < this[i])   max = this[i]; 
	}  
	return max;
}
Array.prototype.max = array_max;
//var x = new Array(1, 2, 3, 4, 5, 6);var y = x.max( );

/*
身份证：
/^\d{15}(\d{2}[A-Za-z0-9])?$/

货币：
/^\d+(\.\d+)?$/

QQ：
/^[1-9]\d{4,8}$/
数字：
/^\d+$/

邮政编码：
/^[1-9]\d{5}$/

QQ：
/^[1-9]\d{4,8}$/

整数：
/^[-\+]?\d+$/

实数：
/^[-\+]?\d+(\.\d+)?$/

英文：
/^[A-Za-z]+$/

中文
/^[\u0391-\uFFE5]+$/

密码（必须含有大写字母、小写字母、标点、数字中的至少两种。呵呵，这个比较变态吧～）
/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/


*/
/* 常用正则表达式 
"^\\d+$"　　//非负整数（正整数 + 0）
"^[0-9]*[1-9][0-9]*$"　　//正整数 
"^((-\\d+)|(0+))$"　　//非正整数（负整数 + 0） 
"^-[0-9]*[1-9][0-9]*$"　　//负整数 
"^-?\\d+$"　　　　//整数 
"^\\d+(\\.\\d+)?$"　　//非负浮点数（正浮点数 + 0） 
"^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"　　//正浮点数 
"^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$"　　//非正浮点数（负浮点数 + 0） 
"^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$"　　//负浮点数 
"^(-?\\d+)(\\.\\d+)?$"　　//浮点数 
"^[A-Za-z]+$"　　//由26个英文字母组成的字符串 
"^[A-Z]+$"　　//由26个英文字母的大写组成的字符串 
"^[a-z]+$"　　//由26个英文字母的小写组成的字符串 
"^[A-Za-z0-9]+$"　　//由数字和26个英文字母组成的字符串 
"^\\w+$"　　//由数字、26个英文字母或者下划线组成的字符串 
"^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"　　　　//email地址 
"^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$"　　//url
"^[A-Za-z0-9_]*$"
*/

//弹出窗在屏幕居中
var bombWin = null;
function NewWindow(mypage,myname,w,h,scroll){
	LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
	TopPosition = (screen.height) ? (screen.height-h)/2 : 0;
	settings ='height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',resizable';
	bombWin = window.open(mypage,myname,settings);
	bombWin.focus();
}
