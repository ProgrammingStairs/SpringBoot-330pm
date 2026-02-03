package com.springboot.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return "<h2>Welcome to Multiple file uploads</h2>";
	}
	
	// we can select multiple files from postman also
	
	@PostMapping("/uploadFile")
	public String uploadFiles(@ModelAttribute UserDto userDto) throws Exception{
		MultipartFile[] files =  userDto.getFilename();
			
		String uploadPath = env.getProperty("upload.folder");
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists())
			uploadDir.mkdirs();
		
		StringBuilder sb = new StringBuilder();
		
		for(MultipartFile file :  files) {
			if(file!=null) {
				String fileName = System.currentTimeMillis()+file.getOriginalFilename();
				File destination = new File(uploadDir,fileName);
				file.transferTo(destination);
				sb.append(fileName).append(",");
			}
		}
		
		String filenames = sb.toString();
		filenames = filenames.substring(0, filenames.length()-1);
		
		UserEntity user = new UserEntity();
		user.setUsername(userDto.getUsername());
		user.setDescription(userDto.getDescription());
		user.setFilename(filenames);
		
		userService.addUser(user);
		
		return "File Upload Successfully";
	}
	
	@GetMapping("/viewGallery")
	public ResponseEntity<List<UserEntity>> viewGallery() {
		return new ResponseEntity<List<UserEntity>>(userService.getAllViews(),HttpStatus.OK);
	}
	
}