package com.springboot.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.JwtService;

/*
Flow : 
when user hits /login then SecurityFilterChain executes then JwtFilter executes, UsernamePasswordAuthenticationFilter is skipped and Authorization takes place

 When user hits /register then SecurityFilterChain executes then JwtFilter skipped as no token found, UsernamePasswordAuthenticationFilter is also skipped and Authorization takes place and it goes on respective route.
 */


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private BCryptPasswordEncoder encoder;
	private UserRepository userRepository;
	private JwtService jwtService;
	public AuthController(BCryptPasswordEncoder encoder,UserRepository userRepository,JwtService jwtService) {
		this.encoder = encoder;
		this.userRepository = userRepository;
		this.jwtService = jwtService;
	}
	
	@GetMapping("/")
	public String home() {
		return "<h2>Welcome to Home Page</h2>";
	}
	
	/*
	{
    "email":"admin@gmail.com",
    "password":"admin",
    "role":"ADMIN"
} 
	  */
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<String>("User Added Successfully",HttpStatus.CREATED);
	}
	
	/*
	 when we login , we get : 
	 {
    "role": "ADMIN",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjFAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzcwNDYwMjE0LCJleHAiOjE3NzA0NjA4MTR9.zQUHmG9aBKY6PUJjB0qTEN_gwoiufvbAqXzMhxbwNFA",
    "nextPage": "/user/home"
}

 now you need to come on http://localhost:8080/admin/home with get method 
 and also click on heders in post man and needs to add key by Authorization and set its value, and in value we need to write ---> Bearer<space>token_value now click on send 
	  */
	
	
	
	@PostMapping("/login")
	public Map<String,String> loginUser(@RequestBody User user){
		String email = user.getEmail();
		String password = user.getPassword();
		
		User userObj = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User Not found"));
		
		if(!encoder.matches(password, userObj.getPassword())) {
			throw new RuntimeException("Invalid User"); 
		}
			
		String token = jwtService.generateToken(userObj.getEmail(), userObj.getRole());
		
		return Map.of(
				"token",token,
				"role",userObj.getRole(),
				"nextPage",userObj.getRole().equalsIgnoreCase("Admin")?"/admin/home":"/user/home"
				);
	}
	
	

}
