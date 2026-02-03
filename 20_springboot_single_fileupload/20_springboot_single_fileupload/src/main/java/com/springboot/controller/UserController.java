package com.springboot.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.UserDto;
import com.springboot.entity.UserEntity;
import com.springboot.service.UserService;

@RestController
public class UserController{
	@Autowired
	UserService userService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String index() {
		return "<h2>Welcome to FileUpload</h2>";
	}
	
	/*
	 postman : 
	 
	 url: http://localhost:8080/uploadFile
	 method: post 
	 Body--> form-data
	 key : username   type: text  value : Andrew Anderson  
	 key : description   type: text  value : Its image
	 key : filename   type: file  value : select file

	  */
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFiles(@ModelAttribute UserDto userDto) throws Exception{
		System.out.println("---------------------------------> reached");
		MultipartFile file =  userDto.getFilename();
			
		String uploadPath = env.getProperty("upload.folder");
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists())
			uploadDir.mkdirs();
		
		String fileName = System.currentTimeMillis()+file.getOriginalFilename();
		File destination = new File(uploadDir,fileName);
		file.transferTo(destination);
		
		UserEntity user = new UserEntity();
		user.setUsername(userDto.getUsername());
		user.setDescription(userDto.getDescription());
		user.setFilename(fileName);
		
		userService.addUser(user);
		
		return ResponseEntity.ok("File Uploaded Successfully");
	}
	
	@GetMapping("/viewGallery")
	public ResponseEntity<List<UserEntity>> viewGallery() {
		return new ResponseEntity<>(userService.getAllViews(),HttpStatus.OK);
	}
	
}