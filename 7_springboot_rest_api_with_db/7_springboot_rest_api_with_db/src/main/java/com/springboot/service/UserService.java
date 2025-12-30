package com.springboot.service;

import java.util.List;

import com.springboot.entity.User;

public interface UserService {
	public List<User> findAllUsers();
	public User findUserById(int id);
	public User saveUser(User user);
	public User updateUser(int id,User user);
	public void deleteUser(int id);
}
