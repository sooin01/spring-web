package com.my.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.user.dto.UserResponseDto;
import com.my.app.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	public List<UserResponseDto> getUserList() {
		return userService.getUserList();
	}

}
