package com.questionnaire;

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
import com.questionnaire.entity.IndagateResult;
import com.questionnaire.entity.IndagateResultR;

public class PostIndagateImpl implements IPostIndagate {

	private IndagateResult indagateResult = new IndagateResult();

	IAnswerDao answerDao = (AnswerDaoImpl) BeanLocator.getBean("answerDao");
	IIndagateResultDao indagateResultDao = (IIndagateResultDao) BeanLocator
			.getBean("indagateResultDao");
	IIndagateResultRDao indagateResultRDao = (IIndagateResultRDao) BeanLocator
			.getBean("indagateResultRDao");
	IIndagateDao indagateDao = (IIndagateDao) BeanLocator
			.getBean("indagateDao");
	IQuestionDao questionDao = (QuestionDaoImpl) BeanLocator
			.getBean("questionDao");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.questionnaire.IPostIndagate#postIndagate(java.util.Map)
	 */
	public Integer postIndagate(Map indagateResultMap) {
		// TODO Auto-generated method stub
		Integer retResult = 0;
		this.setIndagateResult_no();
		indagateResult.setIndar_person(indagateResultMap.get("indar_person")
				.toString());
		indagateResult.setIndar_start_time("2010-12-7");
		indagateResult.setIndar_end_time("2010-12-7");
		indagateResult.setInda_id(Integer.parseInt(indagateResultMap
				.get("inda_id").toString()));

		// 保存问卷结果，并且返回保存的对象
		IndagateResult getIndar = indagateResultDao
				.saveIndagateResult(indagateResult);

		List<Map> quesList = (List) indagateResultMap.get("quesList");
		if (null != quesList && 0 != quesList.size()) {
			for (int i = 0; i < quesList.size(); i++) {
				Map quesMap = quesList.get(i);
				if (null != quesMap) {
					// 判断是否是文本类型的，如果是，选项只有一个，即用户填写的答案
					if (2 == Integer.parseInt(quesMap.get("quest_id")
							.toString())) {
						IndagateResultR indagateResultR = new IndagateResultR();
						List<Map> ansList = (List<Map>) quesMap.get("ansList");
						Map ansMap = ansList.get(0);
						Answer answer = new Answer();
						answer.setAns_content(ansMap.get("ans_content")
								.toString());
						answer.setQues_id(Integer.parseInt(quesMap.get(
								"ques_id").toString()));

						// 将indar_id,问卷调查结果ID放入indagateResultR中
						indagateResultR.setIndar_id(getIndar.getIndar_id());
						// 将ques_id,问问题ID放入indagateResultR中
						indagateResultR.setQues_id(Integer.parseInt(quesMap
								.get("ques_id").toString()));
						// 将答案插入表中，并且返回对象，通过对象获得ans_id,然后再赋给indagateResultR中的ans_id
						indagateResultR.setAns_id(answerDao.saveAnswer(answer)
								.getAns_id());
						// 保存
						indagateResultRDao.saveIndagateResultR(indagateResultR);

					} else {
						List<Map> ansList = (List<Map>) quesMap.get("ansList");
						if (null != ansList && 0 != ansList.size()) {
							for (int j = 0; j < ansList.size(); j++) {
								Map ansMap = ansList.get(j);
								IndagateResultR indagateResultR = new IndagateResultR();
								// 将indar_id,问卷调查结果ID放入indagateResultR中
								indagateResultR.setIndar_id(getIndar
										.getIndar_id());
								// 将ques_id,问题ID放入indagateResultR中
								indagateResultR.setQues_id(Integer
										.parseInt(quesMap.get("ques_id")
												.toString()));
								// 将ans_id,答案ID放入indagateResultR中
								indagateResultR.setAns_id(Integer
										.parseInt(ansMap.get("ans_id")
												.toString()));

								// 保存
								indagateResultRDao
										.saveIndagateResultR(indagateResultR);
							}
						}
					}
				}
			}
		}

		return retResult;
	}

	/*
	 * 设置新增问卷的编号
	 */
	public void setIndagateResult_no() {
		Map paramMap = new HashMap();
		String rowStr = " * ";
		String whereStr = " indar_id in (select max(indar_id) from tb_indagate_result)";
		paramMap.put("rows", rowStr);
		paramMap.put("search", whereStr);
		IndagateResult indanoResult = new IndagateResult();
		if (null != indagateResultDao.getIndagateResultList(paramMap)
				&& 0 != indagateResultDao.getIndagateResultList(paramMap)
						.size()) {
			indanoResult = (IndagateResult) indagateResultDao
					.getIndagateResultList(paramMap).get(0);
		}
		if (null == indanoResult)
			indagateResult.setIndar_no("INDAR_" + indanoResult.getInda_id()
					+ "_1000");
		else
			indagateResult.setIndar_no("INDAR_" + indanoResult.getInda_id()
					+ "_" + (indanoResult.getIndar_id() + 1001));

	}

}
