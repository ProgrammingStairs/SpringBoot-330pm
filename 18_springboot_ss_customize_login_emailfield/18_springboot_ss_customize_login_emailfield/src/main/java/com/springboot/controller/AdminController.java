package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {
		
	@GetMapping("/")
	String adminIndex() {
		return "Welcome to admin Index Page";
	}

	@GetMapping("/home")
	String adminHome() {
		return "admin";
	}
}
