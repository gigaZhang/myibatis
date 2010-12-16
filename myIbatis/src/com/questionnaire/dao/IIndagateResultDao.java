package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.IndagateResult;

public interface IIndagateResultDao extends EntityDao<IndagateResult>{
	
	/*
	 * �����ʾ������
	 */
	public IndagateResult saveIndagateResult(IndagateResult indagateResult);
	
	/*
	 * ��ȡ�ʾ��б�
	 */
	public List getIndagateResultList(Map map);	

	/*
	 * ɾ���ʾ������
	 */
	public boolean deleteIndagateResult(Map map);	
}
