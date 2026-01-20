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
import com.springboot.service.StudentService;
import com.springboot.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService= studentService;
	}

	@GetMapping("/")
	public String index() {
		return "<h2>SpringBoot -- OneToOne Association | UniDirectional</h2>";
	}
		
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student stud) {
		return new ResponseEntity<>(studentService.addStudent(stud),HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByPassportId/{pid}")
	public ResponseEntity<Student> getStudentByPassportId(@PathVariable int pid) {
		return new ResponseEntity<>(studentService.getStudentByPassportId(pid),HttpStatus.OK);
	}	

	@GetMapping("/getPassportNumber/{sid}")
	public ResponseEntity<String> getPassportNumber(@PathVariable int sid) {
		return new ResponseEntity<>(studentService.getPassportNumber(sid),HttpStatus.OK);				
	}
}
