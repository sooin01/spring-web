package com.my.app.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.app.user.domain.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/*-context.xml"})
@WebAppConfiguration
public class TestServiceTest {

	@Autowired
	TestService testService;
	
	@Test
	public void test() {
		System.out.println("=====================> START");
		for (TUser tUser : testService.getUserList()) {
			System.out.println("=====================> " + tUser);
		}
		System.out.println("=====================> END");
	}
	
}
