package com.my.app.sample.vo;

import com.my.app.common.dto.BaseDto;

public class SampleVo extends BaseDto {

	private static final long serialVersionUID = 163176574803744761L;

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
