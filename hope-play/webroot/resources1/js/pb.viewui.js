$(document).ready(function(){
	/*功能菜单的样式*/
	$(".btn_div").live("mouseover",function(){
		$(this).addClass("btn_div_hover");
	});
	$(".btn_div").live("mouseout",function(){
		$(this).removeClass("btn_div_hover");
	});
	
	/*左树的菜单样式*/
	$("dd").live("mouseover",function(){
		$(this).addClass("dd_hover");
	});
	$("dd").live("mouseout",function(){
		$(this).removeClass("dd_hover");
	});

	$(".search_btn").live("mouseover",function(){
		$(this).addClass("search_btn_hover");
	});
	$(".search_btn").live("mouseout",function(){
		$(this).removeClass("search_btn_hover");
	});
});