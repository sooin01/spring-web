package com.my.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.UserDao;
import com.my.app.user.domain.QTUser;
import com.my.app.user.domain.TUser;
import com.mysema.query.types.Predicate;

@Service
public class UserService  {
	
	@Autowired
	private UserDao userDao;

	public Iterable<TUser> getUserList() {
		return userDao.findAll();
	}
	
	public TUser getUser() {
		QTUser tuser = QTUser.tUser;
		Predicate p = tuser.userId.eq("test1");
		return userDao.findOne(p);
	}
	
}
