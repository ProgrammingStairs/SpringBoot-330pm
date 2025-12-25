package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController1 {
	
	@Value("${app.name}")
	private String name;
	
	@Value("${app.version}")
	private String version;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to <h1>SpringBoot Application</h1>";
	}
	
	@GetMapping("/app1")
	public String getDetails() {
		return "Name : "+name+"<br>Version : "+version;
	}
}
