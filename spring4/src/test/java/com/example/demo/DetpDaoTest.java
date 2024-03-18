package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import com.example.demo.dao.*;
import com.example.demo.entity.*;

@SpringBootTest
public class DetpDaoTest {
	@Autowired
	private DeptDao deptDao;
	
	@Test
	public void findByDeptnoTest() {
		Dept dept = deptDao.findByDeptno(10L);
		System.out.println(dept);
	}
}





