package com.first.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstMvcApplication {

	public static void main(String[] args) {
		ApplicationContext cxt=SpringApplication.run(FirstMvcApplication.class, args);
	}

}
