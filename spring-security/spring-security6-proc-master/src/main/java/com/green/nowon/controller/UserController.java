package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.UserSaveDTO;
import com.green.nowon.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService service; //DI
	
	//회원가입
	@PostMapping("/signup")
	public String signup(UserSaveDTO dto) { //파라미터 UserSaveDTO dto 앞에 @RequestBody 생략되어있음
		service.saveProcess(dto);
		return "redirect:/";
	}

}
