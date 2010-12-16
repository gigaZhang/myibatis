package com.questionnaire.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.tool.BeanLocator;
import com.questionnaire.dao.IAnswerDao;
import com.questionnaire.dao.IIndagateDao;
import com.questionnaire.dao.IIndagateResultDao;
import com.questionnaire.dao.IIndagateResultRDao;
import com.questionnaire.dao.IQuestionDao;
import com.questionnaire.dao.impl.AnswerDaoImpl;
import com.questionnaire.dao.impl.QuestionDaoImpl;
import com.questionnaire.entity.Answer;
import com.questionnaire.entity.Indagate;
import com.questionnaire.entity.Question;


public class IndagateAction extends BaseAction{
	
	private Indagate indagate = new Indagate();
	
	IIndagateDao indagateDao = (IIndagateDao) BeanLocator.getBean("indagateDao");
	IQuestionDao questionDao = (QuestionDaoImpl) BeanLocator.getBean("questionDao");
	IAnswerDao answerDao = (AnswerDaoImpl) BeanLocator.getBean("answerDao");
	IIndagateResultRDao indagateResultRDao = (IIndagateResultRDao) BeanLocator.getBean("indagateResultRDao");
	IIndagateResultDao indagateResultDao = (IIndagateResultDao) BeanLocator.getBean("indagateResultDao");
	String resultStr = "";
	private List<Question> queslist = new ArrayList<Question>();
	
	/*
	 * ���indagate�б�
	 */
	public String getIndagateList(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " 1=1 ";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		List indagateList = indagateDao.getIndagateList(paramMap);
		getRequest().setAttribute("indagateList", indagateList);
		resultStr = "getList_Success";
		return resultStr; 
	}
	
	/*
	 * ���������ʾ�ı��
	 */
	public void setIndagate_no(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id in (select max(inda_id) from tb_indagate)";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);
		Indagate indano = new Indagate();
		if(null != indagateDao.getIndagateList(paramMap) && 0 != indagateDao.getIndagateList(paramMap).size()){
			indano = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
		}
		if(null == indano)
			indagate.setInda_no("INDA_1000");
		else
			indagate.setInda_no("INDA_"+(indano.getInda_id()+1001));
		
	}
	/*
	 * �����ʾ�����Լ�����Ͷ�Ӧ�Ĵ�
	 */
	public String saveIndagate(){
		this.setIndagate_no();//����Ҫ����� �ʾ���� �ı��
		//���ʾ������Ϣ����
		Indagate indaGet = indagateDao.saveIndagate(indagate);
		for(int i = 0; i < queslist.size(); i++){
			if(null != queslist.get(i)){
				Question quesSave = queslist.get(i);
				quesSave.setInda_id(indaGet.getInda_id());//����Ҫ����������е��ֶ�  inda_id
				//�������⣬������������ⷵ��
				Question quesGet = questionDao.saveQuestion(quesSave);
				for(int j = 0; j < queslist.get(i).getAnsList().size(); j++){
					if(null != queslist.get(i).getAnsList().get(j)){
						Answer ansSave = (Answer)queslist.get(i).getAnsList().get(j);
						ansSave.setQues_id(quesGet.getQues_id());//����Ҫ����Ĵ��е��ֶ�  ques_id
						//�����
						answerDao.saveAnswer(ansSave);
					}
				}
			}
		}
		return "save_success";
	}

	/*
	 * ��ȡ�ʾ������ϸ��Ϣ�����������͵�ҳ��
	 */
	public String getIndagateInfo() {
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id= '" + indagate.getInda_id() + "' ";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		// ����ID����ʾ����
		Indagate indaInfo = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
		
		whereStr = " inda_id= '" + indagate.getInda_id() + "' ";
		paramMap.put("search", whereStr);
		//�����ʾ����ID�������
		List quesList = questionDao.getQuestionList(paramMap);	
		List<Question> quesInfoList = new ArrayList<Question>();
		for(int i = 0; i<quesList.size(); i++){
			Question quesInfo = (Question)quesList.get(i);
			whereStr = " ques_id= '" + quesInfo.getQues_id() + "' ";
			paramMap.put("search", whereStr);	
			//��������ID��ô�
			List ansInfoList = answerDao.getAnswerList(paramMap);
			//����õĴ�list�����Ӧ��������
			quesInfo.setAnsList(ansInfoList);
			//�������������list
			quesInfoList.add(quesInfo);
		}
		//������list�����ʾ�
		indaInfo.setQueslist(quesInfoList);
		
		//���ʾ����request
		getRequest().setAttribute("indaInfo", indaInfo);
		resultStr = "Indagate_page";
		return resultStr; 
	}
	
	/*
	 * ɾ���ʾ�
	 */
	public String deleteIndagateInfo() {
		Map paramMap = new HashMap();
		/*
		 * ɾ���ʾ��������ϵ���е�����
		 */
		String whereStr = " indar_id in (select indar_id from tb_indagate_result where inda_id="+indagate.getInda_id()+")";
		paramMap.put("search", whereStr);	
		indagateResultRDao.deleteIndagateResultR(paramMap);
		
		/*
		 * ɾ���ʾ���������е�����
		 */
		whereStr = " inda_id ="+indagate.getInda_id();
		paramMap.put("search", whereStr);	
		indagateResultDao.deleteIndagateResult(paramMap);
		
		/*
		 * ɾ���𰸱��е�����
		 */
		whereStr = " ques_id in (select ques_id from tb_question where inda_id="+indagate.getInda_id()+") ";
		paramMap.put("search", whereStr);	
		answerDao.deleteAnswer(paramMap);
		
		/*
		 * ɾ������
		 */
		whereStr = " inda_id = " + indagate.getInda_id();
		paramMap.put("search", whereStr);	
		questionDao.deleteQuestion(paramMap);
		
		/*
		 * ɾ���ʾ����
		 */
		whereStr = " inda_id = " + indagate.getInda_id();
		paramMap.put("search", whereStr);	
		indagateDao.deleteIndagate(paramMap);
		
		resultStr = "save_success";
		return resultStr; 
	}

	public void setIndagate(Indagate indagate) {
		this.indagate = indagate;
	}


	public List getQueslist() {
		return queslist;
	}

	public void setQueslist(List queslist) {
		this.queslist.clear();
		this.queslist.addAll(queslist);  
	}


	public Indagate getIndagate() {
		return indagate;
	}
	
}
