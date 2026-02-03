package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
		
	@GetMapping("/")
	String index() {
		return "index";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@GetMapping("/home")
	String home() {
		return "home";
	}

//	@GetMapping("/logout")
//	String logout() {
//		return "login";
//	}

}
