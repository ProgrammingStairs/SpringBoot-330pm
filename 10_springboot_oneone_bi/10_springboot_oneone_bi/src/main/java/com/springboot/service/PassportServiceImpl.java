package com.springboot.service;

import org.springframework.stereotype.Service;

import com.springboot.entity.Passport;
import com.springboot.entity.Student;
import com.springboot.repository.PassportRepository;

@Service
public class PassportServiceImpl implements PassportService {
	private PassportRepository passportRepository;
	public PassportServiceImpl(PassportRepository passportRepository) {
		this.passportRepository = passportRepository;
	}
	
	@Override
	public Student getStudentByPassportId(int pid) {
		Passport passObj = passportRepository.findById(pid).orElse(null);
		return passObj.getStud();
	}	

}
