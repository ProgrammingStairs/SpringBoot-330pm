package com.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
public class UserController {

	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String index() {
		return "<h2>Example of QueryMethod, @Query, @NamedQuery, @NamedNativeQuery</h2>"; 
	}
	
	@PostMapping("/save") 
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		  return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/findUserByUsername/{username}")
	public ResponseEntity<List<User>> findUserByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.findUserByUsername(username));
	}
	
	@GetMapping("/findUserByGender/{gender}")
	public ResponseEntity<List<User>> findUserByGender(@PathVariable String gender){
		return ResponseEntity.ok(userService.findUserByGender(gender));
	}
	
	@GetMapping("/findUserByAddress/{address}")
	public ResponseEntity<List<User>> findUserByAddress(@PathVariable String address){
		return ResponseEntity.ok(userService.findUserByAddress(address));
	}
	
	@GetMapping("/findUserByHobbies/{hobby}")
	public ResponseEntity<List<User>> findUserByHobbies(@PathVariable String hobby){
		return ResponseEntity.ok(userService.findUserByHobbies(hobby));
	}
	
	@GetMapping("/findUserByGenderAndAddress")
	//AND
	public ResponseEntity<List<User>> findUserByGenderAndAddress(@RequestParam String gender,@RequestParam String address){
		return ResponseEntity.ok(userService.findUserByGenderAndAddress(gender, address));
	}
	
	@GetMapping("/findUserByGenderOrAddress")
	//or
	public ResponseEntity<List<User>> findUserByGenderOrAddress(@RequestParam String gender,@RequestParam String address){
		return ResponseEntity.ok(userService.findUserByGenderOrAddress(gender, address));
	}
	
	@GetMapping("/findUserByGenderNot/{gender}")
	// not
	public ResponseEntity<List<User>> findUserByGenderNot(@PathVariable String gender){
		return ResponseEntity.ok(userService.findUserByGenderNot(gender));	
	}
	
	@GetMapping("/findUserByUsernameContaining/{name}")
	// like 
	public ResponseEntity<List<User>> findUserByUsernameContaining(@PathVariable String name){
		return ResponseEntity.ok(userService.findUserByUsernameContaining(name));
	}
	
	@GetMapping("/findUserByUsernameIgnoreCase/{name}")
	// ignore case 
	public ResponseEntity<List<User>> findUserByUsernameIgnoreCase(@PathVariable String name){
		return ResponseEntity.ok(userService.findUserByUsernameIgnoreCase(name));
	}
	
	@GetMapping("/findUserByUsernameContainingIgnoreCase/{name}")
	// ignore case + containing 
	public ResponseEntity<List<User>> findUserByUsernameContainingIgnoreCase(@PathVariable String name){
		return ResponseEntity.ok(userService.findUserByUsernameContainingIgnoreCase(name));
	}
	
	@GetMapping("/findUserByAddressIn/{address}")
	public ResponseEntity<List<User>> findUserByAddressIn(@PathVariable List<String> address){
		return ResponseEntity.ok(userService.findUserByAddressIn(address));
	}
	
	 // Example: /search?address=indore&address=bhopal
    @GetMapping("/search")
    public List<User> searchUsersByAddressIn(@RequestParam List<String> address) {
        return userService.findUserByAddressIn(address);
    }
	
	@GetMapping("/findUserByGenderOrderByAddressAsc/{gender}")
	public ResponseEntity<List<User>> findUserByGenderOrderByAddressAsc(@PathVariable String gender){
		return ResponseEntity.ok(userService.findUserByGenderOrderByAddressAsc(gender));
	}

	@GetMapping("/findByPagination")
	public ResponseEntity<Page<User>> findByPagination(@RequestParam int page,@RequestParam int size){
		return ResponseEntity.ok(userService.findByPagination(page, size));
	}
	
	// needs to give field name
	@GetMapping("/findBysort/{field}")
	public ResponseEntity<Page<User>> findBysort(@PathVariable String field){
		return ResponseEntity.ok(userService.findBysort(field));
	}
	// needs to give filed name
	@GetMapping("/findByPaginationAndSorting")
	public ResponseEntity<Page<User>> findByPaginationAndSorting(@RequestParam int page,@RequestParam int size,@RequestParam String field){
		return ResponseEntity.ok(userService.findByPaginationAndSorting(page, size, field));
	}
	
	@GetMapping("/findByGender")
	public ResponseEntity<Page<User>> findByGender(@RequestParam String gender,@RequestParam int page,@RequestParam int size){
		return ResponseEntity.ok(userService.findByGender(gender, page, size));
	}
	
	@GetMapping("/findByHobby/{hobby}")
	public ResponseEntity<List<User>> findByHobby(@PathVariable String hobby){
		return ResponseEntity.ok(userService.findByHobby(hobby));
	}
	
	@GetMapping("/findByAddressNew/{address}")
	public ResponseEntity<List<User>> findByAddressNew(@PathVariable String address){
		return ResponseEntity.ok(userService.findByAddressNew(address));
	}

	@GetMapping("/searchByGender/{gender}")
	public ResponseEntity<List<User>> searchByGender(@PathVariable String gender){
		return ResponseEntity.ok(userService.searchByGender(gender));
	}
	
	@GetMapping("/searchByAddress/{address}")
	public ResponseEntity<List<User>> searchByAddress(@PathVariable String address){
		return ResponseEntity.ok(userService.searchByAddress(address));
	}

}
