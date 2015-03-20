package com.cbd.dao;

import java.util.List;

import com.cbd.model.User;

public interface FriendShipDao {
	
	List<Integer> getFriendId(int id);
	
	List<Object> getFriendPhotoList(List<Integer> firendIdList);
	
	void addFriendShip(int user_id,int friend_id);
	
	void deleteFriendShip(int user_id,int friend_id);
}
