package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		User userObj = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userObj);
		//return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	/*
	@PostMapping
	public ResponseEntity<User> addUser(RequestEntity<User> request){
		User user = request.getBody();
		HttpHeaders res = request.getHeaders();
		System.out.println("---> res : "+res);
		User userObj = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userObj);
	}
	*/
	

	@PutMapping("/{id}")
	public ResponseEntity<User> updateStudent(@PathVariable int id,@RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(id, user)); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable int id) {
		User user = userService.getUserById(id);
		if(user==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(user);
	} 
	
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		User user = userService.getUserById(id);
		if(user==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.noContent().build();
	}
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		User user = userService.getUserById(id);
		if(user==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			userService.deleteUser(id);
		return ResponseEntity.ok("Data deleted successfully");
	}

}










