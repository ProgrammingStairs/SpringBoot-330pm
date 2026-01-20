package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport,Integer> {}
