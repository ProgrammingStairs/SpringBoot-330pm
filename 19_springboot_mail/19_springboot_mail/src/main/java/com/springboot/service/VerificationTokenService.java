package com.springboot.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.entity.VerificationToken;
import com.springboot.repository.VerificationTokenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VerificationTokenService{
	
	@Autowired
	VerificationTokenRepository verificationTokenRepository;
	
	public String createVerificationToken(User user) {
		
		String token = UUID.randomUUID().toString();
		VerificationToken vt = new VerificationToken();
		vt.setToken(token);
		vt.setUser(user);
		vt.setLocalDateTime(LocalDateTime.now().plusHours(24));
		
		verificationTokenRepository.save(vt);
		
		return token;
	}
	
	public VerificationToken findByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
}