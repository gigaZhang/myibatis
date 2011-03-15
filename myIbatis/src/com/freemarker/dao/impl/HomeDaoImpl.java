package com.freemarker.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.HomeDao;
import com.freemarker.entity.BHome;

public class HomeDaoImpl extends EntityDaoImpl<BHome> implements HomeDao{

	public List<BHome> allItem(String module,String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("module",module);
		keyMap.put("mapno",mapno);
		return (List)getSqlMapClientTemplate().queryForList("allItem",keyMap);
	}

	public List<BHome> getModule() {
		return (List)getSqlMapClientTemplate().queryForList("getModule");
	}

	public BHome initialValue(String item) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		return (BHome)getSqlMapClientTemplate().queryForObject("initialValue",keyMap);
	}


	public List<BHome> picInfo(String item, String mapno,String piccounts) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		keyMap.put("mapno",mapno);
		keyMap.put("piccounts",piccounts);
		return (List)getSqlMapClientTemplate().queryForList("picInfo",keyMap);
	}

	public List<BHome> txtInfo(String item, String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		keyMap.put("mapno",mapno);
		return (List)getSqlMapClientTemplate().queryForList("txtInfo",keyMap);
	}

	public void setHot(BHome home) {
		getSqlMapClientTemplate().update("setHot",home);
		
	}

	public void setLog(BHome home) {
		getSqlMapClientTemplate().update("setLog",home);
		
	}

	public void setPic(BHome home) {
		getSqlMapClientTemplate().update("setPic",home);
		
	}

	public void settxt(BHome home) {
		getSqlMapClientTemplate().update("setTxt",home);
		
	}

	public List<BHome> picList(String mapno, String item) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		keyMap.put("mapno",mapno);
		return (List)getSqlMapClientTemplate().queryForList("picList",keyMap);
	}

	public BHome recommandPath(String item) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		return (BHome)getSqlMapClientTemplate().queryForObject("recommandPath",keyMap);
	}

	public List<BHome> txtList(String mapno, String item) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		keyMap.put("mapno",mapno);
		return (List)getSqlMapClientTemplate().queryForList("txtList",keyMap);
	}

	public BHome bbsComment(String mapno, String bmid) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		return (BHome)getSqlMapClientTemplate().queryForObject("bbsComment",keyMap);
	}

	public BHome busComment(String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("mapno",mapno);
		return (BHome)getSqlMapClientTemplate().queryForObject("busComment",keyMap);
	}

	public BHome userhead(String userid) {
		Map keyMap = new HashMap();
		keyMap.put("userid",userid);
		return (BHome)getSqlMapClientTemplate().queryForObject("userhead",keyMap);
	}

	public List<BHome> getStationModule() {
		return (List)getSqlMapClientTemplate().queryForList("getStationModule");
	}

	public BHome getMhcId(String mhcname) {
		Map keyMap = new HashMap();
		keyMap.put("mhcname",mhcname);
		return (BHome)getSqlMapClientTemplate().queryForObject("getMhcId",keyMap);
	}

	public BHome getHomeInfo(String mhcname) {
		Map keyMap = new HashMap();
		keyMap.put("mhcname",mhcname);
		return (BHome)getSqlMapClientTemplate().queryForObject("getHomeInfo",keyMap);
	}

	public List<BHome> getElement(String mapno, String item, String logid) {
		Map keyMap = new HashMap();
		keyMap.put("mapno",mapno);
		keyMap.put("item",item);
		keyMap.put("logid",logid);
		return (List)getSqlMapClientTemplate().queryForList("getElement",keyMap);
	}

	public void setDirectory(BHome b) {
		getSqlMapClientTemplate().insert("setDirectory",b);
	}

	public BHome getDirectory(String mheid) {
		Map keyMap = new HashMap();
		keyMap.put("mheid",mheid);
		return (BHome)getSqlMapClientTemplate().queryForObject("getDirectory",keyMap);
	}

	public void setDirectoryStatus(String tlogid) {
		Map keyMap = new HashMap();
		keyMap.put("tlogid",tlogid);
		getSqlMapClientTemplate().update("setDirectoryStatus",keyMap);
		
	}

	public void initElementByFName(BHome home) {
		getSqlMapClientTemplate().insert("initElementByFName",home);
		
	}

	public void upElementByFName(BHome home) {
		getSqlMapClientTemplate().update("upElementByFName",home);
		
	}

	public BHome getMhcName(String mhcid) {
		Map keyMap = new HashMap();
		keyMap.put("mhcid",mhcid);
		return (BHome)getSqlMapClientTemplate().queryForObject("getMhcName",keyMap);
	}

	public List<BHome> getCompanyList(String page) {
		Map keyMap = new HashMap();
		keyMap.put("page",page);
		return (List)getSqlMapClientTemplate().queryForList("getCompanyList",keyMap);
	}

	public BHome companyTotal(){
		return (BHome)getSqlMapClientTemplate().queryForObject("companyTotal");
	}

	public void addCompany(BHome home) {
		getSqlMapClientTemplate().insert("addCompany",home);
		
	}

	public void delCompany(String mhcid) {
		Map keyMap = new HashMap();
		keyMap.put("mhcid",mhcid);
		getSqlMapClientTemplate().delete("delCompany",keyMap);
	}
}
