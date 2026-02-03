package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer>{
	VerificationToken findByToken(String token);
}