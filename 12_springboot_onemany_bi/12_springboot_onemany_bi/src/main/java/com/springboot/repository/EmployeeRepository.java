package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
		
	default String getDepartmentNameByEmployeeId(int empId) {
		return findById(empId).get().getDepartment().getDeptName();
	}
	
}
