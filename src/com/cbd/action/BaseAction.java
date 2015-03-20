package com.cbd.action;
/**
任务：1. 将action的跳转搞掂
任务:1. 将action的跳转搞掂
*/


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport implements SessionAware,ServletResponseAware,ServletRequestAware{
	protected Map<String ,Object> session;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}



	
	

}
