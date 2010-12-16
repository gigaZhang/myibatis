package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;

public interface IIndagateDao extends EntityDao<Indagate>{
	
	/*
	 * ��ȡ�ʾ��б�
	 */
	public List getIndagateList(Map map);	

	/*
	 * �����ʾ����
	 */
	public Indagate saveIndagate(Indagate indagate);
	
	/*
	 * ɾ���ʾ�
	 */
	public boolean deleteIndagate(Map map);	

}
