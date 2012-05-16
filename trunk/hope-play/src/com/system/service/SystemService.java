package com.system.service;

import com.common.domain.UserVo;
import com.common.param.UserParam;
import com.common.query.QueryResult;

/**
 * 系统管理service
 * @author lph
 *
 */
public interface SystemService {
	
	/**
	 *	用户列表 
	 * @param param
	 * @return 
	 */
	public QueryResult<UserVo> queryUser(UserParam param) throws Exception ;
}
