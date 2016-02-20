package com.my.app.web.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		/*for (int i = 0; i < 10; i++) {
			session.sendMessage(new TextMessage(message.getPayload()));
			Thread.sleep(1000);
		}*/
		RestTemplate restTemplate = new RestTemplate();
		while (true) {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/websocket2", String.class);
			session.sendMessage(new TextMessage(responseEntity.getBody()));
			Thread.sleep(1000);
		}
	}
	
}
