package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
public class StudentController {
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
		
	@GetMapping("/")
	public String index() {
		return "<h2>This is an example of Many To Many Unidirectional</h2>";
	}
	/*
	 	 {
	 	"studName" : "jackson",
	 	"courses":[
             {"courseName" : "Java Programming language"},
             {"courseName" : "Python Programming language"},
             {"courseName" : ".Net Programming language"}
         ]
	 }
 
	  */
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student stud) {
		return new ResponseEntity<>(studentService.addStudent(stud),HttpStatus.CREATED);
	}
}
