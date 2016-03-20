package com.my.app.lifecycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.lifecycle.dto.NfvResponse;
import com.my.app.lifecycle.service.NsService;

@RestController
public class NsController {
	
	@Autowired
	private NsService nsService;

	@RequestMapping(value = "/ns/instantiate", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public NfvResponse instantiage() {
		nsService.instantiate();
		
		NfvResponse response = new NfvResponse();
		response.setResultCode(200);
		response.setResultDesc("Success");
		return response;
	}
	
}
