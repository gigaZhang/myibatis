package com.questionnaire;

import java.util.Map;

public interface IPostIndagate {

	/**
	 * 提交调查问卷结果
	 * @param indagateResultMap 存放了问卷结果的信息，以及问卷中问题和对应答案的信息
	 * @return 
	 */
	public Integer postIndagate(Map indagateResultMap);
}
