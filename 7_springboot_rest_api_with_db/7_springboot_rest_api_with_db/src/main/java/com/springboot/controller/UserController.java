package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl userService;
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
//	@GetMapping("/")
	@GetMapping
	public String index() {
		return "<h2>This is an example of Rest API with Database</h2>";
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		System.out.println("gets entry");
//		userService.saveUser(user);
//		return ResponseEntity.status(HttpStatus.CREATED).body(user);	
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<User>> viewAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> viewUserById(@PathVariable int id){
		return ResponseEntity.ok(userService.findUserById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@Valid @RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(id, user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
