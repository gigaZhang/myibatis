var total = 0;		//当前查询总条目数
var progress = 0;	//当前进行条目数
var hasdatatotal = 0;//有数据的条目数
var errortotal = 0;	//当前查询错误条目数
var notshow = true; //有无结果显示
var tree = null; 	//树

//消息
var msg = {
		clear: '', 
		way: '查询中 ...',
		isnull: '查询列表为空 ...', 
		progress: '生成查询列表 ...'
	};

var img = {
		leaf: 'leaf.gif',
		warn: 'warning.gif'
	};

function loadingTree(){
	$('#searchStatus').html(msg.progress);
	tree=new dhtmlXTreeObject('leftTree', '100%', '100%', 0);
	tree.enableSmartXMLParsing(true);
	tree.enableCheckBoxes(0);
	tree.enableThreeStateCheckboxes(false); 
	tree.enableSmartXMLParsing(false);
	tree.enableSmartCheckboxes(false);
	tree.attachEvent('onSelect', showresult); 
	tree.setImagePath(basepath + '/resources/js/dhtml/imgs/csh_scbrblue/');
	tree.loadXML(basepath + '/keysearch/keysearch!leftTree.do', asynchSearch);
}

function showresult(itemId){
	if(!tree.hasChildren(itemId)){
		var options = submitOptions({itemId:itemId}, false);
		if(options != null){
			var form = document.getElementById('searchForm');
			form.action = options.url + convert(options);
			$('#display').val(tree.getUserData(itemId, 'display'));
			form.submit();
		}
	}
}

function deleteNotData(itemId){
	if(itemId != ''){
		var parentItem = tree.getParentId(itemId);
		tree.deleteItem(itemId, parentItem);
		if(!tree.hasChildren(parentItem)){
			deleteNotData(parentItem);
		}
	}
}

function optionStatus(){
	progress ++;
	$('#searchStatus').html('剩余' + (total - progress) + '项');
	if(total <= progress){
		var message = '共查询' + progress + '项,显示' + hasdatatotal + '项';
		if(errortotal > 0)
			message += ',失败' + errortotal + '项';
		$('#loadlist').html(message);
		if(notshow){
			var searchmian = $(parent.keysearchMain.document);
			searchmian.find('#notresult').show();
			searchmian.find('#loading').remove();
		}
		if(!haskeyword){
			$('#searchmore').show();
		}
	}
}

function asynchSearch(){
	tree.openAllItems(0);
	var items = tree.getAllChildless().split(',');
	total = items.length;
	if((items == null) || (total < 1)){
		$('#searchStatus').html(msg.isnull);
		return;
	}else{
		$('#searchStatus').html('共' + total + '项');
	}
	
	var options = {
			async:true,
			dataType: 'json',
			success: function(datas){
				if(datas.status){
					if(datas.total > 0){
						tree.setItemImage(this.itemId, img.leaf);
						tree.setItemText(this.itemId, tree.getItemText(this.itemId) + '(' + datas.total + ')');
						tree.openItem(this.itemId);
						if(notshow){
							showresult(this.itemId);
							tree.selectItem(this.itemId , false);
							notshow = false;
						}
						hasdatatotal ++;
					}else{
						//删除没有数据的节点包括父节点
						deleteNotData(this.itemId);
					}
				}else{
					errortotal ++;
					tree.setItemImage(this.itemId, img.warn);
					tree.openItem(this.itemId);
				}
				optionStatus();
			}, 
			error: function(){
				errortotal ++;
				optionStatus();
				tree.setItemImage(this.itemId, img.warn);
			}
	};
	for(var i = 0; i < total; i ++){
		options.itemId = items[i];
		$('#searchForm').ajaxSubmit(submitOptions(options, true));
	}
	options = null;
}

function submitOptions(options, read){
	var type = tree.getUserData(options.itemId, 'type');
	
	if((type < 1) || (type > 3))
		return null;
	
	var data = {'info.queryType':type, 'read': read};
	var actions = null;
	
	data['info.dsType'] = tree.getUserData(options.itemId, 'dstype');
	data['info.dsCode'] = tree.getUserData(options.itemId, 'dscode');
	data['info.dataType'] = tree.getUserData(options.itemId, 'datatype');
	options.data = data;
	
	if(read)
		actions = basepath + tree.getUserData(options.itemId, 'actions');
	else
		actions = basepath + tree.getUserData(options.itemId, 'clickActions');
	
	if(actions == null)
		return null;
	
	options.url = actions;
	
	return options;
}

function convert(options){
	//options.data['time'] = new Date().getTime();
	return '?' + jQuery.param(options.data);
}
