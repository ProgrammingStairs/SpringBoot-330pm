package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@GetMapping("/")
	String adminIndex() {
		return "Welcome to admin Index Page";
	}

	@GetMapping("/home")
	String adminHome() {
		return "Welcome to admin Home Page";
	}
}
