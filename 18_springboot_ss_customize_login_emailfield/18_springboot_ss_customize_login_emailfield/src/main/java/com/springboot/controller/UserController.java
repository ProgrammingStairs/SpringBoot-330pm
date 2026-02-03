package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@GetMapping("/")
	String userIndex() {
		return "Welcome to user Index Page";
	}

	@GetMapping("/home")
	String userHome() {
		return "Welcome to user Home Page";
	}
}
