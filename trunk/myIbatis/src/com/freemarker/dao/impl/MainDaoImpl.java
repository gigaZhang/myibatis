package com.freemarker.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.MainDao;
import com.freemarker.entity.BMain;


public class MainDaoImpl extends EntityDaoImpl<BMain> implements MainDao{

	public List<BMain> getBBSClass(String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("dcmap",mapno);
		return (List)getSqlMapClientTemplate().queryForList("BBSClassMain",keyMap);
	}

	public List<BMain> getMainList(String mapno,String page,String search) {
		Map keyMap = new HashMap();
		keyMap.put("search",search);
		keyMap.put("mapno",mapno);
		keyMap.put("page",page);
		return (List)getSqlMapClientTemplate().queryForList("MainList",keyMap);
	}

	public BMain getTotalPage(String mapno,String search) {
		Map keyMap = new HashMap();
		keyMap.put("search",search);
		keyMap.put("mapno",mapno);
		return (BMain)getSqlMapClientTemplate().queryForObject("getTotalPage",keyMap);
	}

	public void delMainInfo(String bmid,String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		getSqlMapClientTemplate().delete("delMainInfo",keyMap);
	}

	public void addDeletedFollow(String bmid, String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		getSqlMapClientTemplate().delete("delFollow",keyMap);
	}

	public void addDeletedMain(String bmid, String mapno,String userip,String userid) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		keyMap.put("userip",userip);
		keyMap.put("userid",userid);
		getSqlMapClientTemplate().insert("addDeletedMain",keyMap);
	}

	public void delFollow(String bmid, String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		getSqlMapClientTemplate().insert("addDeletedFollow",keyMap);
		
	}

	public BMain editorMainInfo(String bmid, String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("mapno",mapno);
		return (BMain)getSqlMapClientTemplate().queryForObject("editorMainInfo",keyMap);
	}

	public void updateMainInfo(String bmid, String bmtag,String mapno) {
		Map keyMap = new HashMap();
		keyMap.put("bmid",bmid);
		keyMap.put("bmtag",bmtag);
		keyMap.put("mapno",mapno);
		getSqlMapClientTemplate().update("updateMainInfo",keyMap);
	}

	public BMain getBcId(String bcname) {
		Map keyMap = new HashMap();
		keyMap.put("bcname",bcname);
		return (BMain)getSqlMapClientTemplate().queryForObject("getBcId",keyMap);
	}

	public void bbsLog(String title,String userid) {
		Map keyMap = new HashMap();
		keyMap.put("title",title);
		keyMap.put("userid",userid);
		getSqlMapClientTemplate().insert("bbslog",keyMap);
		
	}
	
	public void updateBbsMainTitle(String mapno, String bmid, String title) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("mapno", mapno);
		map.put("bmid", bmid);
		map.put("btitle", title);
		getSqlMapClientTemplate().update("updateBbsMainTitle",map);
		
	}

	
	public BMain getBcName(String bcid) {
		Map keyMap = new HashMap();
		keyMap.put("bcid",bcid);
		return (BMain)getSqlMapClientTemplate().queryForObject("getBcName",keyMap);
	}


	public BMain getTagName(String bbtid) {
		Map keyMap = new HashMap();
		keyMap.put("bbtid",bbtid);
		return (BMain)getSqlMapClientTemplate().queryForObject("getTagName",keyMap);
	}





}
