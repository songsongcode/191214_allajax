package com.dream.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dream.dao.IUserDao;
import com.dream.utils.DBUtils;
import com.dream.vo.Page;
import com.dream.vo.User;

class test {
	private static IUserDao iUserDao;
	private static SqlSession	session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		session=DBUtils.getSession();
		iUserDao=session.getMapper(IUserDao.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test1() {
		
		List<User> users=iUserDao.showUsers(new Page(1,2));
		if(session!=null)
			session.close();
		for (User user : users) {
			System.out.println(user);
		}
	}
	@Test
	void test2() {
		for (int i = 10; i < 99; i++) {
			User user = new User("wss"+i,'男', 10+i, "1111111"+i);
			iUserDao.addUser(user);
			session.commit();
		}
		if(session!=null)
			session.close();
		
	}

}
