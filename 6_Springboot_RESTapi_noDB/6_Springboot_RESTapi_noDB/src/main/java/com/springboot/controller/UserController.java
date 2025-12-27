package com.springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String index() {
		return "<h2>Welcome to Rest API Example</h2>";
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.getAllUserList());
	} // ok method return with status code 200
}
