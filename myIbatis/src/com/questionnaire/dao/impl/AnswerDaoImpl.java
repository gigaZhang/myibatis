package com.questionnaire.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.questionnaire.dao.IAnswerDao;
import com.questionnaire.entity.Answer;
import com.questionnaire.entity.Indagate;

public class AnswerDaoImpl  extends EntityDaoImpl<Answer> implements IAnswerDao{


	public Answer saveAnswer(Answer answer) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Q_saveAnswer", answer);
		Map map = new HashMap();
		map.put("rows", " * ");
		map.put("search", " ans_id = (select max(ans_id) from tb_answer) ");
		return (Answer)getSqlMapClientTemplate().queryForList("Q_getAnswerList",map).get(0);
	}

	public List getAnswerList(Map map) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Q_getAnswerList", map);
	}


	public boolean deleteAnswer(Map map) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Q_deleteAnswer", map);
		return true;
	}

}
