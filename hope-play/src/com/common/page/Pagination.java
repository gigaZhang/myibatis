package com.common.page;

import javax.servlet.http.HttpServletRequest;

import com.common.tool.StringUtils;

/**
 * 分页对象
 * @author lph
 * 
 */
public class Pagination {

	/**
	 * 每页显示行数
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private int totalRecord;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页数
	 */
	private int currentPage;
	
	/**
	 * 实例化分页对象
	 * 
	 * @param arg0
	 *            当前request
	 * @param pageSize
	 *            每页行数
	 * @param totalRecord
	 *            总记录数
	 */
	public Pagination(HttpServletRequest arg0, int pageSize, int totalRecord) {
		init(arg0, pageSize, totalRecord);
	}
	
	public Pagination(HttpServletRequest arg0, int pageSize) {
		this.pageSize = pageSize;
		String pSize=arg0.getParameter("pageSize");
		if(StringUtils.isEmpty(pSize)){
			this.pageSize=pageSize;
		}else{
			if(!StringUtils.isNumber(pSize)){
				this.pageSize=pageSize;
			}else{
				this.pageSize=(new Integer(pSize)).intValue();
			}
		}
		String currPage=arg0.getParameter("currentPage");
		if(StringUtils.isEmpty(currPage)){
			this.currentPage=1;
		}else{
			if(!StringUtils.isNumber(currPage)){
				this.currentPage=1;
			}else{
				this.currentPage=(new Integer(currPage)).intValue();
				
			}
		}
		String totalRecord=arg0.getParameter("totalRecord");
		if(StringUtils.isEmpty(totalRecord)){
			this.totalRecord=0;
		}else{
			if(!StringUtils.isNumber(totalRecord)){
				this.totalRecord=0;
			}else{
				this.totalRecord=(new Integer(totalRecord)).intValue();
				
			}
		}
		
	}

	private void init(HttpServletRequest arg0, int pageSize, int totalRecord) {
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		//String cuuPage=ParamUtils.getIntParameter(arg0,"currentPage", 0);
		String pSize=arg0.getParameter("pageSize");
		if(StringUtils.isEmpty(pSize)){
			this.pageSize=pageSize;
		}else{
			if(!StringUtils.isNumber(pSize)){
				this.pageSize=pageSize;
			}else{
				this.pageSize=(new Integer(pSize)).intValue();
			}
		}
		String currPage=arg0.getParameter("currentPage");
		if(StringUtils.isEmpty(currPage)){
			this.currentPage=1;
		}else{
			if(!StringUtils.isNumber(currPage)){
				this.currentPage=1;
			}else{
				this.currentPage=(new Integer(currPage)).intValue();
				
			}
		}
		//this.currentPage = (ParamUtils.getIntAttribute(arg0, "currentPage", 0))+1;
		if (this.pageSize != 0 && this.totalRecord != 0) {
			if (totalRecord % this.pageSize > 0) {
				this.totalPage = totalRecord / this.pageSize + 1;
			} else {
				this.totalPage = totalRecord / this.pageSize;
			}
		}
		if((this.currentPage-1)*this.pageSize+this.pageSize>this.totalRecord){
			this.currentPage=this.totalPage;
		}
	}
	
	/**
	 * @return 当前页
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * 设置当前页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * @return 每页显示数
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置每页显示数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return 总页数
	 */
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * 总页数
	 * @param totalPage
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 返回总记录数
	 * @return
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	
	/**
	 * 总记录数
	 * @param totalRecord
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		if (this.pageSize != 0 && this.totalRecord != 0) {
			if (totalRecord % this.pageSize > 0) {
				this.totalPage = totalRecord / this.pageSize + 1;
			} else {
				this.totalPage = totalRecord / this.pageSize;
			}
		}
		if((this.currentPage-1)*this.pageSize+this.pageSize>this.totalRecord){
			this.currentPage=this.totalPage;
		}
	}

	/**
	 * 返回下一页数据的起始行
	 * @return
	 */
	public int getOffset(){
		int offset=(this.currentPage-1)*this.pageSize;
		if(offset<0){
			offset=0;
		}
		return offset;
	}

	/**
	 * 返回下一页取多少行数据
	 * @return
	 */
	public int getMaxRow(){
		return this.pageSize;
	}


}
