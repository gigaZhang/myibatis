package com.ldl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.Action;

public class BigPageAction {
	private static Integer NUM = 100;
	private Map json = new HashMap(); 
	private Integer toPage;
	private Integer pageSize;
	private String keyword;

	public String getData1(){
		List<String []> list = new ArrayList<String []>();
		
		for(int i=0;i<NUM;i++){
			list.add(new String[]{"公司" + i,"www.add"+i + ".com","2"+i,"3"+i});
		}
		String[][] data = null;
		data = list.toArray(new String[list.size()][4]);
		
		json.put("data", data);
		
		return Action.SUCCESS;
	}
	public String getData2(){
		List<String []> list = new ArrayList<String []>();
		
		for(int i=0;i<NUM;i++){
			list.add(new String[]{"公司" + i,"www.add"+i + ".com","2"+i,"3"+i});
		}
		if(toPage < 1){
			toPage = 1;
		}
		if(pageSize < 1){
			pageSize = 50;
		}
		
		Integer start = (toPage - 1)*pageSize;
		Integer end = toPage*pageSize;
		int c = 0 ;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String[] strings = (String[]) iterator.next();
			if(keyword != null && strings[0].indexOf(keyword) == -1){
				c ++;
				iterator.remove();
			}
		}
		String[][] data = null;

		if(start > NUM -c){
			json.put("data", data);
			json.put("totalRecord", 0);
			return Action.SUCCESS;
		}
		
		if(end > NUM -c)end = NUM -c;
		List<String []> list1 = list.subList(start, end);
		
		data = list1.toArray(new String[list1.size()][4]);
		
		json.put("data", data);
		json.put("totalRecord", NUM - c);

		return Action.SUCCESS;
	}
	
	public Map getJson() {
		return json;
	}

	public void setJson(Map json) {
		this.json = json;
	}

	public Integer getToPage() {
		return toPage;
	}

	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
