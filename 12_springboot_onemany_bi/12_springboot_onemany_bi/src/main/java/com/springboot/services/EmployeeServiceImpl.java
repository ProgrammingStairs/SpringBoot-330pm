package com.springboot.services;


import org.springframework.stereotype.Service;
import com.springboot.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override 
	public String getDepartmentNameByEmployeeId(int empId){
		return employeeRepository.getDepartmentNameByEmployeeId(empId);
	}
}
