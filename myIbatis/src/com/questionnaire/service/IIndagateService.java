package com.questionnaire.service;

import com.framework.service.BaseService;
import com.questionnaire.entity.Indagate;

public interface IIndagateService extends BaseService<Indagate>{

	/*
	 * 保存问卷调查
	 */
	public Indagate saveIndagate();
}
