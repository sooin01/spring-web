package com.my.app.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.app.user.domain.TUser;
import com.my.app.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/*-context.xml"})
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testGetUserList() {
		for (TUser tUser : userService.getUserList()) {
			System.out.println(tUser);
		}
	}
	
	@Test
	public void testGetUser() {
		TUser tUser = userService.getUser();
		System.out.println(tUser);
	}
	
}
