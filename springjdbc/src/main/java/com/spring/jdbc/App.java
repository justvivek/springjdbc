package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
	private static ApplicationContext con;
    public static void main( String[] args )
    {
    	System.out.println("Program Started...........");
//    	spring jdbc ==> JdbcTemplate
    	
    	//ACCESSING/INJECTING USING XML FILE
//        con = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        //ACESSING/INJECTING USING JAVACONFIG FILE
        con = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        StudentDao sdao= con.getBean("studentDao", StudentDao.class);
        
        //INSERT new student into DB
        
//        Student s1= new Student(1234, "Hari", "UP");
//        int result = sdao.insert(s1);
//        System.out.println("Student added "+ result);
//        
//        s1= new Student(456, "Seeta", "UK");
//        result = sdao.insert(s1);
//        System.out.println("Student added "+ result);
        
        
        //UPDATE Student details whose id is 567
        
//        Student s = new Student();
//        s.setId(567);
//        s.setName("Babita");
//        s.setCity("CH");
//        
//        int result = sdao.updateInfo(s);
//        System.out.println("rows affected "+ result);
//        System.out.println("Student " +s.getName()+ " info updated ");
        
        
        //DELETE
//        int result = sdao.deleteInfo(234);
//        System.out.println("Rows Affected "+ result);
//        System.out.println("Row deleted where id=234 ");
        
        //SELECT single row from DB
//        Student s = sdao.getStudent(345);
//        System.out.println(s);
        
      //SELECT all row from DB
        List<Student> students = sdao.getAll();
        
        for(Student s: students) {
        	System.out.println(s);
        }
        
        
        
       // We have put this functionality into StudentDao interface and here we are just caling that
        // function
//        //insert query
//        String query = "insert into student(id, name, city) values(?,?,?)";
        
        //fire query
//        int result = template.update(query, 345, "Geeta", "HR");
        
//        System.out.println("number of rows affected "+ result);
        
        
    }
}
