package com.fragments.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.fragments.test" })
public class ContextConfiguration extends WebMvcConfigurerAdapter
{
 
	 
	  @Bean
	    public InternalResourceViewResolver jspViewResolver() {
	        InternalResourceViewResolver bean = new InternalResourceViewResolver();
	        bean.setPrefix("/WEB-INF/views/");
	        bean.setSuffix(".jsp");
	        return bean;
	    }
	  
	    @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver getMultipartResolver() {
	        return new CommonsMultipartResolver();
	    }
	
	
}
