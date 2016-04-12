package com.my.app.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String exception(Exception e) {
		System.out.println("에러!! " + e.toString());
		return "{\"result\":\"Error\"}";
	}
	
}
