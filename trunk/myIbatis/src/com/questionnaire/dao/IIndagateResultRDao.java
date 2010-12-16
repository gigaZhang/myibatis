package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.IndagateResult;
import com.questionnaire.entity.IndagateResultR;

public interface IIndagateResultRDao extends EntityDao<IndagateResultR>{

	/*
	 * 保存问卷调查结果
	 */
	public boolean saveIndagateResultR(IndagateResultR indagateResultR);
	
	/*
	 * 删除调查结果
	 */
	public boolean deleteIndagateResultR(Map map);
	/*
	 * 获取问卷列表
	 */
	public List getIndagateResultRList(Map map);	
}
