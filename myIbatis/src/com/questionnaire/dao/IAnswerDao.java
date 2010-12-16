package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Answer;
import com.questionnaire.entity.Indagate;

public interface IAnswerDao extends EntityDao<Answer>{

	/*
	 * ����ѡ��
	 */
	public Answer saveAnswer(Answer answer);
	
	/*
	 * ��ȡ�����б�
	 */
	public List getAnswerList(Map map);	
	
	/*
	 * ɾ������
	 */
	public boolean deleteAnswer(Map map);	


}
