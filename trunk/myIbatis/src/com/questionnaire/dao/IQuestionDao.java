package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.Question;

public interface IQuestionDao extends EntityDao<Question>{
	
	/*
	 * 获取问题列表
	 */
	public List getQuestionList(Map map);	

	/*
	 * 保存问题
	 */
	public Question saveQuestion(Question question);
	

	/*
	 *  删除问题
	 */
	public boolean deleteQuestion(Map map);
}