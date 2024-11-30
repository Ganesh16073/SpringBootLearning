package com.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.controller.PayrollOperationController;
import com.main.model.Employee;

@SpringBootApplication
public class LayeredAppJdbc1Application {

	public static void main(String[] args) {
		
		ApplicationContext cxt=SpringApplication.run(LayeredAppJdbc1Application.class, args);
		
		PayrollOperationController pr=cxt.getBean(PayrollOperationController.class);
		
		try
		{
			List<Employee> emp=pr.showEmployeeByDesg("Data Scientist", "Software Engineer", "Team Lead");
			System.out.println();
			System.out.println("Employee Data is =>> ");
			emp.forEach(data ->System.out.println(data));
			System.out.println();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Internal Problem");
		}
		
		((ConfigurableApplicationContext)cxt).close();
	}

}
