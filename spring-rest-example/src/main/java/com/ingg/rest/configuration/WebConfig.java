package com.ingg.rest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan( basePackages = "com.ingg.rest" )
@EnableWebMvc
public class WebConfig{
   //
}
