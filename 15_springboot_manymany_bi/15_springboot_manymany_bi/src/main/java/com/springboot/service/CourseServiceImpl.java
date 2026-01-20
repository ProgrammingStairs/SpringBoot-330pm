package com.springboot.service;

import org.springframework.stereotype.Service;

import com.springboot.entity.Course;
import com.springboot.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	private CourseRepository courseRepository;
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Override
	public String findCourseNameById(int id) {
	    return courseRepository.findById(id)
	            .map(course-> course.getCourseName())   // map entity to course name
	            .orElse("Course not found");  // handle missing course
	}

}
