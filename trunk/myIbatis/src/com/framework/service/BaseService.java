package com.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * @author kim
 *
 * 提供单表数据查询保存的基本方泄1�7
  */
public interface BaseService<T> {
	public abstract T getModel(Serializable id);
	public abstract T getModel(Map param);
	public abstract List<T> listModel(Map param);
	public abstract void update(T model);
	public abstract void insert(T model);
	public abstract void delete(Serializable id);
	public abstract void deleteList(String id);
	public abstract void deleteGroup(Map param);
//	public abstract int getCount(PageProperty pp);
//	public abstract PageList<T> getPageList(PageProperty pp);
}
