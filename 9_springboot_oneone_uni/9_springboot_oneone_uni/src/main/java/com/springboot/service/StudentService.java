package com.springboot.service;

import com.springboot.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student stud);
	public Student getStudentById(int id);
	public Student getStudentByPassportId(int pid);
	public String getPassportNumber(int sid);
	
}
