package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUserList(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(int id,User user) {
		return userRepository.update(id, user);
	}
	
	public boolean deleteUser(int id) {
		return userRepository.delete(id);
	}
}
