package com.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Flow : 
when user hits /login then SecurityFilterChain executes then JwtFilter executes, UsernamePasswordAuthenticationFilter is skipped and Authorization takes place

 When user hits /register then SecurityFilterChain executes then JwtFilter skipped as no token found, UsernamePasswordAuthenticationFilter is also skipped and Authorization takes place and it goes on respective route.
 */


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping("/")
	public String home() {
		return "<h2>Welcome to Home Page</h2>";
	}
	
	@PostMapping("/register")
	public String addUser(){
		
		return "User Added Successfully";
	}
	
	@PostMapping("/login")
	public String loginUser(){
		
		return "User Login Successfully";
	}

}
