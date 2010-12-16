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

		// �����ʾ��������ҷ��ر���Ķ���
		IndagateResult getIndar = indagateResultDao
				.saveIndagateResult(indagateResult);

		List<Map> quesList = (List) indagateResultMap.get("quesList");
		if (null != quesList && 0 != quesList.size()) {
			for (int i = 0; i < quesList.size(); i++) {
				Map quesMap = quesList.get(i);
				if (null != quesMap) {
					// �ж��Ƿ����ı����͵ģ�����ǣ�ѡ��ֻ��һ�������û���д�Ĵ�
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

						// ��indar_id,�ʾ������ID����indagateResultR��
						indagateResultR.setIndar_id(getIndar.getIndar_id());
						// ��ques_id,������ID����indagateResultR��
						indagateResultR.setQues_id(Integer.parseInt(quesMap
								.get("ques_id").toString()));
						// ���𰸲�����У����ҷ��ض���ͨ��������ans_id,Ȼ���ٸ���indagateResultR�е�ans_id
						indagateResultR.setAns_id(answerDao.saveAnswer(answer)
								.getAns_id());
						// ����
						indagateResultRDao.saveIndagateResultR(indagateResultR);

					} else {
						List<Map> ansList = (List<Map>) quesMap.get("ansList");
						if (null != ansList && 0 != ansList.size()) {
							for (int j = 0; j < ansList.size(); j++) {
								Map ansMap = ansList.get(j);
								IndagateResultR indagateResultR = new IndagateResultR();
								// ��indar_id,�ʾ������ID����indagateResultR��
								indagateResultR.setIndar_id(getIndar
										.getIndar_id());
								// ��ques_id,����ID����indagateResultR��
								indagateResultR.setQues_id(Integer
										.parseInt(quesMap.get("ques_id")
												.toString()));
								// ��ans_id,��ID����indagateResultR��
								indagateResultR.setAns_id(Integer
										.parseInt(ansMap.get("ans_id")
												.toString()));

								// ����
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
	 * ���������ʾ�ı��
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
