package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;

public interface IIndagateDao extends EntityDao<Indagate>{
	
	/*
	 * 获取问卷列表
	 */
	public List getIndagateList(Map map);	

	/*
	 * 保存问卷调查
	 */
	public Indagate saveIndagate(Indagate indagate);
	
	/*
	 * 删除问卷
	 */
	public boolean deleteIndagate(Map map);	

}
