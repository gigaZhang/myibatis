package com.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页dto
 * @author lph
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class PaginationQueryDto<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//多少页
	private Long totalPage;
	
	//多少条记录
	private Long totalRecords = new Long(0);
	
	private Integer curPage;
	
	
	private Integer offset;

	private Integer maxRow;
	
	
	private List resultList = new ArrayList();
	private T info;
	
	private Pagination pagination;
	public void init(HttpServletRequest r)
	{
		pagination  = new Pagination(r, 10);
		setOffset(pagination.getOffset());
		setMaxRow(pagination.getMaxRow());
	}
	public Long getTotalPage() {
		if(maxRow > 0)
		{
			return totalRecords % maxRow == 0? totalRecords / maxRow : totalRecords / maxRow + 1;
		}
		return totalPage;
	}
	
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
		if(pagination != null )
			pagination.setTotalRecord(totalRecords.intValue());
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(Integer maxRow) {
		this.maxRow = maxRow;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	public Pagination getPagination() {
		return pagination;
	}
	
	
	
}
