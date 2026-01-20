package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.PassportService;
import com.springboot.service.StudentService;
import com.springboot.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	private StudentService studentService;
	private PassportService passportService;

	public StudentController(StudentService studentService,PassportService passportService) {
		this.studentService = studentService;
		this.passportService =  passportService;
	}

	@GetMapping("/")
	public String index() {
		return "<h2>SpringBoot -- OneToOne Association | BiDirectional</h2>";
	}
		
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student stud) {
		return new ResponseEntity<>(studentService.addStudent(stud),HttpStatus.CREATED);
	}
	@GetMapping("/getStudentByPassportId/{pid}")
	public ResponseEntity<Student> getStudentByPassportId(@PathVariable int pid) {
		return new ResponseEntity<>(passportService.getStudentByPassportId(pid),HttpStatus.OK);				
	}
}
