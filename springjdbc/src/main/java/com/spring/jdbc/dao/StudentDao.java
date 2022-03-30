package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	
	public int updateInfo(Student student);
	
	public int deleteInfo(int id);
	
	public Student getStudent(int id);
	
	public List<Student> getAll();
}
