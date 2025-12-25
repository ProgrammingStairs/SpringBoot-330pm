package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 Web Annotation : 
 	@RestController
 	@Controller 
 	@GetMapping 
 	@PostMapping 
 	@PutMapping
 	@DeleteMapping 
 	@RequestParam 
 	@ResponseBody
 	@RequestMapping
 	@PathVariable
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
