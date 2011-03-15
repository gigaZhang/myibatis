package com.freemarker.dao;

import java.util.List;

import com.framework.dao.EntityDao;
import com.freemarker.entity.BHome;

public interface HomeDao extends EntityDao<BHome>{

	public List<BHome>getModule();
	public List<BHome>allItem(String module,String mapno);
	public BHome initialValue(String item);
	public List<BHome>txtInfo(String item,String mapno);
	public List<BHome>picInfo(String item,String mapno,String piccounts);
	public void setHot(BHome home);
	public void setPic(BHome home);
	public void settxt(BHome home);
	public void setLog(BHome home);
	public List<BHome>picList(String mapno,String item);
	public List<BHome>txtList(String mapno,String item);
	public BHome recommandPath(String item);
	public BHome bbsComment(String mapno,String bmid);
	public BHome busComment(String mapno);
	public BHome userhead(String userid);
	public List<BHome>getStationModule();
	public BHome getMhcId(String mhcname);
	public BHome getHomeInfo(String mhcname);
	public List<BHome> getElement(String mapno,String item,String logid );
	public void setDirectory(BHome b);
	public BHome getDirectory(String mheid);
	public void setDirectoryStatus(String tlogid);
	public void initElementByFName(BHome home);
	public void upElementByFName(BHome home);
	public BHome getMhcName(String mhcid);
	public List<BHome>getCompanyList(String page);
	public BHome companyTotal();
	public void addCompany(BHome home);
	public void delCompany(String mhcid);
	
}
