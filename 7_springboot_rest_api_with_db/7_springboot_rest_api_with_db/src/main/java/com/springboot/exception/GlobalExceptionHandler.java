package com.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleNotFound(UserNotFoundException ex){
		//return ResponseEntity.ok("Class Not Found");
	return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlemethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<String, String>();
		
		ex.getBindingResult()
			.getFieldErrors()
				.forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
}
