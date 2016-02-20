package com.my.app.sample.dto;

import com.my.app.common.dto.BaseDto;

public class RequestParamSampleDto extends BaseDto {

	private static final long serialVersionUID = -3979742997193753008L;
	
	private String user_id;
	private String user_name;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
