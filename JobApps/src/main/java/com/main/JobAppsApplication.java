package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JobAppsApplication {

	public static void main(String[] args) {
		ApplicationContext cxt=SpringApplication.run(JobAppsApplication.class, args);
	}

}