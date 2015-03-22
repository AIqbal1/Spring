package com.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.websocket.websocket.EchoService;
import com.websocket.websocket.EchoServiceSockJS;
import com.websocket.websocket.EchoWebSocketHandler;
import com.websocket.websocket.EchoWebSocketHandlerSockJS;

@Configuration
@ComponentScan(basePackages={"com.websocket.websocket"})
@EnableWebMvc
@EnableWebSocket
public class WebConfig extends WebMvcConfigurerAdapter implements
		WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// Normal W3C websockets
		registry.addHandler(echoWebSocketHandler(), "/echo");
		
		// With SockJS
		registry.addHandler(echoWebSocketHandlerSockJS(), "/sockjs/echo").withSockJS().setHeartbeatTime(500);
	}

	@Bean
	public WebSocketHandler echoWebSocketHandler() {
		return new EchoWebSocketHandler(echoService());
	}

	@Bean
	public EchoService echoService() {
		return new EchoService();
	}
	
	@Bean
	public WebSocketHandler echoWebSocketHandlerSockJS() {
		return new EchoWebSocketHandlerSockJS(echoServiceSockJS());
	}

	@Bean
	public EchoServiceSockJS echoServiceSockJS() {
		return new EchoServiceSockJS();
	}	

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
