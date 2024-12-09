package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootWeb1Application {

	public static void main(String[] args) {
		ApplicationContext cxt=SpringApplication.run(SpringBootWeb1Application.class, args);
		
//		((ConfigurableApplicationContext)cxt).close();
	}

}
