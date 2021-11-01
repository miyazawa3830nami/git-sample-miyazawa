package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ex14")
public class Ex14Controller {

	@RequestMapping("")
	public String index(Model model) {
		
		List<String> memberName = new ArrayList<>();
		memberName.add("山田");
		memberName.add("鈴木");
		memberName.add("伊藤");
		memberName.add("吉田");
		memberName.add("佐藤");
		
		model.addAttribute("memberName",memberName);
		
		return "ex-14";
	}
}
