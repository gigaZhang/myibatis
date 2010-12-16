package com.questionnaire.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.dao.impl.EntityDaoImpl;
import com.questionnaire.dao.IQuestionDao;
import com.questionnaire.entity.Question;

public class QuestionDaoImpl extends EntityDaoImpl<Question> implements IQuestionDao{

	/*
	 * 获取问题列表(non-Javadoc)
	 * @see com.questionnaire.dao.IQuestionDao#getQuestionList(java.util.Map)
	 */
	public List getQuestionList(Map map) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Q_getQuestionList", map);
	}

	/*
	 * 保存问题(non-Javadoc)
	 * @see com.questionnaire.dao.IQuestionDao#saveQuestion(java.util.Map)
	 */
	public Question saveQuestion(Question question) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Q_saveQuestion", question);
		Map map = new HashMap();
		map.put("rows", " * ");
		map.put("search", " ques_id = (select max(ques_id) from tb_question) ");
		return (Question)getSqlMapClientTemplate().queryForList("Q_getQuestionList",map).get(0);
	}

	/*
	 * 删除问题(non-Javadoc)
	 * @see com.questionnaire.dao.IQuestionDao#deleteQuestion(java.util.Map)
	 */
	public boolean deleteQuestion(Map map) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Q_deleteQuestion", map);
		return true;
	}

}
