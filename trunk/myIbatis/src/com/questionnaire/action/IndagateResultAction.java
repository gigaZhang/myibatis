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
	 * 保存调查结果
	 * 第一步，将问卷调查结果的一些固定信息保存到tb_indagate_result,如开始进行调查的时间，结束时间，用时，调查对象（即该用户）等,
	 * 并且将保存的 问卷调查结果 返回。
	 * 第二步,分为两类：
	 * 一类是文本类型，文本类型在创建时，并没有保存选项，而在用户参加调查时，是需要填写文本类型字段的，
	 * 这时就将用户填写的内容和该问题的ID保存到选项表中，然后再将返回的ansID保存到tb_indagate_result_r中。
	 * 另一类就是其他类型，在创建时已经给了值，用户在参加调查时，不用输入，只进行选择。这时候直接可以获得各个选项的ID，
	 * 将选项的ID，连同其问题的ID保存到tb_indagate_result_r中。
	 */
	public String saveIndagateReuslt(){
		this.setIndagateResult_no();
		//保存问卷结果，并且返回保存的对象
		IndagateResult getIndar = indagateResultDao.saveIndagateResult(indagateResult);
		for(int i = 0; i < indagateResult.getRqueslist().size(); i++){
			Question rquestion = indagateResult.getRqueslist().get(i);
			if(null != rquestion){
				if(2 == rquestion.getQuest_id()){//判断是否是文本类型的，如果是，选项只有一个，即用户填写的答案
					IndagateResultR indagateResultR = new IndagateResultR();
					
					Answer ansGet = rquestion.getAnsList().get(0);
					ansGet.setQues_id(rquestion.getQues_id());
					
					//将indar_id,问卷调查结果ID放入indagateResultR中
					indagateResultR.setIndar_id(getIndar.getIndar_id());
					//将ques_id,问问题ID放入indagateResultR中
					indagateResultR.setQues_id(rquestion.getQues_id());
					//将答案插入表中，并且返回对象，通过对象获得ans_id,然后再赋给indagateResultR中的ans_id
					indagateResultR.setAns_id(answerDao.saveAnswer(ansGet).getAns_id());
					//保存
					indagateResultRDao.saveIndagateResultR(indagateResultR);
					
				}else{
					for(int j = 0; j< rquestion.getAnsArray().length; j++){
						
						IndagateResultR indagateResultR = new IndagateResultR();
						//将indar_id,问卷调查结果ID放入indagateResultR中
						indagateResultR.setIndar_id(getIndar.getIndar_id());
						//将ques_id,问题ID放入indagateResultR中
						indagateResultR.setQues_id(rquestion.getQues_id());
						//将ans_id,答案ID放入indagateResultR中
						indagateResultR.setAns_id(rquestion.getAnsArray()[j]);
						
						//保存
						indagateResultRDao.saveIndagateResultR(indagateResultR);
					}	
				}
			}
		}
		resultStr = this.getInda_ResultList();
		return resultStr;
	}
	
	/*
	 * 根据问卷获得问卷结果列表
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
	 * 获得问卷结果的详细信息。
	 */
	public String getInda_ResultDetail(){
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " inda_id in (select inda_id from tb_indagate_result where indar_id="+indagateResult.getIndar_id()+")";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);	
		// 根据ID获得问卷调查
		Indagate indaInfo = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
		whereStr = " inda_id in (select inda_id from tb_indagate_result where indar_id="+indagateResult.getIndar_id()+")";
		paramMap.put("search", whereStr);
		//根据问卷调查ID获得问题
		List quesList = questionDao.getQuestionList(paramMap);	
		List<Question> quesInfoList = new ArrayList<Question>();
		for(int i = 0; i<quesList.size(); i++){
			Question quesInfo = (Question)quesList.get(i);
			whereStr = " ques_id=" + quesInfo.getQues_id();
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
		whereStr = " indar_id="+indagateResult.getIndar_id();
		paramMap.put("search", whereStr);
		
		//根据问卷调查ID获得问题
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
		//将问卷放入request
		System.out.println();
		getRequest().setAttribute("getIndagaterrList", getIndagaterrList);
		getRequest().setAttribute("indaInfo", indaInfo);
		resultStr = "Indagate_Detail_page";
		return resultStr; 
		
	}
	
	/*
	 * 设置新增问卷的编号
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
	 * 删除问卷调查结果
	 */
	public String deleteIndagateResult(){
		Map paramMap = new HashMap();
		String whereStr = "";
		/*
		 * 删除问卷调查结果关系表中的数据
		 */
		whereStr = " indar_id =" + indagateResult.getIndar_id();
		paramMap.put("search", whereStr);	
		indagateResultRDao.deleteIndagateResultR(paramMap);
		
		/*
		 * 删除问卷调查结果表中的数据
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
