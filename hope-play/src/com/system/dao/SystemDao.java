package com.system.dao;

import com.common.domain.UserVo;
import com.common.param.UserParam;
import com.common.query.QueryResult;

/**
 * 系统管理dao
 * @author lph
 *
 */
public interface SystemDao {

	/**
	 *	
	 * @param param
	 * @return 
	 */
	public QueryResult<UserVo> queryUser(UserParam param);
}
