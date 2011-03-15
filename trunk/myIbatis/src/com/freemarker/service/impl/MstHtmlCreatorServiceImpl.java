package com.freemarker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.service.impl.SpringBaseServiceImpl;
import com.freemarker.dao.MstHtmlCreatorDao;
import com.freemarker.entity.MstHtmlCreator;
import com.freemarker.service.MstHtmlCreatorService;

public class MstHtmlCreatorServiceImpl extends SpringBaseServiceImpl<MstHtmlCreator,MstHtmlCreatorDao> implements MstHtmlCreatorService{


	public List<MstHtmlCreator> moduleList() {
		List moduleList = (List)getBaseDao().listModule();
		return moduleList;
	}


	public List<MstHtmlCreator> nameList(String module) {
		Map nameMap = new HashMap();
		nameMap.put("rows","mhc_id,mhc_name,pic_counts,txt_counts");
		nameMap.put("search","(mhc_module = '"+module+"')  order by mhc_order ASC");
		List nameList = (List)getBaseDao().list(nameMap);
		return nameList;
	}


	public MstHtmlCreator mhcValue(String mhcid) {
		Map valueMap = new HashMap();
		valueMap.put("rows","*");
		valueMap.put("search","(mhc_id = '"+mhcid+"') order by mhc_order ASC");
		MstHtmlCreator mhcValue = (MstHtmlCreator)getBaseDao().getModel(valueMap);
		return mhcValue;
	}

	
	
}
