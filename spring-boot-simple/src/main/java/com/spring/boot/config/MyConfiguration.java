package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
@ComponentScan
@EnableAutoConfiguration
public class MyConfiguration {

	@Value("${name:ooh}")
	private String name;
	
	@RequestMapping("/")
	public String hello() {
		return "hello " + this.name;
	}
	
	public static void main(String args[]) {
		SpringApplication.run(MyConfiguration.class, args);
	}
}
