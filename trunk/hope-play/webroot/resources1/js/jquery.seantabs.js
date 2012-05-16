;(function($) {
	jQuery.fn.seantabs = function(option) {
	var _st = this;
	_st.addClass("seantabs");
	_st.children("ul:first").addClass("tabMenu");
	//$('<div class="tabTop"></div>').insertBefore(_st.children("div.tabBody"));
	//_st.append($('<div class="tabBottom"></div>'));
	_st.children('.tabBody').children('div').hide();
	
	_st.children("ul:first").children("li").each(function(){
		var obj = $(this);
		obj.click(function(){
			_st.selectTab($(this));
		  }).mouseover(function() {
			    $(this).addClass('mouseover');
			    $(this).removeClass('mouseout');   
			  }).mouseout(function() {
			    $(this).addClass('mouseout');
			    $(this).removeClass('mouseover');    
			  });
		if(obj.attr("initfuc") != null && obj.attr("initfuc") != '' )
		{
			obj.one("click",function(){
				eval(obj.attr("initfuc"));
			});
		}
	});
	this.selectTab = function(selTab){
		var divId = selTab.attr("contentid");
		
		if(selTab.hasClass("selected"))
			return;
		
		var selli = _st.children("ul:first").children("li.selected");
		if(selli.size() > 0)
		{
			selli.removeClass('selected');
			var lastSelDiv = _st.children('.tabBody').children('#' + selli.attr("contentid"));
			lastSelDiv.slideUp('fast');
			lastSelDiv.hide();
		}
		
		selTab.addClass('selected');
		var curSelDiv =  _st.children('.tabBody').children('#' + divId);
		curSelDiv.show();
	};
	
	if(_st.children("ul:first").children("li.selected").size() == 0)
	{
		_st.children("ul:first").children("li:first").trigger("click");
	}
	else
	{
		var seltab = _st.children("ul:first").children("li.selected");
		seltab.removeClass("selected");
		seltab.addClass("posts");
		seltab.trigger("click");
		
	}
	
	return {
		//返回当前选中的tab的id
		getSelectedTabId:function(){
		
		return _st.children("ul:first").children("li.selected").attr("tabid");
		
	},
	selectTabById:function(tabId)
	{
		_st.selectTab(_st.children("ul:first").children("li[tabid='" + tabId + "']"))
	},
	//刷新tab的功能
	refresh:function(){
		_st.children("ul:first").children("li").each(function(){
			var obj = $(this);
			if(obj.attr("initfuc") != null && obj.attr("initfuc") != '' )
			{
				obj.one("click",function(){
					eval(obj.attr("initfuc"));
				});
			}
		});
		_st.children("ul:first").children("li.selected").trigger("click");
	}};
};})(jQuery);
