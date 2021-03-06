package com.example.domain;

import java.util.List;

public class Questionnaire {
	
	private String name;
	private String mail;
	private List<String> genderList;
	private List<String> hobbyList;
	private String language;
	private String comment;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	public List<String> getGenderList() {
		return genderList;
	}
	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}
	
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
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
		return "Questionnaire [name=" + name + ", mail=" + mail + ", genderList=" + genderList + ", hobbyList="
				+ hobbyList + ", language=" + language + ", comment=" + comment + "]";
	}
	
}
