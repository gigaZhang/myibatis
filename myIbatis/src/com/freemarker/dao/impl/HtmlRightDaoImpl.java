package com.freemarker.dao.impl;

import com.framework.dao.impl.EntityDaoImpl;
import com.freemarker.dao.HtmlRightDao;
import com.freemarker.entity.HtmlRight;

public class HtmlRightDaoImpl extends EntityDaoImpl<HtmlRight> implements HtmlRightDao{

	public void setHtmlRight(HtmlRight right) {
		getSqlMapClientTemplate().insert("setHtmlRight", right);
		
	}

	public HtmlRight getHtmlRight(HtmlRight right) {
		return (HtmlRight)getSqlMapClientTemplate().queryForObject("getHtmlRight", right);
	}

	public void updateHtmlRight(HtmlRight right) {
		getSqlMapClientTemplate().update("updateHtmlRight", right);
		
	}

}
