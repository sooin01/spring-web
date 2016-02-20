package com.my.app.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketController {

	@RequestMapping(value = "/websocket/index", method = RequestMethod.GET)
	public String index() {
		return "websocket/index";
	}
	
	@RequestMapping(value = "/websocket2", method = RequestMethod.GET)
	public void websocket2(HttpServletResponse response) throws IOException {
		response.getWriter().println("{\"resultCode\": \"OK\"}");
	}
	
	@MessageMapping("/stomp")
	@SendTo("/topic/stomp")
	public ResponseEntity<String> stomp(String request) {
		return new ResponseEntity<String>(request, HttpStatus.OK);
	}
	
}
