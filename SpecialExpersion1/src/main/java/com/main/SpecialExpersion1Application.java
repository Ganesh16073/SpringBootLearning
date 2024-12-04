package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.DTO.copy.Student;

@SpringBootApplication
public class SpecialExpersion1Application {

	public static void main(String[] args) {
		ApplicationContext cxt=SpringApplication.run(SpecialExpersion1Application.class, args);
		Student s=cxt.getBean(Student.class); // performing Bulk Data Injection
		System.out.println(s);
	}

}
