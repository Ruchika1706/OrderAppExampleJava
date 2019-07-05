package com.cisco.prj.cfg;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// Content Negotiation handler
@Configuration	 
@EnableWebMvc
@ComponentScan({ "com.cisco" })
public class WebConfig extends WebMvcConfigurerAdapter {

}