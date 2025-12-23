package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application1 {

	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
		System.out.println("Normal statement");
	}
		
	@Bean
	public CommandLineRunner printMessage() {
		return args->{
			System.out.println("This is an example of command line runner");
		};
	}
}
