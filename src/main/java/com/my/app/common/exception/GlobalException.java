package com.my.app.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<String> exception(Exception e) {
		String body = "{\"result\":\"Error\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(body, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
