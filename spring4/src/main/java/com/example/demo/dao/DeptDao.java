package com.example.demo.dao;

import org.apache.ibatis.annotations.*;

import com.example.demo.entity.*;

@Mapper
public interface DeptDao {
	@Select("select * from dept where deptno=#{deptno} and rownum=1")
	public Dept findByDeptno(Long deptno);
}
