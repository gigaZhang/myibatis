package com.freemarker.dao;

import java.util.List;

import com.framework.dao.EntityDao;
import com.freemarker.entity.BDirectory;

public interface DirectoryDao extends EntityDao<BDirectory>{

	public List<BDirectory> getDirectoryeList(String search,String order,String page);
	public BDirectory getDirectoryeTotal(String search);
	public List<BDirectory> getDirectoryeListAll(String search,String order);
	public BDirectory getChannelTotal(String channel,String item,String time);
	public BDirectory getProfTotal(String prof);
	public List<BDirectory> ProfAll(String item,String time);
	public void directoryDel(String logid);
} 
