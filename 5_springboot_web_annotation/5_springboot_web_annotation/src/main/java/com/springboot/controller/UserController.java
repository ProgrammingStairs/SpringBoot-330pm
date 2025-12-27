package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/home")
	public String home() { // Added data in http response is in plain text 
		return "<h1>Home Page | User</h1>";
	}

} 

