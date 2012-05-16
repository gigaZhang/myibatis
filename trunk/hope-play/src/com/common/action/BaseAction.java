package com.common.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 公用aciton（权限控制,日志记录）
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 请求action连接
	 */
	public String basePath;
	protected HttpServletRequest request = ServletActionContext.getRequest();
	

	
	
	public boolean writelog(){
		logger.info("记录日志成功");
		return true;
	}
	public boolean checkRight(){
		logger.info("权限检测");
		return true;
	}

	
	public HttpServletRequest getRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();
		basePath = request.getContextPath();
		return request;
	}
}
