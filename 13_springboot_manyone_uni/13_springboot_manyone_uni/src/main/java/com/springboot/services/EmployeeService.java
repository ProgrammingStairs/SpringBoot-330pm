package com.springboot.services;

import java.util.List;

import com.springboot.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public List<Employee> getAllEmployee();

}
