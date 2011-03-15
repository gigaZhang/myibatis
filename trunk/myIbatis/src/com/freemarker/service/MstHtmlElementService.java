package com.freemarker.service;

import java.util.List;

import com.framework.service.BaseService;
import com.freemarker.entity.MstHtmlElement;

public interface MstHtmlElementService extends BaseService<MstHtmlElement>{
	
	public List<MstHtmlElement> listModel(String mhcid,String mapno);
	public void deleteGroup(String mhcid,String mapno);
	public void initial(String mhcid,String mapno,String p,String t);
	public void updateTips(String tips,String mheids);

}
