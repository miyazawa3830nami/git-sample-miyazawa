package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class ReceiveNameController{
	
	@RequestMapping("")
	public String index() {
		return "name-form";
	}
	
	@RequestMapping("/receive1")
		public String receive1(String name){
			System.out.println(name);
			return "finished";
		}
}
