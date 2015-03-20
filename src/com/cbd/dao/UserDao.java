package com.cbd.dao;

import java.util.List;

import com.cbd.model.User;

public interface UserDao {
	
	//��¼���
	User checkUser(String name,String password);
	
	//��ȡ�û��б�
	List<User> getUserList(List<Integer> userIdList);
	
	//��ȡ�û�ͷ��·��
	String getUserPhotoPath(int id);
	
	//��ȡ�û�
	User getUser(int id);
	User getUser(String name);
	
	//�����û�����
	void addUser(User user);
	
	//�����û�h_id
	public void updateUserH_id(int id,String h_id);
	
	//�޸��û���
	void changeUserName(int id,String name);
	
	//�޸�ͷ��
	void changeUserPhoto(int id,String photoPath);
}
