package com.main;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.main.model.WishMessage;

@SpringBootApplication
public class WishMessageGeneratorApplication {
	
	@Bean
	public LocalTime createTime()
	{
		return LocalTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext cxt= SpringApplication.run(WishMessageGeneratorApplication.class, args);
		WishMessage w=cxt.getBean("wishMessage",WishMessage.class);
		
		String message=w.getMessage();
		System.out.println();
		System.out.println("Wishing Message is =>> "+message);
	}

}
