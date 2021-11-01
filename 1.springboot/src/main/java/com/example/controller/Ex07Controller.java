package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Ex07Form;

@Controller
@RequestMapping("/ex07")
public class Ex07Controller {

	@ModelAttribute
	public Ex07Form setUpForm() {
		return new Ex07Form();
	}
	
	@RequestMapping("")
	public String index() {
		return "ex-07";
	}
	
	@RequestMapping("/calc")
	public String calc(Ex07Form ex07Form) {
		System.out.println("計算結果は" + ex07Form.getIntNum1() * ex07Form.getIntNum2());
		return "finished";
	}
	
}
