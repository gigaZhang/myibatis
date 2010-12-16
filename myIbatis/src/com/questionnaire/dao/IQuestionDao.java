package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.Question;

public interface IQuestionDao extends EntityDao<Question>{
	
	/*
	 * ��ȡ�����б�
	 */
	public List getQuestionList(Map map);	

	/*
	 * ��������
	 */
	public Question saveQuestion(Question question);
	

	/*
	 *  ɾ������
	 */
	public boolean deleteQuestion(Map map);
}