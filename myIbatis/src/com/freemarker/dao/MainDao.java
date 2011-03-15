package com.freemarker.dao;

import java.util.List;

import com.framework.dao.EntityDao;
import com.freemarker.entity.BMain;

public interface MainDao extends EntityDao<BMain>{
	public List<BMain> getBBSClass(String mapno);
	public List<BMain> getMainList(String mapno,String topage,String search);
	public BMain getTotalPage(String mapno,String search);
	public void delMainInfo(String bmid,String mapno);
	public void delFollow(String bmid,String mapno);
	public void addDeletedMain(String bmid,String mapno,String userip,String userid);
	public void addDeletedFollow(String bmid,String mapno);
	public BMain editorMainInfo(String bmid,String mapno);
	public void updateMainInfo(String bmid,String bmtag,String mapno);
	public BMain getBcId(String bcname);
	public BMain getBcName(String bcid);
	public BMain getTagName(String bcid);
	public void bbsLog(String title,String userid);
	public void updateBbsMainTitle(String mapno,String bmid,String title);

}
