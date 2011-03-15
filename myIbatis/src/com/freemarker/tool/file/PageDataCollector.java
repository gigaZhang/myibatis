package com.freemarker.tool.file;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.freemarker.tool.MST_StringUtil;


public class PageDataCollector {
	public static final String TO_PAGE = "toPage";
	public static final String CURRENT_PAGE = "currPage";
	public static final String TOTAL_ITEMS = "totalItems";

	public static int transNullToInt(String num){
		
		String numStr = MST_StringUtil.transNullString(num);
		try {
			if(MST_StringUtil.isStringNull(numStr)){
				return 0;
			}else{
				return Integer.parseInt(num);
			}
		} catch (Exception e) {
			System.err.println("pageDataError:"+e.getMessage());
			return 0;
		}

	}
	
	public static PageData collectAndSavePage(HttpServletRequest request){

		PageData pageData = new PageData();
		int totalItems = transNullToInt(request.getParameter(TOTAL_ITEMS));
		if(totalItems == 0){
			//First Time 
			pageData.setCurrentPage(1);
			
		}else{
			int toPage = transNullToInt(request.getParameter(TO_PAGE));
			pageData.setTotalItems(totalItems);
			pageData.setCurrentPage(toPage);
		}
		request.setAttribute("pageData",pageData);
	//	System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		collectParameter(request);	
		
		return pageData;
	}

	private static void collectParameter(HttpServletRequest request) {

		StringBuffer paras = new StringBuffer();
		Enumeration en =  request.getParameterNames();
		
		int paramCount = 0;
		while(en.hasMoreElements()){

			String elementName = (String)en.nextElement();
			if(!elementName.equals(TO_PAGE) && !elementName.equals(TOTAL_ITEMS) && !elementName.equals("topic.text") && !elementName.equals("discntInfo.dis_desc") &&!elementName.equals("Content") && !elementName.equals("ddtopic.cont")){
				if(paramCount>0){
					paras.append("&");
				}
				if (elementName.equals("article.search")){
					try {
						paras.append(elementName).append("=").append(URLEncoder.encode(request.getParameter(elementName),"GBK"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}else 
					paras.append(elementName).append("=").append(request.getParameter(elementName));
			//	System.out.println("vvvvvvvvvvvv");
				paramCount++;
			}
		}

		request.setAttribute("paramterLink",paras.toString());
		request.setAttribute("requestUrl",request.getRequestURI());		
	}
	

	
	public static void main(String[] args) {

		
	}
	
}
