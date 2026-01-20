package com.springboot.service;

import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student addStudent(Student stud) {
		return studentRepository.save(stud);
	}
	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@Override
	public Student getStudentByPassportId(int pid) {
		return studentRepository.findByPassport_Pid(pid);
	}	

	@Override
	public String getPassportNumber(int sid) {
		return studentRepository.findById(sid).map(studObj-> studObj.getPassport().getPassport_number()).orElse("Not Found");	
	}
}
