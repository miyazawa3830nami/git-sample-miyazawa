package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/execute")
	public String execute() {
		Employee employee = new Employee();
		
		//	1人分の従業員情報のドメインオブジェクトの作成
		employee.setName("山田太郎");
		employee.setAge(20);
		employee.setGender("男");
		employee.setDepartmentId(1);
		
		//	作った従業員情報（のドメインオブジェクト）をDBにINSERT
		service.save(employee);
		
		//	ID3の従業員を検索してドメインオブジェクト取得
		Employee employee2 = service.load(3);
		System.out.println(employee2);
		
		//	ID3の従業員を削除
		service.deleteById(3);
		
		//	全従業員を検索して表示
		service.findAll().forEach(System.out::println);
		
		return "finished";
	}
}
