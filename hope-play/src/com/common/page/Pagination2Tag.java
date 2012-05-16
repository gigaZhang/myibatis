/**
 * 
 */
package com.common.page;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.common.tool.StringUtils;



/**
 * 标签解析类
 * @author lph
 * 
 */
@SuppressWarnings("unused")
public class Pagination2Tag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contextPath;
	Logger logger = Logger.getLogger(Pagination2Tag.class.getName());

	private String surfix = "";
	
	private String name = "_pagination";

	private String scope = "request";

	private String styleClass = "pagination" ;

	private String requestURI;
	
	private String imagePath = "resources1/images/page/";
	
	private String formId;
	
	
	private String defaultFormId = "pageForm";
	
	private String loadFunction;
	
	private String submitCall;

	

	public String getLoadFunction() {
		return loadFunction;
	}

	public void setLoadFunction(String loadFunction) {
		this.loadFunction = loadFunction;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	private String append;

	public String getAppend() {
		return append;
	}

	public void setAppend(String append) {
		this.append = append;
	}


	public Pagination2Tag() {
		name = "";
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	HttpServletRequest httprequest;
	
	public int doStartTag() {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		ServletContext context = pageContext.getServletContext();
		this.contextPath = request.getContextPath();
		
		if(requestURI != null && !requestURI.equals(""))
		{
			if(this.requestURI.indexOf("?") == -1){   			//将所有requestURI 中?改为&  此处requestURI就可随意指定参数
				this.requestURI = this.requestURI + "?1=1";		//找不到就默认添加?1=1
			}
			if(this.requestURI.trim().startsWith("/"))
			{
				this.requestURI = this.contextPath + this.requestURI; 
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		ServletContext context = pageContext.getServletContext();
		String name = this.name;

		Object variable = null;
		Object bean = null;
		if (StringUtils.isEmptyString(name)) {
			name = "_pagination";
		}
		if (StringUtils.isEmpty(scope)) {
			scope = "request";
		}
		if (name != null) {
			TagUtils tagUtils=TagUtils.getInstance();
			bean = tagUtils.lookup(pageContext, name, scope);
			variable = bean;
		}
		// request = (HttpServletRequest) pageContext.getRequest();

		try {
			String outValue = getPaginationHTML((Pagination) variable);
			out.println(outValue);
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			this.httprequest = request;
		} catch (IOException e) {
			throw new RuntimeException("footer info out error!");
		}
		return EVAL_PAGE;
	}

	private String getPaginationHTML(Pagination pagination) {
		StringBuffer pageBuffer = new StringBuffer();
		String currentPage = "";
		pageBuffer.append(getJs(pagination));
		pageBuffer.append("\t<div class=\"" + this.styleClass + "\">\n");
		if (pagination != null && pagination.getTotalRecord() > 0) {
			pageBuffer.append("\t\t<table border=\"0\" cellpadding='0' cellspacing='0' ><tr>\n");
			pageBuffer.append("\t\t<td>\n");
			pageBuffer.append(selectMaxRow(pagination).toString());
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			pageBuffer.append("\t\t<td class='navi' align='center'>\n");
			pageBuffer.append(getFirst(pagination));
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td class='navi' align='center'>\n");
			pageBuffer.append(getPrevious(pagination));
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			
			pageBuffer.append(getIncrease(pagination).toString());

			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			pageBuffer.append("\t\t<td class='navi' align='center'>\n");
			pageBuffer.append(getNext(pagination));
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td class='navi' align='center'>\n");
			pageBuffer.append(getLast(pagination));
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			pageBuffer.append("\t\t<td>\n");
			pageBuffer.append(getGoto(pagination).toString());
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			pageBuffer.append("\t\t<td>\n");
			pageBuffer.append(getPageInfo(pagination));
			pageBuffer.append("\t\t</td>\n");
			pageBuffer.append("\t\t<td><div class='pagination-separator'></div></td>\n");
			pageBuffer.append("\t\t</tr></table>");
			pageBuffer.append(getPageRecordInfo(pagination));
		}
		else
		{
			 pageBuffer.append("无记录显示");
		}
		
		pageBuffer.append("\t</div>\n");
		return pageBuffer.toString();
	}

	private StringBuffer selectMaxRow(Pagination pagination) {
		StringBuffer str = new StringBuffer();
		int defValue = pagination.getPageSize();
		String selected = "";
		str.append("\t\t<select id=\"maxRow" + surfix +"\" onchange=\"selectMaxRow" + surfix +"();\" class='pagination-page-list'> \n");
		for (int i = 0; i < 5; i++) {
			int v = (i + 1) * 10;
			if (v == defValue) {
				selected = "selected";
			} else {
				selected = "";
			}
			str.append("\t\t\t<option id=\"" + i + "\" value=\"" + v + "\" " + selected + ">" + v + "</option>\n");
		}
		str.append("\t\t</select>\n");
		return str;
	}

	private StringBuffer getJs(Pagination pagination) {
		StringBuffer str = new StringBuffer();
		if (pagination != null) {
			
			str.append("<script type=\"text/javascript\">\n");
				str.append(" function getPreferPage" + surfix +"(totalRecord, currentPageSize, currentPage)" +
						"{if(currentPageSize * currentPage > totalRecord)" +
						"{if(totalRecord%currentPageSize == 0) return totalRecord/currentPageSize;" +
						"else return parseInt(totalRecord/currentPageSize) + 1;}else return currentPage; }");
				str.append("function goto" + surfix +"(obj, ppageSize){\n");
				str.append("\tvar currentPage=" + pagination.getCurrentPage() + ";\n");
				str.append("\t var pageSize= " + pagination.getPageSize()+ ";\n");
				str.append("\tif(ppageSize != undefined) pageSize=ppageSize;\n");
				str.append("\tif(obj == \"\" || !isdigit" + surfix +"(obj)){\n");
				str.append("\t\talert('请输入数字！');\n");
				str.append("\t}else{\n");
				str.append("\t\tif(obj>" + pagination.getTotalPage() + "){\n");
				str.append("\t\t\talert('您只能输入" + pagination.getTotalPage() + "！');\n");
				str.append("\t\t}else{\n");
				str.append("\t\t\tif(obj==currentPage &&  ppageSize == undefined){\n");
				str.append("\t\t\t\talert('当前页面已经是第'+currentPage+'页');\n");
				str.append("\t\t\t}else{\n");
				
//				if(StringUtils.isNotEmpty(userPageAjax) && userPageAjax.equals("true")){
//					str.append("\t\t\t\tvar urlLocation='" + this.requestURI + "&currentPage='+obj+'" + "&pageSize=' + pageSize;\n");
//					str.append("\t\t\t\t" + submitCall + "(urlLocation,'"+ divID +"');" );
//				}else{
//					
//				}
				if(StringUtils.isEmpty(this.submitCall)){
					if(StringUtils.isEmpty(formId) ){ //走URL
						if(!StringUtils.isEmpty(loadFunction)){
							str.append(loadFunction+"('" + this.contextPath + "');\n");
						}
						if(this.getAppend() != null && !"".equals(this.getAppend()))
							str.append("\t\t\t\tself.location='" + this.requestURI + "?" + this.getAppend() +"&currentPage='+obj+'" + "&pageSize='+pageSize;\n");
						else
						{
							str.append("\t\t\t\tself.location='" + this.requestURI + "?currentPage='+obj+'" + "&pageSize='+pageSize;\n");
						}
					}else{
						str.append("\t\t\t\t var submitForm=document.getElementById('"+formId+"');\n");
						str.append("\t\t\t\t document.getElementById('" + formId + "').innerHTML=" +
								"document.getElementById('" + formId +"').innerHTML+" +
										"'<input type=\"hidden\" name=\"currentPage\" value=\"'+obj+'\"/>" +
										"<input type=\"hidden\" name=\"pageSize\" value=\"'+pageSize+'\"/>'\n");
						if(this.getAppend() != null && !"".equals(this.getAppend()))
						{
							String[] paras = this.getAppend().split("\\&");
							
							for(int i =0; i < paras.length; i++)
							{
								int eqIndex = paras[i].indexOf("=");
								String key = paras[i].substring(0, eqIndex);
								String value = "";
								if(paras[i].length() > eqIndex + 1)
									value =  paras[i].substring(eqIndex + 1);
								str.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" +value+ "\"/>'\n");
							}
						}
						str.append(";");
						if(!StringUtils.isEmpty(loadFunction)){
							str.append(loadFunction+"('" + this.contextPath + "');\n");
						}
						str.append("\t\t\t\t submitForm.submit();\n");
					}
				}else{
					StringBuffer appendJsObj = new StringBuffer("");
					//对append的附加字段进行处理
					if(this.getAppend() != null && !"".equals(this.getAppend()))
					{
						String[] paras = this.getAppend().split("\\&");
						
						for(int i =0; i < paras.length; i++)
						{
							if(i > 0)
								appendJsObj.append(",");
							int eqIndex = paras[i].indexOf("=");
							String key = paras[i].substring(0, eqIndex);
							String value = "";
							if(paras[i].length() > eqIndex + 1)
								value =  paras[i].substring(eqIndex + 1);
							appendJsObj.append("'" + key + "':'" +value + "'");
						}
					}
					
					if("".equals(appendJsObj.toString()))
							str.append("\t\t\t\t" + submitCall + "({'currentPage':obj,'pageSize':pageSize" + appendJsObj.toString() +"});" );
					else
					{
						str.append("\t\t\t\t" + submitCall + "({'currentPage':obj,'pageSize':pageSize," + appendJsObj.toString() +"});" );
					}
				}
				str.append("\t\t\t}");
				str.append("\t\t\t}\n");
				str.append("\t}\n");
				// request
				str.append("}\n");

				str.append("function isdigit" + surfix +"(s){\n");
				str.append("\tvar r,re;\n");
				str.append("\tre =/\\d*/i;\n");
				str.append("\tr = s.match(re);\n");
				str.append("\treturn (r==s)?1:0;\n");
				str.append("}\n");

				str.append("function beatKey" + surfix +"(obj){\n");
				str.append("\tif(event.keyCode==13){\n");
				str.append("\t\tgoto" + surfix +"(document.getElementById('pageNum" + surfix +"').value);\n");
				str.append("\t}\n");
				str.append("}\n");
				str.append("function selectMaxRow" + surfix +"(){\n");
				str.append("\tvar obj=document.getElementById(\"maxRow" + surfix +"\");\n");
				
				str.append("var prePS = getPreferPage" + surfix +"(" + pagination.getTotalRecord() + ",obj.value," + pagination.getCurrentPage() + ");goto" + surfix +"(prePS+'', obj.value);");
				str.append("}\n");
				str.append("</script>\n");
			}
		return str;
	}

	private StringBuffer getGoto(Pagination pagination) {
		StringBuffer str = new StringBuffer();
		str.append("<input type=\"hidden\" id=\"currentPageTmp" + surfix +"\" name=\"currentPageTmp" + surfix +"\"  value=\"" +pagination.getCurrentPage() + "\" /> ");
		str.append("<input type=\"hidden\" id=\"pageSizeTmp" + surfix +"\" name=\"pageSizeTmp" + surfix +"\"  value=\"" +pagination.getPageSize() + "\" /> ");
		str.append("<input type=\"hidden\" id=\"totalRecordTmp" + surfix +"\" name=\"totalRecordTmp" + surfix +"\"  value=\"" +pagination.getTotalRecord() + "\" /> ");
		str.append("<input type=\"text\" id=\"pageNum" + surfix +"\" name=\"pageNum\" size=\"2\"  class=\"pagination-num\"  onkeypress=\"javascript:beatKey" + surfix +"(this);\" > \n </td>");
		if(StringUtils.isEmpty(this.getImagePath())){
			str.append("<td>go");
		}else{
			str.append("<td><img src=\""+this.getGoImagePath(0)+"\" onclick=\"javascript:goto" + surfix +"(document.getElementById('pageNum" + surfix +"').value);\" width=\"15\" height=\"15\" border=\"0\" onmouseover=\"this.src='"+this.getGoImagePath(1)+"';this.style.cursor='hand'\"" +
					" onmouseout=\"this.src='"+this.getGoImagePath(0)+"'\"/>");
		}
		return str;
	}

	private String getPageInfo(Pagination pagination) {
		String str = "";
		str = "\t\t<div id=\"pageInfo\" class='pagination-info'>\n";
		str = str + "共" + pagination.getTotalPage() + "页";
		str = str + "(" + pagination.getTotalRecord() + "条)";
		str = str + "\t\t</div>\n";
		return str;
	}
	private String getPageRecordInfo(Pagination pagination) {
		String str = "";
		str = "\t\t<div id=\"pageInfo1\" class='pagination-info1'>\n";
		str = str + "当前显示第" + (pagination.getOffset() + 1)+ "到" 
			+ (pagination.getOffset() + pagination.getPageSize() > pagination.getTotalRecord() ? pagination.getTotalRecord():pagination.getOffset() + pagination.getPageSize()) + "条记录" ;
		str = str + "\t\t</div>\n";
		return str;
	}
	private StringBuffer getIncrease(Pagination pagination) {
		StringBuffer str = new StringBuffer();
		int currentPage = pagination.getCurrentPage();
		int min = 0;
		int max = 5;
		if (!(pagination.getTotalPage() < 5)) {
			if (currentPage - 2 <= 0) {
				min = 0;
				max = 5;
			} else if (currentPage + 2 >= pagination.getTotalPage()) {
				min = pagination.getTotalPage() - 5;
				max = pagination.getTotalPage();
			} else {
				min = currentPage - 3;
				max = currentPage + 2;
			}
		} else {
			min = 0;
			max = pagination.getTotalPage();
		}
		for (int j = min; j < max; j++) {
			int k = j + 1;
			str.append("<td class='number'>");
			str.append("\t\t\t<div id=\"num\">\n");
//			String url = "";
//			if (StringUtils.isEmpty(this.append)) {
//				url = "?currentPage=" + k + "&pageSize=" + pagination.getPageSize();
//			} else {
//				url = "?" + this.append + "&currentPage=" + k + "&pageSize=" + pagination.getPageSize();
//			}
			if (k != currentPage) {
				// if (this.defaultUrl) {
				// this.defurl = this.requestURI + url;
				// } else {
				// this.defurl = "javascript:gotourl('" + k + "','" + pagination.getPageSize() + "');";
				// }
				str.append("\t\t\t\t<a  id=\"num" + k + "\"  href=\"javascript:goto" + surfix +"('" + k
						+ "')\" ><span class=\"page_num\" >\n");
			} else {
				str.append("\t\t\t\t<span class=\"cur_page_num\"  >\n");
			}
			str.append("" + k + "");
			if (k != currentPage) {
				str.append("</span></a>");
			} else {
				str.append("\t\t\t\t</span>\n");
			}
			str.append("\t\t\t</div>\n");
			str.append("</td>");
		}
		return str;
	}

	private String getNext(Pagination pagination) {
		return this.getPageTag(pagination, (pagination.getCurrentPage() + 1),3,pagination.getCurrentPage() != pagination.getTotalPage());
	}

	private String getPrevious(Pagination pagination) {
		return this.getPageTag(pagination, (pagination.getCurrentPage() - 1), 2,pagination.getCurrentPage() != 1);
	}

	private String getLast(Pagination pagination) {
		return this.getPageTag(pagination,   pagination.getTotalPage(),4,pagination.getCurrentPage() != pagination.getTotalPage());
	}

	private String getFirst(Pagination pagination) {
		return this.getPageTag(pagination, 1, 1, pagination.getCurrentPage() != 1);
	}
	
	/**
	 * 
	 * @param pagination
	 * @param goToPage 跳转页面
	 * @param type 类型 1 fist  2 pre  3 next 4 last
	 * @return
	 */
	private String getPageTag(Pagination pagination, int goToPage, int type, boolean isGoTo ) {
		StringBuffer str = new StringBuffer("");
		if (!StringUtils.isEmpty(this.getImagePath())) {
			if (isGoTo) {
				str.append("\t\t\t<a  id=\"first\" href=\"javascript:goto" + surfix +"('" + goToPage + "')\">" +
						"<img src='" + this.getImage(type, 0) + "' border='0' alt='" + this.getTextName(type)+"' " +
						" onmouseover=\"this.src='"+ this.getImage(type,1) + "';this.style.cursor='hand'\" " +
								"onmouseout=\"this.src='"+this.getImage(type,0)+"'\"></a>\n");
			} else {
				str.append("\t\t\t<img src='" +this.getImage(type,2)+ "' border='0' alt='" + this.getTextName(type)+"'>\n");
			}
		} else {
			if (isGoTo) {
				str.append("\t\t\t<a  id=\"first\" href=\"javascript:goto" + surfix +"('" + goToPage + "\">[" + this.getTextName(type)+"]</a>\n");
			} else {
				str.append("\t\t\t[" + this.getTextName(type)+"]\n");
			}
		}
		return str.toString();
	}

	
	private String getFistImagePath(int type)
	{
		return this.contextPath + "/" + this.getImagePath() + "first_" + type+ ".gif";
	}
	private String getPreImagePath(int type)
	{
		return this.contextPath + "/" + this.getImagePath()+ "pre_" + type+ ".gif";
	}
	private String getNextImagePath(int type)
	{
		return this.contextPath + "/" + this.getImagePath()+ "next_" + type+ ".gif";
	}
	
	private String getLastImagePath(int type)
	{
		return this.contextPath + "/" + this.getImagePath()+ "last_" + type+ ".gif";
	}
	
	private String getGoImagePath(int type)
	{
		return this.contextPath + "/" + this.getImagePath()+ "go_" + type+ ".gif";
	}
	
	private String getTextName(int imageType)
	{
		switch(imageType)
		{
		case 1://first
			return "首页";
		case 2://pre
			return "上一页";
		case 3://next
			return "下一页";
		case 4://last
			return "末页";
		}
		return "";
	}
	private String getImage(int imageType, int type)
	{
		switch(imageType)
		{
		case 1://first
			return getFistImagePath(type);
		case 2://pre
			return getPreImagePath(type);
		case 3://next
			return getNextImagePath(type);
		case 4://last
			return getLastImagePath(type);
		}
		return "";
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getSubmitCall() {
		return submitCall;
	}

	public void setSubmitCall(String submitCall) {
		this.submitCall = submitCall;
	}

	public String getSurfix() {
		return surfix;
	}

	public void setSurfix(String surfix) {
		this.surfix = surfix;
	}
	
}
