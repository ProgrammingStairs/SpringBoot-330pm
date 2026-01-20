package com.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentRepository departmentRepository;
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override 
	public Department saveDepartment(Department dept) {
		return departmentRepository.save(dept);
	}
	@Override
	public List<Department> viewAllDepartments(){
		return departmentRepository.findAll();
	}
}
