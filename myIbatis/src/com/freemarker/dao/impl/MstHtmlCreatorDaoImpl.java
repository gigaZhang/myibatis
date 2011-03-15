package com.freemarker.dao.impl;

import java.util.List;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.MstHtmlCreatorDao;
import com.freemarker.entity.MstHtmlCreator;

public class MstHtmlCreatorDaoImpl extends EntityDaoImpl<MstHtmlCreator> implements MstHtmlCreatorDao{

	
	public List<MstHtmlCreator> listModule() {
		return (List)getSqlMapClientTemplate().queryForList("listModule");
	}

}
