package com.example.demo.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.entity.*;

@Mapper
public interface EmpDao {
	// ename이 아이디고 empno가 비밀번호라면
	// 결과를 boolean으로 내보내기 -> 0이면 거짓, 0이 아니면 참
	
	@Select("select count(*) from emp where ename=#{ename} and empno=#{empno} and rownum=1")
	public Boolean findByEnameAndEmpno(String ename, Long empno);
	
	// insert, delete, update의 결과는 변경된 행의 개수(성공하면 1이상의 값)
	
	// 마이바티스는 insert할 때 null입력이 안된다(기본적으로)
	@Insert("insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(#{empno}, #{ename}, #{job}, #{mgr}, #{hiredate}, #{sal}, #{comm, jdbcType=INTEGER}, #{deptno})")
	public Long save(Emp emp);
	
	@Select("select max(empno) from emp")
	public Long max();
	
	@Select("select empno, ename, job, hiredate, deptno from emp order by empno asc")
	public List<Emp> findAll();
	
	@Select("select * from emp where empno=#{empno} and rownum=1")
	public Emp findByEmpno(Long empno);
	
	@Select("select * from emp where deptno=#{deptno}")
	public List<Emp> findByDeptno(Long deptno);
	
	@Select("select distinct job from emp")
	public List<String> findJobs();
	
	@Select("select distinct mgr from emp where mgr is not null")
	public List<Long> findMgrs();
	
	@Select("select distinct deptno from emp ")
	public List<Long> findDeptnos();
	
}










