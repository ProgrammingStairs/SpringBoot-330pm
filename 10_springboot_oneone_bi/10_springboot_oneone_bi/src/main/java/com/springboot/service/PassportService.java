package com.springboot.service;

import com.springboot.entity.Student;

public interface PassportService {
	
	public Student getStudentByPassportId(int pid);
	
}
