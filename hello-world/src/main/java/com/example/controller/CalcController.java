package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.CalcService;

@Controller
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private CalcService calcService;
	
	@RequestMapping("/add")
	public String add() {
		int num1 = 2;
		int num2 = 3;
		int resultOfAdd = calcService.add(num1, num2);
		
		System.out.println(num1+"+"+num2+"="+resultOfAdd);
		
		return "finished";
	}
	@RequestMapping("/sub")
	public String sub() {
		int num1 = 2;
		int num2 = 3;
		int resultOfAdd = calcService.sub(num1, num2);
		
		System.out.println(num1+"-"+num2+"="+resultOfAdd);
		
		return "finished";
	}
	@RequestMapping("/multi")
	public String multi() {
		int num1 = 2;
		int num2 = 3;
		int resultOfAdd = calcService.multi(num1, num2);
		
		System.out.println(num1+"×"+num2+"="+resultOfAdd);
		
		return "finished";
	}
	@RequestMapping("/div")
	public String div() {
		int num1 = 6;
		int num2 = 3;
		int resultOfAdd = calcService.div(num1, num2);
		
		System.out.println(num1+"÷"+num2+"="+resultOfAdd);
		
		return "finished";
	}
}
