package com.springboot.runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
	public class AppRunner implements ApplicationRunner {
	public static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

		@Override
		public void run(ApplicationArguments args) {
			logger.info(">>>>>>>>>>>>>> Application runner executes");
			
			/*
			 As we are running our project directly by eclipse by right clicking on project --> run as --> java application so its not possible for us to give arguments to main method, so for that we need to right click on project ---> run as --> run configuration --> select class(optional) ---> arguments --->give arguments --> run 
			 */
			System.out.println("------ Arguments ------- ");
			for(String str : args.getSourceArgs()) {
				System.out.println("----> : "+str);
			}
		}
	}
