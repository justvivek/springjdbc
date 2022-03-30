package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//INSERT
	public int insert(Student student) {
		
		//Insert query
		String query = "insert into student(id, name, city) values(?,?,?)";
		
		//Fire Query
		int result = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		
		return result;
	}
	
	//UPDATE
	public int updateInfo(Student student) {
		//Update Query
		String query= "update student set name=?, city=? where id=?";
		
		//fire query
		int result= jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}
	
	
	//DELETE
	public int deleteInfo(int id) {
		
		// Delete query
		String query = "delete from student where id=?";
		//Fire query
		int result = jdbcTemplate.update(query, id);
		return result;
	}
	
	//SELECT single row
	public Student getStudent(int id) {
		//select single student data
		
		String query = "select * from student where id=?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student s = jdbcTemplate.queryForObject(query, rowMapper, id);
		return s;
	}
	
	//SELECT Multiple Rows
	public List<Student> getAll() {
		String query = "select * from student";
		
		List<Student> lists= jdbcTemplate.query(query, new RowMapperImpl());
		return lists;
	}


}
