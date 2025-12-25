package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.component.AppComponent;
import com.springboot.config.AppProperties;

@RestController
public class AppController2 {
	
	private AppComponent appComponent;
	// setter injection
	@Autowired
	public void setAppComponent(AppComponent appComponent) {
		this.appComponent = appComponent;
	}
	
	private AppProperties appProperties;
	// constructor injection
	public AppController2(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
	
	@GetMapping("/app2")
	public String printDetails() {
		return "Name : "+appProperties.getName()+"<br>Version : "+appProperties.getVersion();
	}
	
	@GetMapping("/app3")
	public String showDetails() {
		return appComponent.getComponentMessage();
	}
	
}
