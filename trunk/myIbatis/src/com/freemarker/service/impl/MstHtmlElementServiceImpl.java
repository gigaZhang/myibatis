package com.freemarker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.service.impl.SpringBaseServiceImpl;
import com.freemarker.dao.MstHtmlElementDao;
import com.freemarker.entity.MstHtmlElement;
import com.freemarker.service.MstHtmlElementService;

public class MstHtmlElementServiceImpl extends SpringBaseServiceImpl<MstHtmlElement,MstHtmlElementDao> implements MstHtmlElementService{

	public List<MstHtmlElement> listModel(String mhcid,String mapno){
		Map mheMap = new HashMap();
		mheMap.put("rows","*");
		mheMap.put("search","(mhc_id = '"+mhcid+"') and mhe_mapno = '"+mapno+"'");
		List mheList = (List)getBaseDao().list(mheMap);
		if (mheList != null){
			for (int i=0;i<mheList.size();i++){
				MstHtmlElement mhe = (MstHtmlElement)mheList.get(i);
				mhe.setMhe_name(mhe.getMhe_name().replaceAll("p","Í¼Æ¬").replaceAll("t","ÎÄ±¾"));
			}
		}
		return mheList;
	}
	
	public void deleteGroup(String mhcid,String mapno){
		Map mheMap = new HashMap();
		mheMap.put("search","mhc_id = "+mhcid+" and mhe_mapno = "+mapno);
		getBaseDao().deleteGroup(mheMap);
	}

	public void initial(String mhcid,String mapno,String p, String t) {
		Map pMap = new HashMap();
		pMap.put("rows","*");
		pMap.put("search","(mhc_id = '"+mhcid+"') and mhe_mapno = '"+mapno+"' and mhe_name like 'p%'");
		List pList = (List)getBaseDao().list(pMap);
		Map tMap = new HashMap();
		tMap.put("rows","*");
		tMap.put("search","(mhc_id = '"+mhcid+"') and mhe_mapno = '"+mapno+"' and mhe_name like 't%'");
		List tList = (List)getBaseDao().list(tMap);
		Map delMap = new HashMap();
		delMap.put("search","mhc_id = "+mhcid+" and mhe_mapno = "+mapno);
		getBaseDao().deleteGroup(delMap);
		
		for (int i=0;i<Integer.parseInt(p);i++){
			MstHtmlElement mhe = new MstHtmlElement();
			mhe.setMhc_id(mhcid);
			mhe.setMhe_mapno(mapno);
			mhe.setMhe_name("p"+(i+1));
			getBaseDao().insert(mhe);
		}
		for (int i=0;i<Integer.parseInt(t);i++){
			MstHtmlElement mhe = new MstHtmlElement();
			mhe.setMhc_id(mhcid);
			mhe.setMhe_mapno(mapno);
			mhe.setMhe_name("t"+(i+1));
			getBaseDao().insert(mhe);
			
		}
		
		if (pList != null){
			for (int i=0;i<pList.size();i++){
				MstHtmlElement mhe = (MstHtmlElement)pList.get(i);
				mhe.setMhc_id(mhcid);
				mhe.setMhe_mapno(mapno);
				mhe.setMhe_name("p"+(i+1));
				mhe.setMhe_id(""); 
				getBaseDao().update(mhe);
			}
		}
		if (tList != null){
			for (int i=0;i<tList.size();i++){
				MstHtmlElement mhe = (MstHtmlElement)tList.get(i);
				mhe.setMhc_id(mhcid);
				mhe.setMhe_mapno(mapno);
				mhe.setMhe_name("t"+(i+1));
				mhe.setMhe_id(""); 
				getBaseDao().update(mhe);
			}
		}
	}


	public void updateTips(String tips, String mheids) {
		String[] tip = tips.split(",");
		String[]mheid = mheids.split(",");
		for (int i=0;i<tip.length;i++){
			if (!tip[i].trim().equals("")){
				MstHtmlElement mhe = new MstHtmlElement();
				mhe.setMhe_id(mheid[i].trim());
				mhe.setMhe_tips(tip[i].trim());
				getBaseDao().update(mhe);
			}
		}
	}
	
}
