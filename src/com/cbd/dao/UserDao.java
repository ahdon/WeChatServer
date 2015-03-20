package com.cbd.dao;

import java.util.List;

import com.cbd.model.User;

public interface UserDao {
	
	//登录检测
	User checkUser(String name,String password);
	
	//获取用户列表
	List<User> getUserList(List<Integer> userIdList);
	
	//获取用户头像路径
	String getUserPhotoPath(int id);
	
	//获取用户
	User getUser(int id);
	User getUser(String name);
	
	//插入用户数据
	void addUser(User user);
	
	//更新用户h_id
	public void updateUserH_id(int id,String h_id);
	
	//修改用户名
	void changeUserName(int id,String name);
	
	//修改头像
	void changeUserPhoto(int id,String photoPath);
}
