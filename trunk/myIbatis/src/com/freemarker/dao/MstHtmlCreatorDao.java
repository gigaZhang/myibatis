package com.freemarker.dao;

import java.util.List;

import com.framework.dao.EntityDao;
import com.freemarker.entity.MstHtmlCreator;

public interface MstHtmlCreatorDao extends EntityDao<MstHtmlCreator>{
	
	public List<MstHtmlCreator> listModule();
}
