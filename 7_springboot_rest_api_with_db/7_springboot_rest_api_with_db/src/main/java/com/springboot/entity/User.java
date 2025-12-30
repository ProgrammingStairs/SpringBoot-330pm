package com.springboot.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@NotBlank(message="Username Required")
	@Size(min=3,message="Username must contains atleast 3 characters")
	@Column(name="username")
	String username;
	
//	@NotBlank(message="Email Required")
	@Column(name="email")
	@Email(message="Email Required")
	String email;

	@NotBlank(message="Gender Required")
	@Column(name="gender")
	String gender;
	
	@ElementCollection
	@NotEmpty(message="Select atleast One Hobby")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
