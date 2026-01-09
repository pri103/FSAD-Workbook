package com.example.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.model.Student;
	
public class MainApp {
	    public static void main(String[] args) {

	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("application.xml");

	        Student student = context.getBean("student", Student.class);
	        student.display();
	    }
	}
