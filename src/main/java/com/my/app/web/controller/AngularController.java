package com.my.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AngularController {

	@RequestMapping(value = "/angular/index", method = RequestMethod.GET)
	public String index() {
		return "/angular/index";
	}
	
	@RequestMapping(value = "/angular/test1", method = RequestMethod.GET)
	public String test1() {
		return "/angular/test1";
	}
	
}
