package com.my.app.sample.dto;

import com.my.app.common.dto.BaseDto;
import com.my.app.sample.vo.UserVo;

public class RequestBodySampleDto extends BaseDto {

	private static final long serialVersionUID = 4433265838721764233L;
	
	private UserVo userVo;

	public UserVo getUser() {
		return userVo;
	}

	public void setUser(UserVo userVo) {
		this.userVo = userVo;
	}

}
