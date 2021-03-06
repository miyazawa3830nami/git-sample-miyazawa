package com.example.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.User;
import com.example.form.Ex10ReceiveForm;

@Controller
@RequestMapping("/ex10")
public class Ex10Controller {

	// セッションスコープを使うための設定
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public Ex10ReceiveForm setUpForm() {
		return new Ex10ReceiveForm();
	}
	
	@RequestMapping("")
	public String index() {
		//入力画面にフォワード
		return "ex-10-input";
	}
	
	@RequestMapping("/input")
	public String inputs(String name, String age, String comment){
		User user = new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setComment(comment);
		
		//	セッションスコープに格納
		session.setAttribute("user", user);
		//	アウトプット画面にフォワード
		return "ex-10-output";
	}
	
	@RequestMapping("/output")
	public String output() {
		return "ex-10-output";
	}
	@RequestMapping("/output2")
	public String output2() {
		return "ex-10-output2";
	}
}
