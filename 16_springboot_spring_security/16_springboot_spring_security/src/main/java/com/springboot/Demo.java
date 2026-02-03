package com.springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Demo {
	public static void main(String args[]) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "12345678";
		String encodedPassword = encoder.encode(password);
		System.out.println("encodedPassword : "+encodedPassword);
	}
}
