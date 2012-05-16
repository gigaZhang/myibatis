package com.common.query;

import java.io.Serializable;

import com.common.tool.GenericsUtils;

/**
 * 查询条件
 * 
 * @author lph
 * @Date 2011-11-03
 */
@SuppressWarnings({ "serial", "unchecked","rawtypes" })
public abstract class QueryParemeters<T> implements Serializable {

	public QueryParemeters() {
		try {
			entity = (T) GenericsUtils.getSuperClassGenricType(getClass())
					.newInstance();
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		}
	}

	public T entity;

	private String dataType;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * 起始记录数
	 */
	private int start;

	/**
	 * 获取记录数
	 */
	private int offset;

	/**
	 * 是否需要总条数
	 */
	private boolean isTotal;

	/**
	 * 是否需要结果
	 */
	private boolean isResult;

	/**
	 * 返回的vo类型
	 */
	private Class returnVoType;

	public Class getReturnVoType() {
		return returnVoType;
	}

	public void setReturnVoType(Class returnVoType) {
		this.returnVoType = returnVoType;
	}

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

	public boolean isTotal() {
		return isTotal;
	}

	public void setTotal(boolean isTotal) {
		this.isTotal = isTotal;
	}

	public boolean isResult() {
		return isResult;
	}

	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
}
