package com.questionnaire;

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

public class GetIndagateImpl implements IGetIndagate{
	static IIndagateDao indagateDao = (IIndagateDao) BeanLocator.getBean("indagateDao");
	static IQuestionDao questionDao = (QuestionDaoImpl) BeanLocator.getBean("questionDao");
	static IAnswerDao answerDao = (AnswerDaoImpl) BeanLocator.getBean("answerDao");
	static IIndagateResultRDao indagateResultRDao = (IIndagateResultRDao) BeanLocator.getBean("indagateResultRDao");
	static IIndagateResultDao indagateResultDao = (IIndagateResultDao) BeanLocator.getBean("indagateResultDao");
	
	public  Map  getIndagate(Integer inda_id){
		Map returnMap = new HashMap();
		
		 
		/*
		 * 获取问卷调查详细信息，将数据推送到页面
		 */
			Map paramMap = new HashMap();
			String rowStr = " * ";
			String whereStr = " inda_id= '" + inda_id + "' ";
			paramMap.put("rows", rowStr);
			paramMap.put("search", whereStr);	
			// 根据ID获得问卷调查
			Indagate indaInfo = (Indagate)indagateDao.getIndagateList(paramMap).get(0);
			whereStr = " inda_id= '" + inda_id + "' ";
			paramMap.put("search", whereStr);
			//根据问卷调查ID获得问题
			List quesList = questionDao.getQuestionList(paramMap);
			List quesInfoList = new ArrayList();
			for(int i = 0; i<quesList.size(); i++){
				Question quesInfo = (Question)quesList.get(i);
				whereStr = " ques_id= '" + quesInfo.getQues_id() + "' ";
				paramMap.put("search", whereStr);	
				//根据问题ID获得答案
				List ansInfoList = answerDao.getAnswerList(paramMap);
				List putAnsList = new ArrayList();
				for(int j = 0; j < ansInfoList.size(); j++){
					Answer answer = (Answer)ansInfoList.get(j);
					Map ansMap = new HashMap();
					ansMap.put("ans_id", answer.getAns_id());
					ansMap.put("ques_id", answer.getQues_id());
					ansMap.put("ans_value", answer.getAns_value());
					ansMap.put("ans_content", answer.getAns_content());
					ansMap.put("ans_description", answer.getAns_description());
					putAnsList.add(ansMap);
				}
				Map quesMap = new HashMap();
				quesMap.put("ques_id", quesInfo.getQues_id());
				quesMap.put("inda_id", quesInfo.getInda_id());
				quesMap.put("quest_id", quesInfo.getQuest_id());
				quesMap.put("ques_no", quesInfo.getQues_no());
				quesMap.put("ques_content", quesInfo.getQues_content());
				quesMap.put("ques_description", quesInfo.getQues_description());
				quesMap.put("ansList", putAnsList);
				quesInfoList.add(quesMap);
			}
			//将问题list放入问卷
			//indaInfo.setQueslist(quesInfoList);
			//将问卷放入request
			returnMap.put("quesInfoList", quesInfoList);
			returnMap.put("inda_id", indaInfo.getInda_id());
			returnMap.put("inda_person", indaInfo.getInda_person());
			returnMap.put("inda_title", indaInfo.getInda_title());
			returnMap.put("inda_theme", indaInfo.getInda_theme());
			returnMap.put("inda_start_time", indaInfo.getInda_start_time());
			returnMap.put("inda_end_time", indaInfo.getInda_end_time());
			returnMap.put("channel", indaInfo.getChannelId());
			return returnMap;
	}
	
	
}
