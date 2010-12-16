package com.questionnaire.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.questionnaire.dao.IIndagateDao;
import com.questionnaire.entity.Indagate;

public class IndagateDaoImpl extends EntityDaoImpl<Indagate> implements IIndagateDao{

	/*
	 * 获得问卷列表(non-Javadoc)
	 * @see com.questionnaire.dao.IIndagateDao#getIndagateList()
	 */
	public List getIndagateList(Map map) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Q_getIndagateList", map);
	}

	/*
	 * 保存问卷调查(non-Javadoc)
	 * @see com.questionnaire.dao.IIndagateDao#saveIndagateList(java.util.Map)
	 */
	public Indagate saveIndagate(Indagate indagate) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Q_saveIndagate", indagate);
		Map map = new HashMap();
		map.put("rows", " * ");
		map.put("search", " inda_id = (select max(inda_id) from tb_indagate) ");
		return (Indagate)getSqlMapClientTemplate().queryForList("Q_getIndagateList",map).get(0);
	}


	public boolean deleteIndagate(Map map) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Q_deleteIndagate", map);
		return true;
	}

}
