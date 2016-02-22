package com.my.app.user.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/*-context.xml"})
@WebAppConfiguration
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetUserList() {
		userDao.getUserList();
	}
	
}