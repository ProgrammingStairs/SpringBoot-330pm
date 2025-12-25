package com.springboot.model;

public class Student {
	private int sid;
	private String name;
	private String address;
	private String Course;
	
	public Student(int sid, String name, String address, String course) {
		super();
		this.sid = sid;
		this.name = name;
		this.address = address;
		Course = course;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	
	
}
