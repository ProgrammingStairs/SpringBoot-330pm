package com.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class AppComponent {
	
	public String getComponentMessage() {
		return "This is component Message";
	}
}
