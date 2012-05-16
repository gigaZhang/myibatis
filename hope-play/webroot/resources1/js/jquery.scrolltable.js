;(function($) {
	jQuery.fn.scrolltable = function(option) {
		this.hide();
		var newheight =this.parent().height();
		var top = this.parent().position().top;
		var availH = $(document).height();//document.documentElement.offsetHeight;
		newheight = availH - top - 33 - 5 - 5;	//33 (分页高) 5 maindiv 底部补丁 5  分页的补白 
		this.show();
		var curOption = {
			height : newheight,
			multiselect : false,
			showtitle:false,
			sort:false,
			offsetHeight:0
		};
		
		jQuery.extend(curOption, option);
		var opt = curOption;
		var _jo = this;
		this.selectRow = null;
		var selectRows = new Array();
		this.initScroll = function() {
			new ScrollableTable(this.get(0), opt.height - opt.offsetHeight, opt.width);
		}
		this.clickRow = function(row,checkbox, checked)
		{
			if(!opt.multiselect)
					{
						if (!checked) {
							row.removeAttr("selected");
							row.removeClass("selected");
							_jo.selectRow = null;
						} else {
							if(_jo.selectRow != null)
							{
								_jo.selectRow.removeAttr("selected");
								_jo.selectRow.removeClass("selected");
							}
							row.attr("selected", "true");
							row.addClass("selected");
							_jo.selectRow = row;
						}
					}
					else
					{
						if (!checked) {
							row.removeAttr("selected");
							row.removeClass("selected");
							checkbox.attr('checked','');
							selectRows[row.attr("resid")] = null;
						} else {
							row.attr("selected", "true");
							row.addClass("selected");
							selectRows[row.attr("resid")] = $(this);
							checkbox.attr('checked','checked');
						}
			}
		}
		this.setIfCheckAll = function(){
			if(!opt.multiselect)
				return;
			var isAllChecked = true;
			_jo.find("tbody tr").each(function(){
				if(isAllChecked && !$(this).attr('selected'))
					isAllChecked = false; 				
			});
			if(isAllChecked)
				_jo.checkboxparent.attr("checked","checked");
			else
				_jo.checkboxparent.attr("checked","");
		
		}
		sortedRowCallback = function(obj,i){
			if(i % 2 == 0)
			{
				obj.removeClass("even").removeClass("odd").addClass("even");
			}
			else
			{
				obj.removeClass("even").removeClass("odd").addClass("odd");
			}
		}
		this.initRow = function() {
			if(opt.showtitle)
			{
				_jo.children("tbody").children("tr").children("td").each(function(){
					var txt = $(this).text();
					if(txt != '')
					{
						$(this).attr("title",txt);
					}
				});
			}
			_jo.children("tbody").children("tr:even").addClass("even");
			_jo.children("tbody").children("tr:odd").addClass("odd");
			if (opt.multiselect)
			{
				_jo.checkboxparent = jQuery("<input>",{type:'checkbox',name:'checkall',value:0});
				_jo.children("thead").children("tr").prepend(jQuery("<th width=25></th>").prepend(_jo.checkboxparent));
				_jo.checkboxparent.click(function(){
					_jo.children("tbody").children("tr").each(function(){
						var checkbox = $(this).find("td input[type=checkbox][name=checkrow]");
						_jo.clickRow($(this),checkbox,_jo.checkboxparent.attr('checked'));
					});
				});
			}
			_jo.children("tbody").children("tr").each(function(){
				$(this).mouseover(function() {
					$(this).addClass("mover");
				});
				$(this).mouseout(function() {
					$(this).removeClass("mover");
				});
				var id = $(this).attr("resid");
				var checkbox = null;
				if (opt.multiselect)
				{
					checkbox = jQuery("<input>",{type:'checkbox',name:'checkrow',value:0,id:id});
					$(this)	.prepend(jQuery("<td width=20></td>").prepend(checkbox));
				}
				$(this).click(function(){
					_jo.clickRow($(this),checkbox,!$(this).attr('selected'));
					_jo.setIfCheckAll();
				});
				
			});
			if(opt.sort)
			{
				_jo.sorttable({sortedRowCallback:sortedRowCallback});
			}
		}
		this.initRow();
		this.initScroll();
		/**
		 * 单选的情况下返回选中的id
		 * 多选的情况下返回一个数组
		 */
		
		this.getSelectedId = function(){
			if (opt.multiselect == undefined || !opt.multiselect) {
				var selo = _jo.find("tbody tr[selected=true]");
				if(selo.size() == 0)
				{
					return "";
				}
				else
				{
					return selo.attr("resid");
				}
			}
			else
			{
				var arr = new Array();
					var i =0;
				_jo.find("tbody tr[selected=true]").each(function(){
					arr[i] = $(this).attr("resid");
					i++;
				});
				return arr;
				
			}
			
		}
		this.getSelectedIdAndText = function(){		//回传选中值id和name
			if (opt.multiselect == undefined || !opt.multiselect) {
				var selo = _jo.find("tbody tr[selected=true]");
				if(selo.size() == 0)
				{
					return "";
				}
				else
				{
					var arr = new Array();
					arr[0] = selo.attr("resid");
					arr[1] = selo.attr("restext");
					return arr;
				}
			}
			else
			{
				var arr = new Array();
				var ids="",idnames="";
					var i =0;
				_jo.find("tbody tr[selected=true]").each(function(){
					ids += $(this).attr("resid") + ",";
					idnames += $(this).attr("restext") + ",";
					i++;
				});
				
				if(i != 0){
					ids = ids.substring(0,ids.length-1);
					idnames = idnames.substring(0,idnames.length-1);
					arr[0] = ids;
					arr[1] = idnames;
				}
				return arr;				
			}
			
		}
		return this;
	};
	
})(jQuery);
	
	
function ScrollableTable (tableEl, tableHeight, tableWidth) {
	this.initIEengine = function () {
 
		this.containerEl.style.overflowY = 'auto';
		if ( this.tableEl.parentElement.clientHeight - this.tableEl.offsetHeight < 0) {
			this.tableEl.style.width = this.newWidth - this.scrollWidth +'px';
		} else {
			this.containerEl.style.overflowY = 'hidden';
			if (tableWidth != undefined)
				this.tableEl.style.width = this.newWidth +'px';
		}
 
		if (this.thead) {
			var trs = this.thead.getElementsByTagName('tr');
			for (x=0; x<trs.length; x++) {
				trs[x].style.position ='relative';
				trs[x].style.setExpression("top",  "this.parentElement.parentElement.parentElement.scrollTop -2 + 'px'");
			}
		}
 
		if (this.tfoot) {
			var trs = this.tfoot.getElementsByTagName('tr');
			for (x=0; x<trs.length; x++) {
				trs[x].style.position ='relative';
				trs[x].style.setExpression("bottom",  "(this.parentElement.parentElement.offsetHeight - this.parentElement.parentElement.parentElement.clientHeight - this.parentElement.parentElement.parentElement.scrollTop) + 'px'");
			}
		}
		
	};
 
 
	this.initFFengine = function () {
		this.containerEl.style.overflow = 'hidden';
		this.tableEl.style.width = this.newWidth + 'px';
 
		var headHeight = (this.thead) ? this.thead.clientHeight : 0;
		var footHeight = (this.tfoot) ? this.tfoot.clientHeight : 0;
		var bodyHeight = this.tbody.clientHeight;
		var trs = this.tbody.getElementsByTagName('tr');
		if (bodyHeight >= (this.newHeight - (headHeight + footHeight))) {
			this.tbody.style.overflow = '-moz-scrollbars-vertical';
			for (x=0; x<trs.length; x++) {
				var tds = trs[x].getElementsByTagName('td');
				tds[tds.length-1].style.paddingRight += this.scrollWidth + 'px';
			}
		} else {
			this.tbody.style.overflow = '-moz-scrollbars-none';
		}
 
		var cellSpacing = (this.tableEl.offsetHeight - (this.tbody.clientHeight + headHeight + footHeight)) / 4;
		this.tbody.style.height = (this.newHeight - (headHeight + cellSpacing * 2) - (footHeight + cellSpacing * 2)) + 'px';
 
	};
 	
	this.tableEl = tableEl;
	this.scrollWidth = 16;
	this.originalHeight = this.tableEl.clientHeight;
	this.originalWidth = this.tableEl.clientWidth;
	this.newHeight = parseInt(tableHeight);
	if (jQuery.browser.msie)
		this.newWidth = tableWidth? parseInt(tableWidth) : this.tableEl.parentElement.clientWidth -2;
	if (jQuery.browser.mozilla)
		this.newWidth = tableWidth == undefined? parseInt(tableWidth) : this.tableEl.parentElement.clientWidth -2;
		
	this.tableEl.style.height = 'auto';
	this.tableEl.removeAttribute('height');
	this.containerEl = this.tableEl.parentNode.insertBefore(document.createElement('div'), this.tableEl);
	this.containerEl.appendChild(this.tableEl);
	this.containerEl.style.height = this.newHeight + 'px';
	
	if(tableWidth != undefined)
		this.containerEl.style.width = this.newWidth + 'px';
 
	var thead = this.tableEl.getElementsByTagName('thead');
	this.thead = (thead[0]) ? thead[0] : null;
 
	var tfoot = this.tableEl.getElementsByTagName('tfoot');
	this.tfoot = (tfoot[0]) ? tfoot[0] : null;
 
	var tbody = this.tableEl.getElementsByTagName('tbody');
	this.tbody = (tbody[0]) ? tbody[0] : null;
 
	if (!this.tbody) return;
	if (jQuery.browser.msie) this.initIEengine();
	else if (jQuery.browser.mozilla) this.initFFengine();
	else this.initIEengine();
}