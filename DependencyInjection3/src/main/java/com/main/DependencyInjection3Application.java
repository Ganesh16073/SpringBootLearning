package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.main.model.Cricketer;

@SpringBootApplication
@ImportResource("com/main/config/applicationContext.xml") // importing xml file
public class DependencyInjection3Application {

	public static void main(String[] args) {
		ApplicationContext cxt=SpringApplication.run(DependencyInjection3Application.class, args);
		Cricketer c=cxt.getBean(Cricketer.class);
		
		String message=c.Batting();
		System.out.println(message);
		
	}

}
