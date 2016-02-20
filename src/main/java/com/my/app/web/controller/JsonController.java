package com.my.app.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsonController {

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ResponseEntity<String> json(HttpServletResponse response) throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		Thread.sleep(3000);
		return new ResponseEntity<String>("{\"resultCode\": \"OK\"}", responseHeaders, HttpStatus.OK);
	}

}
