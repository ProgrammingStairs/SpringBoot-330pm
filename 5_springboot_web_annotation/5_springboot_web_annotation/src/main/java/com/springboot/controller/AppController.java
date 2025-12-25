package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/")
	public String index() {
		return "<h1>This is an example of SpringBoot</h1>";
	}
	@PostMapping("/index")
	public String postIndex() {
		return "<h1>This is an example of SpringBoot</h1>";
	}
}
