package com.example.form;

public class Ex06Form {
	/** 名前 */
	private String name;
	/** 年齢 */
	private String age;
	
	/** コメント */
	private String comment;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "ex06Form [name=" + name + ", age=" + age + "]";
	}
	
}
