package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.User;

@Service
public class UserService {
	
	public User save(User user) {
		
		//	UserRepository呼び出し（INSERT実行)
		//	あるいは他のRepositoryの呼び出し(INSERT実行)
		//	今回は省略

		//	登録完了メールを送る
		//	今回は省略
		
		return user;
	}
}
