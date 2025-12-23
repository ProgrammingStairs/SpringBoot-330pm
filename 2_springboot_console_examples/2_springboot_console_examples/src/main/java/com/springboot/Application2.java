package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application2 {

	public static final Logger logger = LoggerFactory.getLogger(Application2.class);
	public static void main(String[] args) {
		logger.info(">>>>>>>Before run method executes");
		SpringApplication.run(Application2.class, args);
		logger.info(">>>>>>>After run method executes");
		// by default logger.info is setted here, if we want to execute debug also then needs to set logging.level.root=DEBUG in application.properties , or if we want to pring package specific statements then needs to define logging.level.<package_name> i.e logging.level.com.springboot = DEBUG
		logger.debug(">>>>>>>>>> debug executes | needs to define explicitly");
		logger.error(">>>>>>>>>> yet not come");
	}		
}
