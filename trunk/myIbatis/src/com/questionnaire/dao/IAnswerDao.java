package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Answer;
import com.questionnaire.entity.Indagate;

public interface IAnswerDao extends EntityDao<Answer>{

	/*
	 * 保存选项
	 */
	public Answer saveAnswer(Answer answer);
	
	/*
	 * 获取问题列表
	 */
	public List getAnswerList(Map map);	
	
	/*
	 * 删除问题
	 */
	public boolean deleteAnswer(Map map);	


}
