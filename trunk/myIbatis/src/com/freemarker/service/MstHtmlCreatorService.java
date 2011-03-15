package com.freemarker.service;

import java.util.List;

import com.framework.service.BaseService;
import com.freemarker.entity.MstHtmlCreator;

public interface MstHtmlCreatorService extends BaseService<MstHtmlCreator>{
	
	public List<MstHtmlCreator> moduleList();
	public List<MstHtmlCreator> nameList(String module);
	public MstHtmlCreator mhcValue(String mhcid);

}
