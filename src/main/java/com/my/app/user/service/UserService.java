package com.my.app.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.UserDao;
import com.my.app.user.domain.TUser;
import com.my.app.user.dto.UserResponseDto;

@Service
public class UserService  {
	
	@Autowired
	private UserDao userDao;

	public List<UserResponseDto> getUserList() {
		List<UserResponseDto> list = new ArrayList<>();
		for (TUser tUser : userDao.getUserList()) {
			UserResponseDto dto = new UserResponseDto();
			BeanUtils.copyProperties(tUser, dto);
			list.add(dto);
		}
		return list;
	}
	
}
