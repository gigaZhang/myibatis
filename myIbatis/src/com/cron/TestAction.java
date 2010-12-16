package com.cron;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.framework.tool.BeanLocator;
import com.questionnaire.action.BaseAction;
import com.questionnaire.dao.IIndagateDao;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestAction extends BaseAction {

	IIndagateDao indagateDao = (IIndagateDao) BeanLocator.getBean("indagateDao");

	/*
	 * 创建一个新页面
	 */
	public void testCreate() {
		Map saleMap = new HashMap();
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " 1=1 ";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);
		List indagateList = indagateDao.getIndagateList(paramMap);
		Map map = new HashMap();
		map.put("indaList", indagateList);
		create(getRequest().getRealPath("/proj/cron/stencil"), "test.ftl", map,
				getRequest().getRealPath("/proj/cron/page/indalist.htm"));
	}
	
	public boolean create(String ftlpath, String ftlname, Map ftldataMap,
			String htmlfile) {
		Configuration con = new Configuration();
		Template t = null;
		try {
			con.setDirectoryForTemplateLoading(new File(ftlpath));
			t = con.getTemplate(ftlname);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return create(t, ftldataMap, htmlfile);
	}

	public boolean create(Template tpl, Map ftldataMap, String htmlfile) {
		File htmlFile = new File(htmlfile);
		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile)));
			tpl.process(ftldataMap, out);
			out.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
