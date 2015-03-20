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
public class SignAction extends BaseAction{
	
	private String name;
	private String password;

	private Map session;
	private UserDao userDaoimpl=new UserDaoImpl();
	
	private static Logger LOGGER = LoggerFactory.getLogger(SignAction.class);
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	// ͨ��app��client_id��client_secret����ȡapp����Աtoken
    private static Credential credential = new ClientSecretCredential("YXA6JAfyQMGBEeS8gsnwV2l8cw",
            "YXA6GhAY4eQ06Ndu3mwgsy1G8LgIA8I", Roles.USER_ROLE_APPADMIN);
    
    
	public SignAction() {
		
	}
	
	public void SignUp() throws IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(name+"sssssssssssssssssssssssssssssssss");
		PrintWriter out = response.getWriter();
		//�����û����������û��������룬���뵽���ݿ�
		User user = new User();
		user.setName(name);
		user.setPassword(EncodeUtil.encodeByMD5(password));
		userDaoimpl.addUser(user);
		user=userDaoimpl.getUser(name);
		
		//���ŷ�����ע��h_id
		String h_id="zyd_"+user.getId()+"_hby";
		System.out.println(h_id);
		ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username",h_id);
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        ObjectNode createNewIMUserSingleNode = createNewIMUserSingle(datanode);
        
        //ע��h_id�ɹ�
        if (null != createNewIMUserSingleNode) {
            LOGGER.info("ע��IM�û�[����]: " + createNewIMUserSingleNode.toString());
            userDaoimpl.updateUserH_id(user.getId(), h_id);
            System.out.println(h_id);
            user.setH_id(h_id);
            //������ת��json����
      		JSONObject json = JSONObject.fromObject(user);
      		//��List���ϵ�����ת��json����
      		//JSONArray jsons = JSONArray.fromObject(Products);
      		System.out.println("jsons==>"+json);
      		out.println(json);
    		out.flush();
    		out.close();
        }
        else{
        	out.println("failed");
    		out.flush();
    		out.close();
        }
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

	/**
	 * ע��IM�û�[����]
	 * 
	 * ��ָ��Constants.APPKEY����һ���µ��û�
	 * 
	 * @param dataNode
	 * @return
	 */
	public static ObjectNode createNewIMUserSingle(ObjectNode dataNode) {

		ObjectNode objectNode = factory.objectNode();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		objectNode.removeAll();

		// check properties that must be provided
		if (null != dataNode && !dataNode.has("username")) {
			LOGGER.error("Property that named username must be provided .");

			objectNode.put("message", "Property that named username must be provided .");

			return objectNode;
		}
		if (null != dataNode && !dataNode.has("password")) {
			LOGGER.error("Property that named password must be provided .");

			objectNode.put("message", "Property that named password must be provided .");

			return objectNode;
		}

		try {

		    objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, dataNode,
					HTTPMethod.METHOD_POST);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
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
