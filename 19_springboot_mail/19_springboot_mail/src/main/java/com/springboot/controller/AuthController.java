package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.entity.VerificationToken;
import com.springboot.service.MailService;
import com.springboot.service.UserService;
import com.springboot.service.VerificationTokenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class AuthController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	VerificationTokenService verificationTokenService; 
	
	@Autowired
	MailService mailService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user,HttpServletRequest request) {
		try {
		User userObj =  userService.addUser(user);
		String token = verificationTokenService.createVerificationToken(userObj);
		String link  = request.getRequestURL().toString().replace("register", "verify?token="+token);
		System.out.println("Link : "+link);
			try {
			 mailService.sendMail(user.getEmail(), "Verification Mail", "Click Here to Verify : "+link);
			 return "Verification Mail Sent on Registered Mail-Id";
			}
			catch(Exception e) {
				System.out.println("Exception : "+e);
				return "Error while sending Verification Mail";	
			}
		}catch(Exception e) {
		    return "Duplicate Email | Please try with another email";
		}
	}
	
	@GetMapping("/verify")
	public String verifyEmail(@RequestParam("token") String token) {
		VerificationToken vt = verificationTokenService.findByToken(token);
		
		if(vt==null) {
			return "Verification Failed";
		}
		User user = vt.getUser();
		user.setEnabledStatus(true);
		userService.addUser(user);
		return "Email Verified | Now you can Login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email,
							@RequestParam("password") String password,
							HttpServletRequest request) {
		User user = userService.findByEmail(email);
		
		if(user==null || !user.getPassword().equals(password)) {
			return "Credential Not Matches";
		}
		if(!user.isEnabledStatus()) {
			return "Email not verified";
		}
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		return "Welcome "+email;	
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("email", null);
		session.invalidate();
		return "Logout Successfully";
	}
	
}


