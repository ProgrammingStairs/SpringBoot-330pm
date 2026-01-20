package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> findUserByUsername(String username);
	List<User> findUserByGender(String gender);
	List<User> findUserByAddress(String address);
	List<User> findUserByHobbies(String hobby);
	
	//AND
	List<User> findUserByGenderAndAddress(String gender,String address);
	//or
	List<User> findUserByGenderOrAddress(String gender,String address);
	// not
	List<User> findUserByGenderNot(String gender);
	
	// like 
	List<User> findUserByUsernameContaining(String name);
	// ignore case 
	List<User> findUserByUsernameIgnoreCase(String name);
	// ignore case + containing 
	List<User> findUserByUsernameContainingIgnoreCase(String name);
	
	List<User> findUserByAddressIn(List<String> address);
	List<User> findUserByGenderOrderByAddressAsc(String gender);
	
	Page<User> findByPagination(int page,int size);
	Page<User> findBysort(String field);
	Page<User> findByPaginationAndSorting(int page,int size,String field);
	Page<User> findByGender(String gender,int page,int size);
	
	List<User> findByHobby(String hobby);
	List<User> findByAddressNew(String address);
	
	List<User> searchByGender(String gender);
	List<User> searchByAddress(String address);

}
