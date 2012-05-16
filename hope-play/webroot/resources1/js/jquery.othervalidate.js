

/**    
   * @author taloscheng    
   */     
   
$(document).ready(function(){          
   jQuery.validator.setDefaults({
		
	}); 
// 字符验证          
jQuery.validator.addMethod("stringCheck", function(value, element) {          
    return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);          
}, "只能包括中文字、英文字母、数字和下划线");

jQuery.validator.addMethod("letterCheck", function(value, element) {          
    return this.optional(element) || /^[\w]+$/.test(value);          
}, "只能包括英文字母、数字和下划线");      
        
// 中文字两个字节          
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {          
    var length = value.length;          
    for(var i = 0; i < value.length; i++){          
        if(value.charCodeAt(i) > 127){          
        length++;          
        }          
    }          
    return this.optional(element) || ( length >= param[0] && length <= param[1] );          
}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");      
     
// 身份证号码验证          
jQuery.validator.addMethod("isIdCardNo", function(value, element) {          
    return this.optional(element) || CheckIdNo(value);          
}, "请正确输入您的身份证号码");       
      
// 手机号码验证          
jQuery.validator.addMethod("isMobile", function(value, element) {          
    var length = value.length;      
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;      
    return this.optional(element) || (length == 11 && mobile.test(value));          
 }, "请正确填写您的手机号码"); 
          
// IP验证          
jQuery.validator.addMethod("isIP", function(value, element) {          
	var check=function(v){try{return (v<=255 && v>=0)}catch(x){return false}};
	var re=value.split(".")
	return (re.length==4)?(check(re[0]) && check(re[1]) && check(re[2]) && check(re[3])):this.optional(element)
 }, "请正确填写您的IP地址");          
function isNumber(n)
 {
 	return /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(n);
 }
 jQuery.validator.addMethod("isNum", function(value, element) {          
   var num = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;  
   return this.optional(element) || (num.test(value));          
}, "请输入数字");    
// 电话号码验证          
jQuery.validator.addMethod("isTel", function(value, element) {          
   var tel = /^\d{3,4}-?\d{7,9}$/;    //电话号码格式010-12345678      
   return this.optional(element) || (tel.test(value));          
}, "请正确填写您的电话号码");      
     
// 联系电话(手机/电话皆可)验证      
jQuery.validator.addMethod("isPhone", function(value,element) {      
    var length = value.length;      
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;      
    var tel = /^\d{3,4}-?\d{7,9}$/;      
    return this.optional(element) || (tel.test(value) || mobile.test(value));      
     
}, "请正确填写您的联系电话");      
        
// 邮政编码验证          
jQuery.validator.addMethod("isZipCode", function(value, element) {          
    var tel = /^[0-9]{6}$/;          
   return this.optional(element) || (tel.test(value));          
}, "请正确填写您的邮政编码");

//单个类型与混合类型的身份类型验证
jQuery.validator.addMethod("checkIdCode", function(value, element, param) {   
	if($(param).length > 0)
	{
		var target = $(param).unbind(".validate-equalTo").bind("blur.validate-equalTo", function() {
			$(element).valid();
		});
		if(target.val() == 0)//
			return $.trim(value).length > 0;
		return true;
	}
	return false;
	  
}, "身份证不能为空");
//单个类型与混合类型的身份类型验证
jQuery.validator.addMethod("checkLibs", function(value, element, param) {   
	if($(param).length > 0)
	{
		var target = $(param).unbind(".validate-equalTo").bind("blur.validate-equalTo", function() {
			$(element).valid();
		});
		if(target.val() == 1)//
			return $.trim(value).length > 0;
		return true;
	}
	return false;
	  
}, "请选择一个库");


//库人员信息的单个类型与混合类型的身份类型验证
jQuery.validator.addMethod("checkLibType", function(value, element, param) {   
	if($(param).length > 0)
	{
		var target = $(param).unbind(".validate-equalTo").bind("blur.validate-equalTo", function() {
			$(element).valid();
		});
		if(target.val() == -99)//
			return $.trim(value).length > 0;
		return true;
	}
	return false;
	  
}, "请选择身份类型");
//域名验证
/*jQuery.validator.addMethod("isDomain", function(value, element) {          
     var reg = /(http[s]?|ftp):\/\/[^\/\.]+?\..+\w$/i; 
   return this.optional(element) || (reg.test(value));          
}, "请正确填写您的域名地址");
*/
});