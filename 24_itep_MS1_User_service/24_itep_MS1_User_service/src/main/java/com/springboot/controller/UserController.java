package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/findUser/{id}")
	public User findUser(@PathVariable("id") int id) {
		return userService.findUserById(id);
	}
}
