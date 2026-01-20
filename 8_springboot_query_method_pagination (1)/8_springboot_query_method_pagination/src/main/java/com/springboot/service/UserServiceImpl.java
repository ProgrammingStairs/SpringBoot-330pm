package com.springboot.service;

import java.util.List;

import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override 
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public List<User> findUserByUsername(String username){
		return userRepository.findByUsername(username);
	}
	@Override
	public List<User> findUserByGender(String gender){
		return userRepository.findByGender(gender);
	}
	@Override
	public List<User> findUserByAddress(String address){
		return userRepository.findByAddress(address);
	}
	@Override
	public List<User> findUserByHobbies(String hobby){
		return userRepository.findByHobbies(hobby);
	}
	@Override
	//AND
	public List<User> findUserByGenderAndAddress(String gender,String address){
		return userRepository.findByGenderAndAddress(gender, address);
	}
	@Override
	//or
	public List<User> findUserByGenderOrAddress(String gender,String address){
		return userRepository.findByGenderOrAddress(gender, address);
	}
	@Override
	// not
	public List<User> findUserByGenderNot(String gender){
		return userRepository.findByGenderNot(gender);	
	}
	@Override
	// like 
	public List<User> findUserByUsernameContaining(String name){
		return userRepository.findByUsernameContaining(name);
	}
	@Override
	// ignore case 
	public List<User> findUserByUsernameIgnoreCase(String name){
		return userRepository.findByUsernameIgnoreCase(name);
	}
	@Override
	// ignore case + containing 
	public List<User> findUserByUsernameContainingIgnoreCase(String name){
		return userRepository.findByUsernameContainingIgnoreCase(name);
	}
	@Override
	public List<User> findUserByAddressIn(List<String> address){
		return userRepository.findByAddressIn(address);
	}
	@Override
	public List<User> findUserByGenderOrderByAddressAsc(String gender){
		return userRepository.findByGenderOrderByAddressAsc(gender);
	}

	@Override
	public Page<User> findByPagination(int page,int size){
		return userRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public Page<User> findBysort(String field){
		return userRepository.findAll(PageRequest.of(0, 3, Sort.by(field)));
	}
	@Override
	public Page<User> findByPaginationAndSorting(int page,int size,String field){
		return userRepository.findAll(PageRequest.of(page, size, Sort.by(field)));
	}
	
	@Override
	public Page<User> findByGender(String gender,int page,int size){
		return userRepository.findByGender(gender, PageRequest.of(page, size));
	}
	
	@Override
	public List<User> findByHobby(String hobby){
		return userRepository.findByHobby(hobby);
	}
	@Override
	public List<User> findByAddressNew(String address){
		return userRepository.findByAddressNew(address);
	}

	@Override
	public List<User> searchByGender(String gender){
		return userRepository.searchByGender(gender);
	}
	@Override
	public List<User> searchByAddress(String address){
		return userRepository.searchByAddress(address);
	}
	
}
