package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receive")
public class Ex04Controller {

	@RequestMapping("")
	public String index() {
		return "ex-04";
	}

	@RequestMapping("/receive-info")
	public String receiveInfo(String mail,String pass) {
		if(mail.equals("abc@gmail.com") && pass.equals("abc")) {
			return "ex-04-success";
		} else {
			return "ex-04-failure";
		}
	}

}
