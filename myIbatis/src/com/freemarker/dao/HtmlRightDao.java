package com.freemarker.dao;

import com.framework.dao.EntityDao;
import com.freemarker.entity.HtmlRight;

public interface HtmlRightDao extends EntityDao<HtmlRight>{
	public void setHtmlRight(HtmlRight right);
	public void updateHtmlRight(HtmlRight right);
	public HtmlRight getHtmlRight(HtmlRight right);
}
