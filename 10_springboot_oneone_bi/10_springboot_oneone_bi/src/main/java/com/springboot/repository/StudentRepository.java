package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	public Student findByPassport_Pid(int id); // here Passport is your passport reference and pid is your passport field
}
