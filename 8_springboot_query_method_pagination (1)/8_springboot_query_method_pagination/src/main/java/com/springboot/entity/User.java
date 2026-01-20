package com.springboot.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@NamedQuery(
	name = "User.searchByAddress",
	query = "select u from User u where u.address = :address"
)
@NamedNativeQuery(
	name = "User.searchByGender",
	query = "select * from userQuery where gender=:gender",
	resultClass = User.class
)

@Entity
@Table(name="userquery")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="username")
	String username;
	
	@Column(name="address")
	String address;
	
	@Column(name="gender")
	String gender;
	
	@ElementCollection
	// If parent table name is custom, @CollectionTable is mandatory.
	@CollectionTable(
	        name = "user_hobbies",
	        joinColumns = @JoinColumn(name = "user_uid")
	)
	@Column(name="hobbies")
	List<String> hobbies;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
