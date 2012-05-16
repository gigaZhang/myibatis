;(function($) {
	jQuery.fn.sorttable = function(option) {
		var _opt = {};
		jQuery.extend(_opt, option);
		var contants = { DATE_RE: /^(\d\d?)[\/\.-](\d\d?)[\/\.-]((\d\d)?\d\d)$/};
		var $st = this;
		this.$tbody = $st.children("tbody");
		
		//排序方法
		var sortFunc = {
				/* sort functions
			     each sort function takes two parameters, a and b
			     you are comparing a[0] and b[0] */
			  sort_numeric: function(a,b) {  
			    aa = parseFloat(a[0].replace(/[^0-9.-]/g,''));
			    if (isNaN(aa)) aa = 0;
			    bb = parseFloat(b[0].replace(/[^0-9.-]/g,'')); 
			    if (isNaN(bb)) bb = 0;
			    return aa-bb;
			  },
			  sort_alpha: function(a,b) {
			    if (a[0]==b[0]) return 0;
			    if (a[0]<b[0]) return -1;
			    return 1;
			  },
			  sort_gb:function(a,b){
				 return a[0].localeCompare(b[0]); 
			  },
			  sort_ddmm: function(a,b) {
			    mtch = a[0].match(sorttable.DATE_RE);
			    y = mtch[3]; m = mtch[2]; d = mtch[1];
			    if (m.length == 1) m = '0'+m;
			    if (d.length == 1) d = '0'+d;
			    dt1 = y+m+d;
			    mtch = b[0].match(sorttable.DATE_RE);
			    y = mtch[3]; m = mtch[2]; d = mtch[1];
			    if (m.length == 1) m = '0'+m;
			    if (d.length == 1) d = '0'+d;
			    dt2 = y+m+d;
			    if (dt1==dt2) return 0;
			    if (dt1<dt2) return -1;
			    return 1;
			  },
			  sort_mmdd: function(a,b) {
			    mtch = a[0].match(sorttable.DATE_RE);
			    y = mtch[3]; d = mtch[2]; m = mtch[1];
			    if (m.length == 1) m = '0'+m;
			    if (d.length == 1) d = '0'+d;
			    dt1 = y+m+d;
			    mtch = b[0].match(sorttable.DATE_RE);
			    y = mtch[3]; d = mtch[2]; m = mtch[1];
			    if (m.length == 1) m = '0'+m;
			    if (d.length == 1) d = '0'+d;
			    dt2 = y+m+d;
			    if (dt1==dt2) return 0;
			    if (dt1<dt2) return -1;
			    return 1;
			  }
		}
		this.getInnerText= function(node) {
		    // gets the text we want to use for sorting for a cell.
		    // strips leading and trailing whitespace.
		    // this is *not* a generic getInnerText function; it's special to sorttable.
		    // for example, you can override the cell text with a customkey attribute.
		    // it also gets .value for <input> fields.
		    hasInputs = (typeof node.getElementsByTagName == 'function') &&
		                 node.getElementsByTagName('input').length;
		    
		    if (node.getAttribute("sorttable_customkey") != null) {
		      return node.getAttribute("sorttable_customkey");
		    }
		    else if (typeof node.textContent != 'undefined' && !hasInputs) {
			  if(node.textContent=="--"){return "-999999";}
		      return node.textContent.replace(/^\s+|\s+$/g, '');
		    }
		    else if (typeof node.innerText != 'undefined' && !hasInputs) {
		      if(node.innerText=="--"){return "-999999";}
		      return node.innerText.replace(/^\s+|\s+$/g, '');
		    }
		    else if (typeof node.text != 'undefined' && !hasInputs) {
		      if(node.text=="--"){return "-999999";}		
		      return node.text.replace(/^\s+|\s+$/g, '');
		    }
		    else {
		      switch (node.nodeType) {
		        case 3:
		          if (node.nodeName.toLowerCase() == 'input') {
		            return node.value.replace(/^\s+|\s+$/g, '');
		          }
		        case 4:
		          return node.nodeValue.replace(/^\s+|\s+$/g, '');
		          break;
		        case 1:
		        case 11:
		          var innerText = '';
		          for (var i = 0; i < node.childNodes.length; i++) {
		            innerText += $st.getInnerText(node.childNodes[i]);
		          }
		          return innerText.replace(/^\s+|\s+$/g, '');
		          break;
		        default:
		          return '';
		      }
		    }
		  }
		this.guessType = function( column) {
			// guess the type of a column based on its first non-blank row
			var sortfn = sortFunc.sort_alpha;
			var $tbodytr = $st.children("tbody").children("tr");
			for(var i = 0; i < $tbodytr.size(); i++)
			{
				var text = $st.getInnerText($($tbodytr.get(i)).children("td:nth-child(" + column + ")").get(0));
				text = $.trim(text);
				if (text != '') {
					if (/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(text)) {
						return sortFunc.sort_numeric;
					}
					// check for a date: dd/mm/yyyy or dd/mm/yy 
					// can have / or . or - as separator
					// can be mm/dd as well
					var possdate = text.match(contants.DATE_RE)
					if (possdate) {
						// looks like a date
						first = parseInt(possdate[1]);
						second = parseInt(possdate[2]);
						if (first > 12) {
							// definitely dd/mm
							return sortFunc.sort_ddmm;
						} else if (second > 12) {
							return sortFunc.sort_mmdd;
						} else {
							// looks like a date, but we can't tell which, so assume
							// that it's dd/mm (English imperialism!) and keep looking
							sortfn = sortFunc.sort_ddmm;
						}
					}
					//如果包含中文
					else if(/[^\x00-\xff]/g.test(text)){
						sortfn = sortFunc.sort_gb;
					} 		
				}
			}
			return sortfn;
		}
		
		reverse=function(tbody) {
		    // reverse the rows in a tbody
		    newrows = [];
		    for (var i=0; i<tbody.rows.length; i++) {
		      newrows[newrows.length] = tbody.rows[i];
		    }
		    for (var i=newrows.length-1; i>=0; i--) {
		       tbody.appendChild(newrows[i]);
		    }
		    delete newrows;
		  }    
		this.makeSortable = function(){
			//对只有一个thead的进行排序
			var tableHeader = $st.children("thead");
			if(tableHeader.size() != 1)
			{
				return;
			}
			var i =0;
			tableHeader.children("tr").children("th").each(function(){
				var headCell = $(this);
				//有这个的属性，不排序
				i++;
				if(!headCell.hasClass("sorttable_nosort"))
				{
					//定义排序的方法
					headCell.data("sorttable_sortfunction",$st.guessType(i))
					// make it clickable to sort
					headCell.data("sorttable_columnindex",i)
					headCell.click(function(){
						if(headCell.hasClass("sorttable_sorted"))
						{
							reverse($st.$tbody.get(0));
							headCell.removeClass("sorttable_sorted");
							headCell.addClass("sorttable_sorted_reverse");
							return;
						}
						if(headCell.hasClass("sorttable_sorted_reverse"))
						{
							reverse($st.$tbody.get(0));
							headCell.removeClass("sorttable_sorted_reverse");
							headCell.addClass("sorttable_sorted");
							return;
						}
						headCell.removeClass("sorttable_sorted_reverse");
						headCell.addClass("sorttable_sorted");
						var row_array = [];
						col = headCell.data("sorttable_columnindex");
						rows = $st.$tbody.get(0).rows;
						for (var j=0; j<rows.length; j++) {
							row_array[j] = [$(rows[j]).children("td:nth-child(" + col + ")").text(), rows[j]];
						}
						/* If you want a stable sort, uncomment the following line */
						//sorttable.shaker_sort(row_array, this.sorttable_sortfunction);
						/* and comment out this one */
						row_array.sort(headCell.data("sorttable_sortfunction"));
						//$tbody.empty();
						tb = $st.$tbody.get(0);
						for (var j=0; j<row_array.length; j++) {
							tb.appendChild(row_array[j][1]);
							if(typeof _opt.sortedRowCallback == 'function')
							{
								_opt.sortedRowCallback($(row_array[j][1]),j);
							}
						}			  

						//指定各行css样式
						//sorttable.changeRowCss(table);
						var idx = 0;
						tableHeader.children("tr").children("th").each(function(){
							idx++;
							if(idx != col)
							{
								$(this).removeClass("sorttable_sorted_reverse");
								$(this).removeClass("sorttable_sorted");
							}
						});
						
						delete row_array;
						
						
						
					});
				}
				
			});
		}
		this.makeSortable();
	};
	
})(jQuery);