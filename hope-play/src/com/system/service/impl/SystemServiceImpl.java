package com.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.domain.UserVo;
import com.common.param.UserParam;
import com.common.query.QueryResult;
import com.system.dao.SystemDao;
import com.system.service.SystemService;


/**
 * 系统管理service实现类
 * @author lph
 *
 */
@Service("sysService")
public class SystemServiceImpl implements SystemService{

	@Resource
	private SystemDao sysDao;
	
	/**
	 *	用户列表 
	 * @param param
	 * @return 
	 */
	public QueryResult<UserVo> queryUser(UserParam param) throws Exception{
		return sysDao.queryUser(param);
	}
}
