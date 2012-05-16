/*定义包*/

if(!PB.MainUI)
{
	PB.MainUI = new Object();
}

PB.MainUI.showHeaderMenu=function(){
	$("#headdiv").load(PB.ContextPath + "/sys/menu/menu!top.do");
}

PB.MainUI.showPageInMain=function(url){
	$("#maindiv").load(PB.ContextPath +url);
}

PB.MainUI.showPageInRight=function(url,data){
//	$("#rightdiv").load(PB.ContextPath +url,data);
	var menuUrl = PB.ContextPath + url;
	if(data != undefined){
		var content = "";
		if(url.indexOf("?") != -1){
			content = "&";
		}else{
			content = "?";
		}
		for(var k in data){
			content += k + "=" + data[k] + "&";
		}
		if(url.indexOf("?") != -1){
			menuUrl += content.substr(0,userIds.length - 1);
		}else{
			menuUrl += content.substr(0,userIds.length - 1);
		}
	}
	window.location.href = menuUrl;
}


PB.MainUI.showHtmlInRight=function(html){
	$("#rightdiv").html(html);
}


function topMenuClick(menuUrl){
	window.parent.mainFrame.location.href = PB.ContextPath + menuUrl;
}

function leftMenuClick(menuUrl){
	window.parent.systemContent.location.href = PB.ContextPath + menuUrl;
}

/*
$(document).ready(function(){
		PB.MainUI.showHeaderMenu();
});
*/



