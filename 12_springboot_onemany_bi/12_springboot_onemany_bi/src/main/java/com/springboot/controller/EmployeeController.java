package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.services.EmployeeService;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	@GetMapping("/getDepartmentName/{id}")
	public ResponseEntity<String> getDepartmentName(@PathVariable int id) {
		return new ResponseEntity<>(employeeService.getDepartmentNameByEmployeeId(id),HttpStatus.OK);
	}
	

}
