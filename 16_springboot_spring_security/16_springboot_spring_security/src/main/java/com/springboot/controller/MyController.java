package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {
		
	@GetMapping
	String index() {
		return "Hit : <br> http://localhost:8080/admin/ <br> http://localhost:8080/admin/home <br>http://localhost:8080/user/ <br>http://localhost:8080/user/home <br>";
	}
}
