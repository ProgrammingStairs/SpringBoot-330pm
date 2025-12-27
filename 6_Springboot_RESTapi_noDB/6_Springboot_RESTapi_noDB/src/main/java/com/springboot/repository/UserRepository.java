package com.springboot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.entity.User;

@Repository
public class UserRepository {
	
	private List<User> users = new ArrayList<User>();
	
	public UserRepository() {
		User user1 = new User(101,"Andrew","andrew@gmail.com","andrew@123","Male",Arrays.asList("Cricket","Hockey","Football"));
		users.add(user1);
		
		users.add(new User(102,"Peter","peter@gmail.com","peter@123","Male",Arrays.asList("Hockey","Football")));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		return users.stream()
				.filter(obj->obj.getUid()==id)
				.findFirst()
				.orElse(null);
	}
	
	public User save(User user) {
		users.add(user);
		return user;
	}
	
	public User update(int id,User user) {
		User existing = findById(id);
		if(existing!=null) {
			existing.setUsername(user.getUsername());
			existing.setEmail(user.getEmail());
			existing.setPassword(user.getPassword());
			existing.setGender(user.getGender());
			existing.setHobbies(user.getHobbies());
		}
		return existing;
	}
	
	public boolean delete(int id) {
		User existing = findById(id);
		boolean status=false;
		if(existing!=null) {
			status = users.removeIf(user->user.getUid()==id);
		}
		return status;
	}
}
