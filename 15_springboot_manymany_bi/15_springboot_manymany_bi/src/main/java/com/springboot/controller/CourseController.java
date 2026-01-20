package com.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.CourseService;

@RestController
public class CourseController {
	private CourseService courseService;
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
		
	@GetMapping("/getCourseNameByCourseId/{id}")
	public ResponseEntity<String> getCourseNameByCourseId(@PathVariable("id") int id) {
	    String courseName = courseService.findCourseNameById(id);
	    return ResponseEntity.ok(courseName);
	}

}
