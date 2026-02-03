package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.filter.JwtFilter;

@Configuration
public class JwtSecurityConfig {
	private JwtFilter jwtFilter;
	public JwtSecurityConfig(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf->csrf.disable());
		http.sessionManagement(sm-> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.authorizeHttpRequests(auth-> auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
		);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		/*
case 1 : 
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		If we have token then we needs Jwt filter and do not needs UsernamePasswordAuthenticationFilter.class in above code
		
case 2 : 
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		If we do not have token then we do not needs Jwt filter and here we needs UsernamePasswordAuthenticationFilter.class in above code
		  
		here UsernamePasswordAuthenticationFilter.class also requried when we deals with formlogin and username, password fields   
		*/
		return http.build();
	}
}


/*
 Flow : 
 when user hits /login then SecurityFilterChain executes then JwtFilter executes, UsernamePasswordAuthenticationFilter is skipped and Authorization takes place
 
  When user hits /register then SecurityFilterChain executes then JwtFilter skipped as no token found, UsernamePasswordAuthenticationFilter is also skipped and Authorization takes place and it goes on respective route.
  */
