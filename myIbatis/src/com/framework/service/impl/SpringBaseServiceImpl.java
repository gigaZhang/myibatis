package com.framework.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.dao.EntityDao;
import com.framework.service.BaseService;

public class SpringBaseServiceImpl<T, I extends EntityDao<T>> implements
		BaseService<T> {
	protected final Log log = LogFactory.getLog(this.getClass());

	private I baseDao;

	public I getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(I _baseDao){
		baseDao=_baseDao;
	}
//
//	public int getCount(PageProperty pp) {
//		return baseDao.findCount(pp);
//	}

	public void insert(T model) {
		baseDao.insert(model);
	}

	public T getModel(Map param) {
		return baseDao.getModel(param);
	}

	public void update(T model) {
		baseDao.update(model);
	}

	public void delete(Serializable id) {
		baseDao.delete(id);
	}

//	public PageList<T> getPageList(PageProperty pp) {
//		int count = baseDao.findCount(pp);
//		int start = PageUtil.getStart(pp.getNpage(), count, pp
//				.getNpagesize());
//		int end = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
//		pp.putParamMap("start", start);
//		pp.putParamMap("end", end);
//		PageList<T>	pageList = new PageList<T>(pp, count, baseDao.findPageList(pp));
//		return pageList;
//	}

	public T getModel(Serializable id){
		Map param = new HashMap();
		param.put("id", id);
		return getModel(param);
	}

	public List<T> listModel(Map param) {
		List<T> list = baseDao.list(param);
		return list;
	}

	public void deleteList(String id) {
		baseDao.deleteList(id);
	}

	public void deleteGroup(Map param) {
		baseDao.deleteGroup(param);
	}

}
