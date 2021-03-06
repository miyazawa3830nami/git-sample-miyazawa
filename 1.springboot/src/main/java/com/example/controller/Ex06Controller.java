package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Ex06Form;

@Controller
@RequestMapping("/ex06")
public class Ex06Controller {

	@ModelAttribute
	public Ex06Form setUpForm() {
		return new Ex06Form();
	}
	@RequestMapping("")
	public String index() {
		return "ex-06";
	}
	
	@RequestMapping("/receive-info")
	public String receiveInfo(Ex06Form ex06Form) {
		System.out.println("入力された名前は" + ex06Form.getName());
		System.out.println("入力された年齢は" + ex06Form.getAge());
		System.out.println("コメントは" + ex06Form.getComment());
		return "finished";
	}
	
}
