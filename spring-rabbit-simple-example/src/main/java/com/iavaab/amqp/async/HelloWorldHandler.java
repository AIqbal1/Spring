package com.iavaab.amqp.async;

public class HelloWorldHandler {
	public void handleMessage(String text) {
		System.out.println("Received: " + text);
	}
}
