package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {

	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	
	@RequestMapping("/result")
	public String result(String mail, String pass, Model model) {
		if(mail.equals("yamada@sample.com") && pass.equals("yamayama")) {
			model.addAttribute("result", "成功");
		} else {
			model.addAttribute("result", "失敗");
		}
		
		return "exam01-result";
	}
}
