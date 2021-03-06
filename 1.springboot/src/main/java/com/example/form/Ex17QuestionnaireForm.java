package com.example.form;

import java.util.List;

public class Ex17QuestionnaireForm {
	
	private String name;
	private String mail;
	private List<Integer> genderList;
	private List<Integer> hobbyList;
	private String language;
	private String comment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Integer> getGenderList() {
		return genderList;
	}
	public void setGenderList(List<Integer> genderList) {
		this.genderList = genderList;
	}
	public List<Integer> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Integer> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Ex17QuestionnaireForm [name=" + name + ", mail=" + mail + ", genderList=" + genderList + ", hobbyList="
				+ hobbyList + ", language=" + language + ", comment=" + comment + "]";
	}
}
