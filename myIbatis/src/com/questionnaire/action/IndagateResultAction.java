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
import com.questionnaire.entity.IndagateResult;
import com.questionnaire.entity.IndagateResultR;
import com.questionnaire.entity.Question;

public class IndagateResultAction extends BaseAction{
	
	private IndagateResult indagateResult = new IndagateResult();
	private Indagate indagate = new Indagate();
	
	IAnswerDao answerDao = (AnswerDaoImpl) BeanLocator.getBean("answerDao");
	IIndagateResultDao indagateResultDao = (IIndagateResultDao) BeanLocator.getBean("indagateResultDao");
	IIndagateResultRDao indagateResultRDao = (IIndagateResultRDao) BeanLocator.getBean("indagateResultRDao");
	IIndagateDao indagateDao = (IIndagateDao) BeanLocator.getBean("indagateDao");
	IQuestionDao questionDao = (QuestionDaoImpl) BeanLocator.getBean("questionDao");
	
	String resultStr = "";
	
	
	/*
	 * ���������
	 * ��һ�������ʾ��������һЩ�̶���Ϣ���浽tb_indagate_result,�翪ʼ���е����ʱ�䣬����ʱ�䣬��ʱ��������󣨼����û�����,
	 * ���ҽ������ �ʾ������ ���ء�
	 * �ڶ���,��Ϊ���ࣺ
	 * һ�����ı����ͣ��ı������ڴ���ʱ����û�б���ѡ������û��μӵ���ʱ������Ҫ��д�ı������ֶεģ�
	 * ��ʱ�ͽ��û���д�����ݺ͸������ID���浽ѡ����У�Ȼ���ٽ����ص�ansID���浽tb_indagate_result_r�С�
	 * ��һ������������ͣ��ڴ���ʱ�Ѿ�����ֵ���û��ڲμӵ���ʱ���������룬ֻ����ѡ����ʱ��ֱ�ӿ��Ի�ø���ѡ���ID��
	 * ��ѡ���ID����ͬ�������ID���浽tb_indagate_result_r�С�
	 */
	public String saveIndagateReuslt(){
		this.setIndagateResult_no();
		//�����ʾ��������ҷ��ر���Ķ���
		IndagateResult getIndar = indagateResultDao.saveIndagateResult(indagateResult);
		for(int i = 0; i < indagateResult.getRqueslist().size(); i++){
			Question rquestion = indagateResult.getRqueslist().get(i);
			if(null != rquestion){
				if(2 == rquestion.getQuest_id()){//�ж��Ƿ����ı����͵ģ�����ǣ�ѡ��ֻ��һ�������û���д�Ĵ�
					IndagateResultR indagateResultR = new IndagateResultR();
					
					Answer ansGet = rquestion.getAnsList().get(0);
					ansGet.setQues_id(rquestion.getQues_id());
					
					//��indar_id,�ʾ������ID����indagateResultR��
					indagateResultR.setIndar_id(getIndar.getIndar_id());
					//��ques_id,������ID����indagateResultR��
					indagateResultR.setQues_id(rquestion.getQues_id());
					//���𰸲�����У����ҷ��ض���ͨ��������ans_id,Ȼ���ٸ���indagateResultR�е�ans_id
					indagateResultR.setAns_id(answerDao.saveAnswer(ansGet).getAns_id());
					//����
					indagateResultRDao.saveIndagateResultR(indagateResultR);
					
				}else{
					for(int j = 0; j< rquestion.getAnsArray().length; j++){
						
						IndagateResultR indagateResultR = new IndagateResultR();
						//��indar_id,�ʾ������ID����indagateResultR��
						indagateResultR.setIndar_id(getIndar.getIndar_id());
						//��ques_id,����ID����indagateResultR��
						indagateResultR.setQues_id(rquestion.getQues_id());
						//��ans_id,��ID����indagateResultR��
						indagateResultR.setAns_id(rquestion.getAnsArray()[j]);
						
						//����
						indagateResultRDao.saveIndagateResultR(indagateResultR);
					}	
				}
			}
		}
		resultStr = this.getInda_ResultList();
		return resultStr;
	}
	
