package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.FactorialService;

@Controller
@RequestMapping("/factorial")
public class FactorialController {

	@Autowired
	private FactorialService service;
	
	@RequestMapping("/view-result")
	public String viewResult(Model model) {
		model.addAttribute("answer", service.getResult(5));
		return "ex22result";
	}
}
