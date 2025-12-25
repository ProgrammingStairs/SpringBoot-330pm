package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.component.AppComponent;
import com.springboot.service.AppService;

@RestController
public class AppController {
	
	@Autowired
	private AppService appService;
	
	private AppComponent appComponent;
	public AppController(AppComponent appComponent) {
		this.appComponent = appComponent;
	}
	
	@GetMapping("/")
	public String index() {
		return "Welcome to SpringBoot Application";
	}
	
	@GetMapping("/printData")
	public String printData() {
		return appComponent.getComponentMessage()+"<br>"+appService.getMessage();
	}
}

