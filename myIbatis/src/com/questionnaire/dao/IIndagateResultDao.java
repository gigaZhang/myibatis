package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.IndagateResult;

public interface IIndagateResultDao extends EntityDao<IndagateResult>{
	
	/*
	 * 保存问卷调查结果
	 */
	public IndagateResult saveIndagateResult(IndagateResult indagateResult);
	
	/*
	 * 获取问卷列表
	 */
	public List getIndagateResultList(Map map);	

	/*
	 * 删除问卷调查结果
	 */
	public boolean deleteIndagateResult(Map map);	
}
