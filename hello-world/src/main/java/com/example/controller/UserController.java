package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	/**
	 * 入力画面表示用
	 * @param model　モデル（リクエストスコープ）
	 * @return　入力画面
	 */
	
	@RequestMapping("")
	public String index(Model model) {
		
		//	趣味のマップを作る
		//	キーがid(Integer)、バリューが趣味名(String)
		//	キーのidはリクエストパラメータで送られてくる値用
		//	バリューは画面表示用の文字列用
		Map<Integer,String> hobbyMap = 
				new LinkedHashMap<>();
		hobbyMap.put(1, "野球");
		hobbyMap.put(2, "サッカー");
		hobbyMap.put(3, "テニス");
		
		//	趣味のマップをリクエストスコープに格納
		model.addAttribute("hobbyMap",hobbyMap);

		Map<Integer,String> genderMap = 
				new LinkedHashMap<>();
		genderMap.put(1, "男");
		genderMap.put(2, "女");
		genderMap.put(3, "そのほか");
		
		//	趣味のマップをリクエストスコープに格納
		model.addAttribute("genderMap",genderMap);
		
		//	入力画面にフォワード
		return "user/input";
	}
	
	/**
	 * ユーザー情報登録用
	 * ・formからリクエストパラメータを取得し、ドメインに詰め替える
	 * ・ドメインをServiceにわたす(DBへのINSERT実行)
	 * ・登録完了画面表示用にスコープにドメイン（入力されたユーザー情報）を保存
	 * ・登録完了画面に遷移させる
	 * 
	 * @param form　入力されたリクエストパラメータ
	 * @param redirectAttributes　flashスコープ
	 * @return　登録完了画面にフォワードするためだけのメソッドにリダイレクト
	 */
	
	@RequestMapping("/create")
	public String create(
			@Validated UserForm form
			, BindingResult result
			, RedirectAttributes redirectAttributes
			, Model model
			) {
		
		if (result.hasFieldErrors()) {
			return index(model);
		}
		//	Userドメインオブジェクトを作成
		//	Formから値を詰め替える
		User user = new User();
		
		//	便利なもので詰め替える
		//	詰め替えできる条件
		//	・プロパティ名が同じ
		//	・プロパティの型が同じ
		BeanUtils.copyProperties(form, user);
		
		//	上記でコピーされなかったhobbyListプロパティを手動コピー
		//	List<Integer>をList<String>に入れ替え
		List<String> hobbyList = new ArrayList<>();
		for(Integer hobbyCode : form.getHobbyList()) {
			switch (hobbyCode) {
			case 1:
				hobbyList.add("baseball");
				break;
			case 2:
				hobbyList.add("サッカー");
				break;
			case 3:
				hobbyList.add("テニス");
				break;
			}
//			List<String> genderList = new ArrayList<>();
//			for(Integer genderCode : form.getGenderList()) {
//				switch (genderCode) {
//				case 1:
//					genderList.add("男");
//					break;
//				case 2:
//					genderList.add("女");
//					break;
//				case 3:
//					genderList.add("そのほか");
//					break;
//				}
		}
		user.setHobbyList(hobbyList);
//		user.setHobbyList(genderList);
		
		//	実際の業務処理を行う+Serviceクラスの呼び出し
		UserService userService = new UserService();
		user = userService.save(user);
		
		//	受け取ったUserドメインオブジェクトをスコープに格納
		//	今回はダブルサブミット対策のため、リダイレクトをはさむ
		//	そのため、リダイレクトをはさんでも領域が保持されるflashスコープを使う
		redirectAttributes.addFlashAttribute("user", user);
		
		//	登録完了画面にフォワードするためだけのメソッドにリダイレクト
		return "redirect:/user/toresult";
	}
	/**
	 * 登録完了画面にフォワードするためだけ用
	 * 
	 * @return　登録完了画面
	 */
	@RequestMapping("/toresult")
	public String toResult() {
		return "/user/result";
	}
}
