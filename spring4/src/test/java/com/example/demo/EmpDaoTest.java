package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import com.example.demo.dao.*;

@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void findByEnameAndEmpnoTest() {
		assertEquals(true, empDao.findByEnameAndEmpno("SMITH", 7369L));
	}
}




