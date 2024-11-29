package com.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.model.Vehical;

@SpringBootApplication
public class DependencyInjection2Application {

	public static void main(String[] args) {
		ApplicationContext cxt= SpringApplication.run(DependencyInjection2Application.class, args);
		
		Vehical v=cxt.getBean("vehical",Vehical.class);
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Starting point of Destination");
		String start=sc.nextLine();
		System.out.println("Enter the End point of Destination");
		String end=sc.nextLine();
		System.out.println();
		v.journey(start, end);
		
		((ConfigurableApplicationContext)cxt).close();
	}

}
