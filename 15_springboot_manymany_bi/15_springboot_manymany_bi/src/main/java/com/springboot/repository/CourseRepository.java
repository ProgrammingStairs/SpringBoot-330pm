package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{}
