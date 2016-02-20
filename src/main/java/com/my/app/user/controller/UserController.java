package com.my.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.user.domain.User;
import com.my.app.user.servvice.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	public List<User> getUserList() {
		return userService.getUserList();
	}

}
