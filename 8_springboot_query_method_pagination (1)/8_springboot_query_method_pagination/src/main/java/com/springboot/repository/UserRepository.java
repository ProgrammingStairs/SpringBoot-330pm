package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// some predefined methods
	/*
	 finadAll()
	 findById()
	 save()
	 count()
	 findAll(Pageable pageable)
	 */
	
	// user defined query methods 
	
	List<User> findByUsername(String username);
	List<User> findByGender(String gender);
	List<User> findByAddress(String address);
	List<User> findByHobbies(String hobby);
	
	//AND
	List<User> findByGenderAndAddress(String gender,String address);
	//or
	List<User> findByGenderOrAddress(String gender,String address);
	// not
	List<User> findByGenderNot(String gender);
	
	// like 
	List<User> findByUsernameContaining(String name);
	// ignore case 
	List<User> findByUsernameIgnoreCase(String name);
	// ignore case + containing 
	List<User> findByUsernameContainingIgnoreCase(String name);
	
	List<User> findByAddressIn(List<String> address);
	List<User> findByGenderOrderByAddressAsc(String gender);
	Page<User> findByGender(String gender,Pageable pageable);

	// jpql
	@Query("select u from User u join u.hobbies h where h=:hobby")
	List<User> findByHobby(@Param("hobby") String hobby);
	
	// native sql
	@Query(value="select * from userQuery where address=:address",
			nativeQuery=true)
	List<User> findByAddressNew(@Param("address") String address);
	
	List<User> searchByGender(@Param("gender") String gender);
	
	List<User> searchByAddress(@Param("address") String address);
	
	
}










