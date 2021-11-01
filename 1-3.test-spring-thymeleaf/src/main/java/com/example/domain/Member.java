package com.example.domain;

import java.util.List;

public class Member {

	private String name;
	private Integer age;
	private List<String> hobbyList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", hobbyList=" + hobbyList + "]";
	}
	
}
