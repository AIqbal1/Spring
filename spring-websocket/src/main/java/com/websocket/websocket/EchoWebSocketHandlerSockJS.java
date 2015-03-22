package com.websocket.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoWebSocketHandlerSockJS extends TextWebSocketHandler {

	private final EchoServiceSockJS echoService;
	
	@Autowired
	public EchoWebSocketHandlerSockJS(EchoServiceSockJS echoService) {
		this.echoService = echoService;
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String echoMessage = this.echoService.getMessage(message.getPayload());
		session.sendMessage(new TextMessage(echoMessage));
	}

}
