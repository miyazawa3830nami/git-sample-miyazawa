package com.example.controller;

import java.util.LinkedHashMap;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ex17")
public class Ex17QuestionnaireController {

	@RequestMapping("")
	public String index(Model model) {
		Map<Integer,String> genderMap = new LinkedHashMap<>();
		genderMap.put(1, "男");
		genderMap.put(2, "女");
		model.addAttribute("genderMap", genderMap);
		
		Map<Integer,String> hobbyMap = new LinkedHashMap<>();
		genderMap.put(1, "テニス");
		genderMap.put(2, "野球");
		genderMap.put(3, "ゴルフ");
		model.addAttribute("hobbyMap", hobbyMap);

//		Map<Integer,String> languageMap = new LinkedHashMap<>();
//		languageMap.put(1, "Java");
//		languageMap.put(2, "そのほか");
//		model.addAttribute("languageMap", languageMap);
		
		return "ex-17-input";
	}
}
