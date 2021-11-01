package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam2")
public class ExamThymeleafController {

	@RequestMapping("")
	public String index() {
		return "ex-thymeleaf-input";
	}
	
	@RequestMapping("/result")
	public String result() {
		
		return "ex-thymeleaf-result";
	}
}
