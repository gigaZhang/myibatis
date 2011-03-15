package com.freemarker.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.DirectoryDao;
import com.freemarker.entity.BDirectory;

public class DirectoryDaoImpl extends EntityDaoImpl<BDirectory> implements DirectoryDao{

	public List<BDirectory> getDirectoryeList(String search, String order,String page) {
		Map keyMap = new HashMap();
		keyMap.put("search",search);
		keyMap.put("order",order);
		keyMap.put("page",page);
		return (List)getSqlMapClientTemplate().queryForList("getDirectoryeList",keyMap);
	}

	public BDirectory getDirectoryeTotal(String search) {
		Map keyMap = new HashMap();
		keyMap.put("search",search);
		return (BDirectory)getSqlMapClientTemplate().queryForObject("getDirectoryeTotal",keyMap);
	}

	public List<BDirectory> getDirectoryeListAll(String search, String order) {
		Map keyMap = new HashMap();
		keyMap.put("search",search);
		keyMap.put("order",order);
		return (List)getSqlMapClientTemplate().queryForList("getDirectoryeListAll",keyMap);
	}

	public BDirectory getChannelTotal(String channel, String item,
			String time) {
		Map keyMap = new HashMap();
		keyMap.put("channel",channel);
		keyMap.put("item",item);
		keyMap.put("time",time);
		return (BDirectory)getSqlMapClientTemplate().queryForObject("getChannelTotal",keyMap);
	}

	public List<BDirectory> ProfAll(String item, String time) {
		Map keyMap = new HashMap();
		keyMap.put("item",item);
		keyMap.put("time",time);
		return (List)getSqlMapClientTemplate().queryForList("ProfAll",keyMap);
	}

	public BDirectory getProfTotal(String prof) {
		Map keyMap = new HashMap();
		keyMap.put("prof",prof);
		return (BDirectory)getSqlMapClientTemplate().queryForObject("getProfTotal",keyMap);
	}

	public void directoryDel(String logid) {
		Map keyMap = new HashMap();
		keyMap.put("logid",logid);
		getSqlMapClientTemplate().delete("directoryDel",keyMap);
		
	}

}
