package com.dream.dao;

import java.util.List;

import com.dream.vo.Page;
import com.dream.vo.User;

public interface IUserDao {
	void addUser(User user);
	List<User> showUsers(Page pg);
	User showUserByUid(int uid);
	void delUserByUid(int uid);
	void updateUserByUid(User user);
	int allCount();
}
