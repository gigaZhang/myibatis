package com.questionnaire.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.questionnaire.dao.IIndagateResultDao;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.IndagateResult;

public class IndagateResultDaoImpl extends EntityDaoImpl<IndagateResult> implements IIndagateResultDao{

	/*
	 * 保存问卷调查结果，并且将保存的对象返回(non-Javadoc)
	 * @see com.questionnaire.dao.IIndagateResultDao#saveIndagate(com.questionnaire.entity.IndagateResult)
	 */
	public IndagateResult saveIndagateResult(IndagateResult indagateResult) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Q_saveIndagateResult", indagateResult);
		Map map = new HashMap();
		map.put("rows", " * ");
		map.put("search", " indar_id = (select max(indar_id) from tb_indagate_result) ");
		return (IndagateResult)getSqlMapClientTemplate().queryForList("Q_getIndagateResultList",map).get(0);
	}

	/*
	 * 获得问卷调查结果(non-Javadoc)
	 * @see com.questionnaire.dao.IIndagateResultDao#getIndagateResultList(java.util.Map)
	 */
	public List getIndagateResultList(Map map) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Q_getIndagateResultList", map);
	}

	public boolean deleteIndagateResult(Map map) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Q_deleteIndagateResult", map);
		return true;
	}

}
