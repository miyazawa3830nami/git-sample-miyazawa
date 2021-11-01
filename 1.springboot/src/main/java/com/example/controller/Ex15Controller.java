package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ex15")
public class Ex15Controller {

	@RequestMapping("")
	public String index(Model model) {
		//	チームリスト
		List<List<String>> teamList = new ArrayList<>();
		
		//	タイトルリスト
		List<String> titleList = new ArrayList<>();
		titleList.add("チーム名");
		titleList.add("先蜂");
		titleList.add("中堅");
		titleList.add("大将");
		teamList.add(titleList);
		
		//	Aチーム
		List<String> memberAList = new ArrayList<>();
		memberAList.add("Aチーム");
		memberAList.add("伊藤");
		memberAList.add("佐藤");
		memberAList.add("斎藤");
		teamList.add(memberAList);
		
		//	Bチーム
		List<String> memberBList = new ArrayList<>();
		memberBList.add("Bチーム");
		memberBList.add("宇賀");
		memberBList.add("伊賀");
		memberBList.add("大賀");
		teamList.add(memberBList);
		
		return "ex-XX";
	}
}
