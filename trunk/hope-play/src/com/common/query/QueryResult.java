package com.common.query;

import java.io.Serializable;
import java.util.List;

/**
 * 查询结果封装
 * @author lph
 * @Date 2011-11-03
 * @param <T>
 */
@SuppressWarnings("serial")
public class QueryResult<T> implements Serializable {

	/**
	 * 起始记录数
	 */
	private int start;

	/**
	 * 获取记录数
	 */
	private int offset;

	/**
	 * 总数
	 */
	private int total;

	/**
	 * 返回记录条数
	 */
	private int curSize;

	/**
	 * 结果记录集
	 */
	private List<T> result;
	
	/**
	 * 结果对象(返回对象的结果)
	 */
	private T resObj;
	


	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurSize() {
		return curSize;
	}

	public void setCurSize(int curSize) {
		this.curSize = curSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public T getResObj() {
		return resObj;
	}

	public void setResObj(T resObj) {
		this.resObj = resObj;
	}
}
