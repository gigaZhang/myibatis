package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.common.domain.UserVo;
import com.common.param.UserParam;
import com.common.query.QueryResult;
import com.system.dao.SystemDao;

/**
 * 系统管理dao实现类
 * 
 * @author lph
 */
@SuppressWarnings("unchecked")
@Repository("sysDao")
public class SystemDaoImpl implements SystemDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Resource
	private JdbcTemplate hope_db;

	/**
	 * 用户列表
	 * 
	 * @param param
	 * @return
	 */
	public QueryResult<UserVo> queryUser(UserParam param) {
		if (param == null) {
			logger.info("*************系统用户查询条件参数 UserParam 为空！");
			return null;
		}
		QueryResult<UserVo> result = new QueryResult<UserVo>();
		StringBuffer sqlCount = new StringBuffer();
		sqlCount.append("select count(*) from sys_user");
		logger.info("**********系统用户总数查询sql:" + sqlCount.toString());
		int total = this.hope_db.queryForInt(sqlCount.toString());
	
		if (total > 0) {
			result.setTotal(total);
			StringBuffer sql = new StringBuffer();
			// sql.append(" select top "+param.getOffset()+" * from sys_user ");
			// sql.append(" where id not in (select top "+param.getStart()+" id from sys_user order by id) ");
			// sql.append(" order by id");
			sql.append("SELECT * FROM sys_user LIMIT " + param.getStart()
			
			+ "," + param.getOffset());
			logger.info("**********系统用户查询sql:" + sql.toString());
			List<UserVo> list = this.hope_db.query(sql.toString(), new RowMapper() {
				public Object mapRow(ResultSet rs, int arg1) throws SQLException {
					UserVo vo = new UserVo();
					vo.setId(rs.getInt("id"));
					vo.setPassword(rs.getString("password"));
					vo.setUserName(rs.getString("user_name"));
					vo.setRealName(rs.getString("real_name"));
					return vo;
				}
			});
			result.setResult(list);
		}
		return result;
	}
}
