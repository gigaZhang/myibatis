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
	 * 获得indagate列表
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
	 * 设置新增问卷的编号
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
	 * 保存问卷调查以及问题和对应的答案
	 */
	public String saveIndagate(){
		this.setIndagate_no();//设置要保存的 问卷调查 的编号
		//将问卷调查信息保存
		Indagate indaGet = indagateDao.saveIndagate(indagate);
		for(int i = 0; i < queslist.size(); i++){
			if(null != queslist.get(i)){
				Question quesSave = queslist.get(i);
				quesSave.setInda_id(indaGet.getInda_id());//设置要保存的问题中的字段  inda_id
				//保存问题，并将保存的问题返回
				Question quesGet = questionDao.saveQuestion(quesSave);
				for(int j = 0; j < queslist.get(i).getAnsList().size(); j++){
					if(null != queslist.get(i).getAnsList().get(j)){
						Answer ansSave = (Answer)queslist.get(i).getAnsList().get(j);
						ansSave.setQues_id(quesGet.getQues_id());//设置要保存的答案中的字段  ques_id
						//保存答案
						answerDao.saveAnswer(ansSave);
					}
				}
			}
		}
		return "save_success";
	}

	/*
	 * 获取问卷调查详细信息，将数据推送到页面
	 */
	public String getIndagateInfo() {
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id= '" + indagate.getInda_id() + "' ";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		// 根据ID获得问卷调查
		Indagate indaInfo = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
		
		whereStr = " inda_id= '" + indagate.getInda_id() + "' ";
		paramMap.put("search", whereStr);
		//根据问卷调查ID获得问题
		List quesList = questionDao.getQuestionList(paramMap);	
		List<Question> quesInfoList = new ArrayList<Question>();
		for(int i = 0; i<quesList.size(); i++){
			Question quesInfo = (Question)quesList.get(i);
			whereStr = " ques_id= '" + quesInfo.getQues_id() + "' ";
			paramMap.put("search", whereStr);	
			//根据问题ID获得答案
			List ansInfoList = answerDao.getAnswerList(paramMap);
			//将获得的答案list放入对应的问题中
			quesInfo.setAnsList(ansInfoList);
			//将问题放入问题list
			quesInfoList.add(quesInfo);
		}
		//将问题list放入问卷
		indaInfo.setQueslist(quesInfoList);
		
		//将问卷放入request
		getRequest().setAttribute("indaInfo", indaInfo);
		resultStr = "Indagate_page";
		return resultStr; 
	}
	
	/*
	 * 删除问卷
	 */
	public String deleteIndagateInfo() {
		Map paramMap = new HashMap();
		/*
		 * 删除问卷调查结果关系表中的数据
		 */
		String whereStr = " indar_id in (select indar_id from tb_indagate_result where inda_id="+indagate.getInda_id()+")";
		paramMap.put("search", whereStr);	
		indagateResultRDao.deleteIndagateResultR(paramMap);
		
		/*
		 * 删除问卷调查结果表中的数据
		 */
		whereStr = " inda_id ="+indagate.getInda_id();
		paramMap.put("search", whereStr);	
		indagateResultDao.deleteIndagateResult(paramMap);
		
		/*
		 * 删除答案表中的数据
		 */
		whereStr = " ques_id in (select ques_id from tb_question where inda_id="+indagate.getInda_id()+") ";
		paramMap.put("search", whereStr);	
		answerDao.deleteAnswer(paramMap);
		
		/*
		 * 删除问题
		 */
		whereStr = " inda_id = " + indagate.getInda_id();
		paramMap.put("search", whereStr);	
		questionDao.deleteQuestion(paramMap);
		
		/*
		 * 删除问卷调查
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
