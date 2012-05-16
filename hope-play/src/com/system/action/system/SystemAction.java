package com.system.action.system;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
import com.common.domain.UserVo;
import com.common.page.PaginationQueryDto;
import com.common.param.UserParam;
import com.common.query.QueryResult;
import com.system.service.SystemService;

/**
 * 系统管理(用户管理、权限管理) action lph
 */
@SuppressWarnings("unused")
@Controller("system")
public class SystemAction extends BaseAction {
	private static final long serialVersionUID = 8676645302222211858L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String LIST_PAGE_USER_NAME = "userlist";
	private UserParam user = new UserParam();
	private PaginationQueryDto<UserVo> searchDto = new PaginationQueryDto<UserVo>();

	@Resource
	private SystemService sysService;

	/**
	 * 登陆
	 * 
	 * @return
	 */
	public String login() {

		return "list";
	}

	/**
	 * 用户管理 - 用户列表
	 * 
	 * @return
	 */
	public String queryUser() {
		if (null == request) {
			request = ServletActionContext.getRequest();
		}
		searchDto.init(request);

		user.setStart(searchDto.getOffset());
		user.setOffset(searchDto.getMaxRow());

		try {
			QueryResult<UserVo> qryResult = sysService.queryUser(user);
			if (qryResult != null) {
				searchDto.setResultList(qryResult.getResult());
				searchDto.setTotalRecords(Long.valueOf(qryResult.getTotal()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("_pagination", searchDto.getPagination());
		return LIST_PAGE_USER_NAME;
	}

	/**
	 * 用户增加
	 * 
	 * @return
	 */
	public String addUser() {
		return "list";
	}

	/**
	 * 用户修改
	 * 
	 * @return
	 */
	public String modifyUser() {
		return "list";
	}

	public UserParam getUser() {
		return user;
	}

	public void setUser(UserParam user) {
		this.user = user;
	}

	public PaginationQueryDto<UserVo> getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(PaginationQueryDto<UserVo> searchDto) {
		this.searchDto = searchDto;
	}

}
