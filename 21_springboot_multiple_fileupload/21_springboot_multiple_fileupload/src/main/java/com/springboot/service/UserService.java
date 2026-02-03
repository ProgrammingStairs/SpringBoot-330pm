package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService{
	@Autowired
	UserDao userDao;
	
	public void addUser(UserEntity user) {
		userDao.addData(user);
	}

	public List<UserEntity> getAllViews(){
		return userDao.getAllViews();
	}
}
