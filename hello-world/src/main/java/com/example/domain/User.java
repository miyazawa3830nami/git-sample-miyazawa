package com.example.domain;

import java.util.List;

public class User {

	//	ID
	private Integer id;
	
	//	名前
	private String name;

	//	メールアドレス
	private String email;
	
	//	パスワード
	private String password;
	
	//	趣味リスト
	private List<String> hobbyList;
	
	//	ラジオボタン
	private List<String> genderList;

	//	getterとsetter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", hobbyList="
				+ hobbyList + ", genderList=" + genderList + "]";
	}
	
}
