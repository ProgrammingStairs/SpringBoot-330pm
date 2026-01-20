package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Department;
import com.springboot.services.DepartmentService;

@RestController
public class DepartmentController {
	
	private DepartmentService departmentService;
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/")
	public String index() {
		return "<h2>Example showing the concept of one to many uni association</h2>";
	}
	/*
	{
    	"deptName":"Information Technology"
	} 
	*/
	
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(departmentService.saveDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDepartment")
	public ResponseEntity<List<Department>> getAllDepartments() {
		return new ResponseEntity<>(departmentService.viewAllDepartments(),HttpStatus.OK);
	}
	
}
