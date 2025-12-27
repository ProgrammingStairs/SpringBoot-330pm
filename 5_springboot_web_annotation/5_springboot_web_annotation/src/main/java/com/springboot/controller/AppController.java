package com.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;

@RestController
public class AppController {
	
	@GetMapping("/")
	public String index() {   // Added data in http response is in plain text 
		return "<h1>This is an example of SpringBoot | Home Page</h1>";
	}
	
	@GetMapping("/about")
	public String about() { // Added data in http response is in plain text 
		return "<h1>About Page</h1>";
	}
	
	@GetMapping("/service")
	public String service() { // Added data in http response is in plain text 
		return "<h1>Service Page</h1>";
	}
	
	@GetMapping("/view/{name}")
	public String view(@PathVariable String name) { // Added data in http response is in plain text 
		return "<h2>Hello "+name+"</h2>";
	}
	
	@GetMapping("/viewData/{name}/{age}")
	public String viewData(@PathVariable String name,
			@PathVariable int age) { // Added data in http response is in plain text 
		return "<h2>Hello "+name+" , your age is "+age+"</h2>";
	}
	
	//  localhost:8080/printData?email=peter@gmail.com&password=peter@123
	// or body--> form Data --> give key value pair
	@GetMapping("/printData")
	public String printData(@RequestParam String email,
			@RequestParam String password) { // Added data in http response is in plain text 
		return "<h2>Email : "+email+"<br>Password : "+password+"</h2>";
	}
	/*
	 {
	    "name":"simon",
	    "address":"Indore Madhya Pradesh"
	  } 
	  */
	@PostMapping("/printPostData")
	public String printPostData(@RequestBody Student student){ // Added data in http response is in plain text 
		return "<h2>Name : "+student.getName() +"<br>Address: "+student.getAddress()+"</h2>";
	}
	
	@PutMapping("/updateData/{id}")
	public String updateData(@PathVariable int id) { // Added data in http response is in plain text 
		return "<h2>Your updated Id is "+id+"</h2>";
	}

	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) { // Added data in http response is in plain text 
		return "<h2>Your deleted Id is "+id+"</h2>";
	}
	
	@GetMapping("/getData")
	public Student getStudData() {  // Added data in http response is in json format 
		// spring converts class type or list type data in json format
		return new Student(1234, "Peter Parker", "Indore", "C Programming Language");
	}
}

