package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	// 부서정보와 부서소속 사원정보 출력
	
	@GetMapping("/dept/read")
	public ModelAndView read(@RequestParam Long deptno) {
		Map<String, Object> map = deptService.read(deptno);
		return new ModelAndView("dept/read")
				.addObject("deptInfo",map);
		
	}
}
