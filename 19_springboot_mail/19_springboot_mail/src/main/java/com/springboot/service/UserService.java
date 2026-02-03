package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}