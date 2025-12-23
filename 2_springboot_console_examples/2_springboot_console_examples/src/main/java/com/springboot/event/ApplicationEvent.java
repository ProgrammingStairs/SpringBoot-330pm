package com.springboot.event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
	public class ApplicationEvent {
	public static final Logger logger = LoggerFactory.getLogger(ApplicationEvent.class);

		@EventListener(ApplicationReadyEvent.class)
		public void onApplicationReady() {
			logger.info(">>>>>>>>>>>>>> Application ready event executes");			
		}
	}
