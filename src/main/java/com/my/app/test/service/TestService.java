package com.my.app.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.app.test.dao.TestDao;
import com.my.app.user.domain.TUser;

@Service
@Repository
@Transactional
public class TestService {
	
	@Autowired
	TestDao testDao;

	public Iterable<TUser> getUserList() {
		return testDao.findAll();
	}
	
}
