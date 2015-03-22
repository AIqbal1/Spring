package com.websocket.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@Import(WebMvcConfig.class)
@EnableWebSocketMessageBroker
@EnableScheduling
@ComponentScan(basePackages="com.websocket")
public class WebConfig  extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// this is the point to connect to!!
		// sockjs makes a connection to this end point
		registry.addEndpoint("/example").withSockJS();
	}

	@Override	
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// anything with topic prefix goes through the simple broker
		// you can replace this with a external broker such as rabbitMq or activeMQ configured
		registry.enableSimpleBroker("/topic/");		
		
		// prefix all method calls with /app
		// for example /app/hello
		registry.setApplicationDestinationPrefixes("/app");
	}
	
}
