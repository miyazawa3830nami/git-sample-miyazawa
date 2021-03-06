package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	// DB操作用のクラス
	// @Autowiredがついているため自動的にDIされる
	@Autowired
	private NamedParameterJdbcTemplate template;

	@RequestMapping("/execute")
	public String execute() {
		
		// SQLの作成、プレースホルダは「:~~~」でしめす
		String sql = "SELECT count(*) FROM employees WHERE id = :firstId OR id = :secondId";
		
		// プレースホルダに設定するパラメータを指定する
		// addValue(プレースホルダ名, 設定値)のように指定。何度も.addValue()で繋げられる
		// プレースホルダ無しの場合は、ただnewするだけでOK
		SqlParameterSource param = new MapSqlParameterSource().addValue("firstId", 1).addValue("secondId", 3);
		
		// SQLを実行
		// queryForObject(実行するSQL, パラメータオブジェクト, 受け取りたいデータ型クラス)で指定する
		// 今回は、count(*)で得られた取得行数を、Integerで取得する
		Integer result = template.queryForObject(sql, param, Integer.class);
		
		// SQLの取得結果をコンソールに表示
		System.out.println("result = " + result);

		return "finished";
	}
	
	@RequestMapping("/ex23")
	public String ex() {
		String sql = "SELECT count(*) FROM departments WHERE name = :firstName OR name = :secondName;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("firstName", "総務部").addValue("secondName", "技術部");
		
		Integer result = template.queryForObject(sql, param, Integer.class);
		
		System.out.println("result=" + result );
		return "finished";
	}
	
}
