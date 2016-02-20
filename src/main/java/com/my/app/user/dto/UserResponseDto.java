package com.my.app.user.dto;

import com.my.app.common.dto.BaseDto;

public class UserResponseDto extends BaseDto {

	private static final long serialVersionUID = 4966329212986360513L;

	private String host;
	private String user;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
