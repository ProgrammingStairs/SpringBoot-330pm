package com.springboot.services;

import java.util.List;

import com.springboot.entity.Department;

public interface DepartmentService {
	public Department saveDepartment(Department dept);
	public List<Department> viewAllDepartments();
	public Department getDepartmentNameById(int id);
}
