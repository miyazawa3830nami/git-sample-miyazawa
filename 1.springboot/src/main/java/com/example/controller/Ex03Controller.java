package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Ex03Controller {

	@RequestMapping("/show-image")
	public String showImage() {
		return "ex-03";
	}
}
