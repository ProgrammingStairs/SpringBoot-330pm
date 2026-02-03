package com.springboot.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_multiple_files")
public class UserEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	int uid;
	
	@Column(name="username")
	String username;
	
	@Column(name="description")
	String description;
	
	@Column(name="filename",length = 2000) // default hibernate sets to varchar = 255 
	String filename;
	/*
	 * or
	 * ALTER TABLE user_multiple_files
MODIFY filename VARCHAR(2000);
	 * */
	
	
	@CreationTimestamp
	@Column(name="uploadedAt")
	LocalDateTime uploadedAt;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	
	
}