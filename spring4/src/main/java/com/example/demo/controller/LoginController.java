package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import jakarta.servlet.http.*;

@Controller
public class LoginController {
	@Value("${sample3.admin.username}")
	private String USERNAME;
	@Value("${sample3.admin.password}")
	private String PASSWORD;
	
	// Get : 화면, 서버 정보를 변경하지 않는 작업
	// 리턴이 void -> View만 있다 -> 뷰의 이름과 주소가 동일 
	@GetMapping("/member/login")
	public void login() {
	}	
	
	// Post : 처리, 서버 정보를 변경 
	@PostMapping("/member/login")
	public ModelAndView login(@RequestParam String username, 
			@RequestParam String password, HttpSession session) {
		// spring, 1234면 로그인이 된다
		if(username.equals(USERNAME) && password.equals(PASSWORD)) {
			session.setAttribute("username", username);
		}
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/member/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	
}
