package com.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDao{
	
	@PersistenceContext
	EntityManager em;
	
	public void addData(UserEntity user) {
		em.persist(user);
	}
	
	public List<UserEntity> getAllViews(){
		return em.createQuery("from UserEntity",UserEntity.class).getResultList();
	}
}