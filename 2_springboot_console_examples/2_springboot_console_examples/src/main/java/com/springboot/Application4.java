package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application4 {

	public static final Logger logger = LoggerFactory.getLogger(Application4.class);
	public static void main(String[] args) {
		logger.info(">>>>>>>Before run method executes");
		SpringApplication.run(Application4.class, args);
		logger.info(">>>>>>>After run method executes");
	}	
	
}
