package com.questionnaire;

import java.util.Map;

public interface IGetIndagate {
	/**
	 * 根据问卷ID获得问卷信息
	 * @param inda_id 问卷ID
	 * @return 返回值是问卷的信息，包括问卷上的题目和答案
	 */
	public Map  getIndagate(Integer inda_id);
}
