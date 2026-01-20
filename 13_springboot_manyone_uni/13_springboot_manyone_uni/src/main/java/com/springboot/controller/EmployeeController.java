package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Department;
import com.springboot.entity.Employee;
import com.springboot.services.DepartmentService;
import com.springboot.services.EmployeeService;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public EmployeeController(EmployeeService employeeService,DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}

	/*
	 {
	 	"empname" : "Andrew Anderson",
	 	"department":{
	 		"did":1
	 	}
	 }	  
	  */
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//		Department obj = departmentService.getDepartmentNameById(employee.getDepartment().getDid());
//		employee.setDepartment(obj);
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
}
