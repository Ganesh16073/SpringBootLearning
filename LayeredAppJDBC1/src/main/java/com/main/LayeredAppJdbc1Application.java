package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.controller.PayrollOperationController;
import com.main.model.Employee;

@SpringBootApplication
public class LayeredAppJdbc1Application {
	

	public static void main(String[] args)  {
		
		ApplicationContext cxt=SpringApplication.run(LayeredAppJdbc1Application.class, args);
		
		PayrollOperationController pr=cxt.getBean(PayrollOperationController.class);
		Scanner sc=new Scanner(System.in);
		boolean running=false;
		
		while(!running)
		{
			System.out.println("Enter the Choice ");
			System.out.println("1: Add New Employee");
			System.out.println("2: Get Employee by 3 Job Title");
			System.out.println("3: Get All Employee ");
			System.out.println("4: Get Employee by Id");
			System.out.println("5: Exit");
			int choice=sc.nextInt();
			switch(choice)
			{	
			case 1:
				try
				{
					System.out.println();
					System.out.println("Enter the name of Employee");
					sc.nextLine();
					String ename=sc.nextLine();
					System.out.println("Ente the Job Title");
					String jobTitle=sc.nextLine();
					System.out.println("Ente the Salary of Employee");
					double sal=sc.nextDouble();
					System.out.println("Enter the Depart number");
					int dno=sc.nextInt();
					
					Employee emp=pr.getEmployee();
					emp.setEname(ename);
					emp.setJob(jobTitle);
					emp.setSalary(sal);
					emp.setDeptno(dno);
					
					Boolean b=pr.addNewEmployee(emp);
					if(b)
					{
						System.out.println("NEw Empoloyee Added");
					}
					else
					{
						System.out.println("Some Erroe is there.......................");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				try
				{
					
					System.out.println();
					System.out.println("Enter the Job 3 titile");
					sc.nextLine();
					String job1=sc.nextLine();
					System.out.println("Enter the Job 2");
					String job2=sc.nextLine();
					System.out.println("Enter the hob 3");
					String job3=sc.nextLine();
					List<Employee> emp=pr.showEmployeeByDesg(job1,job2,job3);
					System.out.println();
					System.out.println("Employee Data is =>> ");
					emp.forEach((data) -> System.out.println(data));
					System.out.println();
					
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("Some Internal Problem");
				}
				break;
				
			case 3:
				try
				{
					System.out.println("The All Employees of our Orginazation are =>>");
					List<Employee> list=pr.showAllEmployee();
					list.forEach(employee -> System.out.println(employee));
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("Some Internal Problem");
				}
				break;
				
			case 4:
				try
				{
					System.out.println("Enter the Id Of Employee to findout Employee");
					int id=sc.nextInt();
					Employee emp=pr.showEmployeByID(id);
					System.out.println(emp);
					if(emp==null)
					{
						System.out.println("Employee Not Found by id "+id);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
				
			case 5:
				System.out.println();
				System.out.println("=========================== Exited =========================");
				running=true;
			}
		}
		
		
		
		((ConfigurableApplicationContext)cxt).close();
	}

}
