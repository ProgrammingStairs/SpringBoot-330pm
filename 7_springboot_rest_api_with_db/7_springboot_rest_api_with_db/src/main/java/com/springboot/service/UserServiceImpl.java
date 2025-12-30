package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.exception.UserNotFoundException;
import com.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	@Override 
	public User findUserById(int id) {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id : "+id));
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(int id,User user) {
		User existing = findUserById(id);
		existing.setUsername(user.getUsername());
		existing.setEmail(user.getEmail());
		existing.setGender(user.getGender());
		existing.setHobbies(user.getHobbies());
		return userRepository.save(existing);
	}
	
	@Override 
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
