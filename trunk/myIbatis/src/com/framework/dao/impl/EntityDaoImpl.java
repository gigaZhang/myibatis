package com.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.framework.common.PageProperty;
import com.framework.dao.EntityDao;
import com.framework.tool.Constants;


public class EntityDaoImpl<T> extends SqlMapClientDaoSupport implements
		EntityDao<T> {

	Class<T> poClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	String poClassName = poClass.getSimpleName();
	
	public T getModel(Map param) {
		return (T) this.getSqlMapClientTemplate().queryForObject(
				"get" + poClassName, param);
	}
	

	public int insert(T model) {
		this.getSqlMapClientTemplate().insert("insert" + poClassName, model);
		return Constants.CODE_DAO_SUCCESS;
	}

	public int update(T model) {
		return this.getSqlMapClientTemplate().update("update" + poClassName,
				model);
	}

	public int delete(Serializable id) {
		Map param = new HashMap();
		param.put("id", id);
		param.put("flag", Constants.STATUS_DELETED);
		return this.getSqlMapClientTemplate().update("delete" + poClassName,
				param);
	}

//	public int findCount(PageProperty pp) {
//		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
//				"get" + poClassName + "Count", pp.getParamMap());
//		
//		return count.intValue();
//	}

//	public List<T> findPageList(PageProperty pp) {
//		return this.getSqlMapClientTemplate().queryForList(
//				"listSplit" + poClassName, pp.getParamMap());
//
//	}

	public List<T> list(Map param) {
		return this.getSqlMapClientTemplate().queryForList(
				"list" + poClassName, param);
	}

	public int deleteList(String id) {
		Map param = new HashMap();
		param.put("id", id);
		param.put("flag", Constants.STATUS_DELETED);
		return this.getSqlMapClientTemplate().update(
				"deleteList" + poClassName, param);
	}

	public int deleteGroup(Map param) {
		return this.getSqlMapClientTemplate().update(
				"deleteGroup" + poClassName, param);
	}


	public int findCount(PageProperty pp) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<T> findPageList(PageProperty pp) {
		// TODO Auto-generated method stub
		return null;
	}
}
