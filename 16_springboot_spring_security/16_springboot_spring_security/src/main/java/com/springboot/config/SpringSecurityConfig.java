package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.service.CustomUserDetailsService;

@Configuration
public class SpringSecurityConfig {

	private CustomUserDetailsService customUserDetailsService;
	public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http
			.csrf(csrf->csrf.disable()) // csrffilter
			.authorizeHttpRequests(auth-> auth
				.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/admin/**").hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated()
			) 
			.httpBasic(Customizer.withDefaults()); // responsible to generate basic auth popup
		return http.build();
	}
}
