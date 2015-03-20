package com.cbd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cbd.dao.UserDao;
import com.cbd.model.User;
import com.cbd.utils.EncodeUtil;
import com.cbd.utils.HibernateAnnotationUtil;

public class UserDaoImpl implements UserDao{
	
	private Session session;
	public UserDaoImpl(){
		session=HibernateAnnotationUtil.getSession();
	}
	//获取用户列表
	public List<User> getUserList(List<Integer> userIdList) {
		User user=null;
		List<User> userList=new ArrayList<User>();
		for(int id:userIdList){
			user=getUser(id);
			userList.add(user);
		}
		return userList;
	}

	public Object getUserPhoto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//由id获取用户
	public User getUser(int id) {
		session = HibernateAnnotationUtil.getSession();
		String hql = "from User where id='"+id+"'";
		User user = (User)session.createQuery(hql).uniqueResult();
		return user;
	}
	public User getUser(String name) {
		session = HibernateAnnotationUtil.getSession();
		String hql = "from User where name='"+name+"'";
		User user = (User)session.createQuery(hql).uniqueResult();
		return user;
	}
	//增加用户
	public void addUser(User user) {
		session=HibernateAnnotationUtil.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	//更新用户名
	public void changeUserName(int id, String name) {
		Session session = HibernateAnnotationUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update User u set u.name = :newName where u.id = :id";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "newName", name )
		        .setInteger( "id", id )
		        .executeUpdate();
		tx.commit();
		session.close();
	}
	public void updateUserH_id(int id,String h_id){
		Session session = HibernateAnnotationUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update User u set u.h_id = :newh_id where u.id = :id";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "newh_id", h_id )
		        .setInteger( "id", id )
		        .executeUpdate();
		tx.commit();
		session.close();
	}
	public String getUserPhotoPath(int id) {
		session = HibernateAnnotationUtil.getSession();
		String hql = "select photoPath from User where id='"+id+"'";
		String photoPath = (String)session.createQuery(hql).uniqueResult();
		return photoPath;
	}
	public void changeUserPhoto(int id, String photoPath) {
		Session session = HibernateAnnotationUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update User u set u.photoPath = :newPath where u.id = :id";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "newPath", photoPath )
		        .setInteger( "id", id )
		        .executeUpdate();
		tx.commit();
		session.close();
	}
	public User checkUser(String name, String password) {
		User user=getUser(name);
		if(!user.equals(null)){
			String encodePassword=EncodeUtil.encodeByMD5(password);
			if(user.getPassword().equals(encodePassword))
				return user;
		}
		return null;
	}
	
}
