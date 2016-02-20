package com.my.app.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.my.app.sample.dto.RequestBodySampleDto;
import com.my.app.sample.dto.RequestParamSampleDto;
import com.my.app.sample.service.SampleService;
import com.my.app.sample.validator.SampleValidator;
import com.my.app.sample.vo.SampleVo;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleValidator sampleValidator;
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value = "/sample/index", method = RequestMethod.GET)
	public String index() {
		return "sample/index";
	}
	
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public @ResponseBody List<SampleVo> list(RequestParamSampleDto requestParamSample) {
		logger.info("Request param: {}", requestParamSample);
		return sampleService.list();
	}
	
	@RequestMapping(value = "/sample/{user}", method = RequestMethod.GET)
	public @ResponseBody SampleVo get(@PathVariable String user) {
		return sampleService.get(user);
	}
	
	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody SampleVo create(@RequestBody @Valid RequestBodySampleDto requestSample, BindingResult result) {
		sampleValidator.validate(requestSample, result);
		for (FieldError fieldError : result.getFieldErrors()) {
			logger.error("{}", fieldError);
		}
		
		logger.info("** request body: {}", requestSample);
		return sampleService.get(requestSample.getUser().getUser());
	}
	
}
