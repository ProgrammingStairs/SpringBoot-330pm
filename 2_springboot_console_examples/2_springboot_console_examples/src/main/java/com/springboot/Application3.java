package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class Application3 {

	public static final Logger logger = LoggerFactory.getLogger(Application3.class);
	public static void main(String[] args) {
		logger.info(">>>>>>>Before run method executes");
		SpringApplication.run(Application3.class, args);
		logger.info(">>>>>>>After run method executes");
		System.out.println("#### system out println statement executes #####");
	}	
	
	@Bean
	@Order(1)
	public CommandLineRunner printMessageOne() {
		return args->{
			logger.info(">>>>>>>>>> CommandLineRunner printMessageOne executes..!!");
			System.out.println("CommandLineRunner printMessageOne executes..!!");
		};
	}
	
	@Bean
	@Order(2)
	public CommandLineRunner printMessageTwo() {
		return args->{
			logger.info(">>>>>>>>>> CommandLineRunner printMessageTwo executes..!!");
			System.out.println("CommandLineRunner printMessageTwo executes..!!");
		};
	}
	
	@PostConstruct
	public void postConstructMethod() {
		logger.info(">>>>>>>>>> post construct method executes ");
		System.out.println(">>>>>>>>>> post construct method executes ");
	}
	
	@PreDestroy
	public void cleanUp() {
		logger.info(">>>>>>>>>> destroy method executes ");
		System.out.println(">>>>>>>>>> destroy method executes ");	
	}
}
