package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

// 사원목록, 사원정보, 사원추가 - EmpController
// 부서정보 - DeptController
// 로그인, 로그아웃 - LoginController

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public ModelAndView list() {
		return new ModelAndView("emp/list").addObject("list",empService.list());
		
	}
	
	@GetMapping("/emp/read")
	public ModelAndView read(@RequestParam Long empno) {
		return new ModelAndView("emp/read").addObject("emp",empService.read(empno));
	}
	
	@GetMapping("/emp/add")
	public ModelAndView add() {
		return new ModelAndView("emp/add").addObject("addInfo",empService.findAddInfo());
	}
	
	// @ModelAttribute : 사용자 입력으로 부터 겍체를 생성
	@PostMapping("/emp/add")
	public ModelAndView add(@ModelAttribute Emp emp) {
		empService.add(emp);
		return new ModelAndView("redirect:/");
	}
}
