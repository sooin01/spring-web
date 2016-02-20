package com.my.app.user.servvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.UserDao;
import com.my.app.user.domain.User;
import com.my.app.user.dto.UserResponseDto;

@Service
public class UserService  {
	
	@Autowired
	private UserDao userDao;

	public List<UserResponseDto> getUserList() {
		List<UserResponseDto> list = new ArrayList<>();
		for (User user : userDao.getUserList()) {
			UserResponseDto dto = new UserResponseDto();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);
		}
		return list;
	}
	
}
