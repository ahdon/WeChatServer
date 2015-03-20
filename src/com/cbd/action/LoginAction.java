package com.cbd.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.security.provider.MD5;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cbd.dao.UserDao;
import com.cbd.dao.impl.UserDaoImpl;
import com.cbd.model.User;
import com.cbd.utils.EncodeUtil;
import com.easemob.server.example.comm.Constants;
import com.easemob.server.example.comm.HTTPMethod;
import com.easemob.server.example.comm.Roles;
//import com.easemob.server.example.httpclient.apidemo.EasemobIMUsers;
import com.easemob.server.example.httpclient.utils.HTTPClientUtils;
import com.easemob.server.example.httpclient.vo.ClientSecretCredential;
import com.easemob.server.example.httpclient.vo.Credential;
import com.easemob.server.example.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	
	private String name;
	private String password;

	private Map session;
	private UserDao userDaoimpl=new UserDaoImpl();
	
    
    
	public LoginAction() {
		
	}
	
	public void Login() throws IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(name+"ssssssssssssssssssssssssssss");
		User user = userDaoimpl.checkUser(name, password);
		JSONObject jsonObject=JSONObject.fromObject(user);
		
    	out.println(jsonObject);
		out.flush();
		out.close();
	}

	public String execute() {
		return SUCCESS;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
