package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class FactorialService {
	public int getResult(int num) {
		int answer = 1;
		for(int i =1; i <= num; ++i) {
			answer = answer*i;
		}
		return answer;
	}
}
