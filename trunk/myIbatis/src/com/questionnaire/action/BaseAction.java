package com.questionnaire.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	

	/*
	 * »ñµÃsession
	 */
	public HttpSession getSession(){
		HttpServletRequest request = ServletActionContext.getRequest() ;
		return request.getSession();
	}
	public HttpServletRequest getRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
}
