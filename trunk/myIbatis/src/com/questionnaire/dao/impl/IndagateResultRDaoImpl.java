package com.questionnaire.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.questionnaire.dao.IIndagateResultDao;
import com.questionnaire.dao.IIndagateResultRDao;
import com.questionnaire.entity.IndagateResult;
import com.questionnaire.entity.IndagateResultR;

public class IndagateResultRDaoImpl  extends EntityDaoImpl<IndagateResultR> implements IIndagateResultRDao{

	/*
	 * 保存问卷调查结果(non-Javadoc)
	 * @see com.questionnaire.dao.IIndagateResultDao#saveIndagate(com.questionnaire.entity.IndagateResult)
	 */
	public boolean saveIndagateResultR(IndagateResultR indagateResultR) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Q_saveIndagateResult_r", indagateResultR);
		return true;
	}

	public boolean deleteIndagateResultR(Map map) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Q_deleteIndagateResultR", map);
		return true;
	}

	public List getIndagateResultRList(Map map) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Q_getIndagateResultRList", map);
		
	}


}
