package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.component.AppComponent;

@Configuration
public class AppConfig {

	@Bean
	public AppComponent appComponent() {
		return new AppComponent();
	}
}
