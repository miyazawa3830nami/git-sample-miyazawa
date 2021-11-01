package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application-scope")
public class ApplicationScopeController {

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String count() {
		Integer count = (Integer)application.getAttribute("count");
		if(count == null) {
			count = 0;
		}
		++ count;
		application.setAttribute("count", count);
		return "result-application-scope";
	}
}
