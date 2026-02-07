package com.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(JwtAuthenticationException.class)
	public ResponseEntity<Map<String, String>> handleException(JwtAuthenticationException ex) {

	    Map<String, String> error = new HashMap<>();
	    error.put("status", "403");
	    error.put("error", "Forbidden");
	    error.put("message", ex.getMessage());

	    return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

}
