package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.repository.AppRepository;

@Service
public class AppService {
	
	@Autowired
	AppRepository appRepository;
	
	public String getMessage() {
		return appRepository.getRepositoryMessage();
	}
	
}