	/*
	 * �����ʾ����ʾ����б�
	 */
	public String getInda_ResultList(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id =" + indagateResult.getInda_id();
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		List inda_ResultList = indagateResultDao.getIndagateResultList(paramMap);
		getRequest().setAttribute("inda_ResultList", inda_ResultList);
		
		resultStr = "getList_Success";
		return resultStr; 
	}
	/*
	 * ����ʾ�������ϸ��Ϣ��
	 */
	public String getInda_ResultDetail(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id in (select inda_id from tb_indagate_result where indar_id="+indagateResult.getIndar_id()+")";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		// ����ID����ʾ����
		Indagate indaInfo = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
		whereStr = " inda_id in (select inda_id from tb_indagate_result where indar_id="+indagateResult.getIndar_id()+")";
		paramMap.put("search", whereStr);
		//�����ʾ����ID�������
		List quesList = questionDao.getQuestionList(paramMap);	
		List<Question> quesInfoList = new ArrayList<Question>();
		for(int i = 0; i<quesList.size(); i++){
			Question quesInfo = (Question)quesList.get(i);
			whereStr = " ques_id=" + quesInfo.getQues_id();
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
		whereStr = " indar_id="+indagateResult.getIndar_id();
		paramMap.put("search", whereStr);
		
		//�����ʾ����ID�������
		List indagaterrList = indagateResultRDao.getIndagateResultRList(paramMap);
		List getIndagaterrList = new ArrayList();
		
		for(int i = 0;i<indagaterrList.size();i++){
			IndagateResultR resultR = new IndagateResultR();
			whereStr = " ans_id="+((IndagateResultR)indagaterrList.get(i)).getAns_id();
			paramMap.put("search", whereStr);
			paramMap.put("join", whereStr);
			resultR = (IndagateResultR)indagaterrList.get(i);
			resultR.setAnswer((Answer)answerDao.getAnswerList(paramMap).get(0));
			getIndagaterrList.add(resultR);
		}
		//���ʾ����request
		System.out.println();
		getRequest().setAttribute("getIndagaterrList", getIndagaterrList);
		getRequest().setAttribute("indaInfo", indaInfo);
		resultStr = "Indagate_Detail_page";
		return resultStr; 
		
	}
	
	/*
	 * ���������ʾ�ı��
	 */
	public void setIndagateResult_no(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " indar_id in (select max(indar_id) from tb_indagate_result)";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);
		IndagateResult indanoResult = new IndagateResult();
		if(null != indagateResultDao.getIndagateResultList(paramMap) && 0 != indagateResultDao.getIndagateResultList(paramMap).size()){
			indanoResult = (IndagateResult)indagateResultDao.getIndagateResultList(paramMap).get(0);
		}
		if(null == indanoResult)
			indagateResult.setIndar_no("INDAR_"+indanoResult.getInda_id()+"_1000");
		else
			indagateResult.setIndar_no("INDAR_"+indanoResult.getInda_id()+"_"+(indanoResult.getIndar_id()+1001));
		
	}
	
	/*
	 * ɾ���ʾ������
	 */
	public String deleteIndagateResult(){
		Map paramMap = new HashMap();
		String whereStr = "";
		/*
		 * ɾ���ʾ��������ϵ���е�����
		 */
		whereStr = " indar_id =" + indagateResult.getIndar_id();
		paramMap.put("search", whereStr);	
		indagateResultRDao.deleteIndagateResultR(paramMap);
		
		/*
		 * ɾ���ʾ���������е�����
		 */
		whereStr = " indar_id ="+indagateResult.getIndar_id();
		paramMap.put("search", whereStr);	
		indagateResultDao.deleteIndagateResult(paramMap);
		return "save_success";
	}
	
	

	public IndagateResult getIndagateResult() {
		return indagateResult;
	}


	public void setIndagateResult(IndagateResult indagateResult) {
		this.indagateResult = indagateResult;
	}

	public Indagate getIndagate() {
		return indagate;
	}

	public void setIndagate(Indagate indagate) {
		this.indagate = indagate;
	}
}
