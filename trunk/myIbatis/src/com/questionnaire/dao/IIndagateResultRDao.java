package com.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.framework.dao.EntityDao;
import com.questionnaire.entity.IndagateResult;
import com.questionnaire.entity.IndagateResultR;

public interface IIndagateResultRDao extends EntityDao<IndagateResultR>{

	/*
	 * �����ʾ������
	 */
	public boolean saveIndagateResultR(IndagateResultR indagateResultR);
	
	/*
	 * ɾ��������
	 */
	public boolean deleteIndagateResultR(Map map);
	/*
	 * ��ȡ�ʾ��б�
	 */
	public List getIndagateResultRList(Map map);	
}
