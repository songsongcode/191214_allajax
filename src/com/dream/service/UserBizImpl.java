package com.dream.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dream.dao.IUserDao;
import com.dream.utils.DBUtils;
import com.dream.vo.Page;
import com.dream.vo.User;

public class UserBizImpl implements IUserBiz {
	private IUserDao iUserDao;
	private SqlSession	session;
	@Override
	public void addUser(User user) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		iUserDao.addUser(user);
		session.commit();
		if(session!=null)
			session.close();
	}

	@Override
	public List<User> showUsers(Page pg) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		List<User> users=iUserDao.showUsers(pg);
		if(session!=null)
			session.close();
		return users;
	}

	@Override
	public User showUserByUid(int uid) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		User user=iUserDao.showUserByUid(uid);
		if(session!=null)
			session.close();
		return user;
	}

	@Override
	public void delUserByUid(int uid) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		iUserDao.delUserByUid(uid);
		session.commit();
		if(session!=null)
			session.close();
	}

	@Override
	public void updateUserByUid(User user) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		iUserDao.updateUserByUid(user);
		session.commit();
		if(session!=null)
			session.close();
	}

	@Override
	public int allPage(int count) {
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
		int allCount = iUserDao.allCount();
		if(session!=null)
			session.close();
		if(allCount%count==0) {
			return allCount/count;
		}else{
			return (allCount/count)+1;
		}
	}
	
}
