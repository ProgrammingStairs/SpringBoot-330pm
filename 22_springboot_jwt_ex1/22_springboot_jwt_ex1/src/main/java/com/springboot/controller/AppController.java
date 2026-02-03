package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.AppService;

@RestController
public class AppController {
	
	private AppService appService;
	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@PostMapping("/generateToken")
	public String generateToken() {
		return appService.generateToken("AndrewAnderson");
	}
	// generateToken method gives you token
	// copy that token --> click on Headers in postman ---> set key Authorization and in value needs to write --> Bearer<space>copy that token ---> then hit for validate token
	
	
	@GetMapping("/validateToken")
	public String validateToken(@RequestHeader("Authorization") String authHeader) {
	System.out.println("------------> "+authHeader);
	 String token = authHeader.substring(7).split(",")[0].trim();
		return appService.validateToken(token) ? "Valid Token" : "Invalid Token";
	}
}
