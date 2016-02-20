package com.my.app.user.servvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.UserDao;
import com.my.app.user.domain.User;

@Service
public class UserService  {
	
	@Autowired
	private UserDao userDao;

	public List<User> getUserList() {
		return userDao.getUserList();
	}
	
}
