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
			System.out.println("-------------------------------------------------");
			System.out.println("|  Enter the Choice                             |");
			System.out.println("|  1: Add New Employee                          |");
			System.out.println("|  2: Get Employee by 3 Job Title               |");
			System.out.println("|  3: Get All Employee                          |");
			System.out.println("|  4: Get Employee by Id                        |");
			System.out.println("|  5: Delete employee by Id                     |");
			System.out.println("|  6: Update Employee Name By Id                |");
			System.out.println("|  7: Update Employee Job Title By Id           |");
			System.out.println("|  8: Update Employee Salary By Id              |");
			System.out.println("|  9: Update Employee Department Number By Id   |");
			System.out.println("|  10: Exit                                     |");
			System.out.println("-------------------------------------------------");
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
						System.out.println();
						System.out.println("NEw Empoloyee Added");
					}
					else
					{
						System.out.println();
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
					System.out.println();
					System.out.println("Some Internal Problem");
				}
				break;
				
			case 3:
				try
				{
					System.out.println();
					System.out.println("The All Employees of our Orginazation are =>>");
					List<Employee> list=pr.showAllEmployee();
					System.out.println();
					list.forEach(employee -> {
						System.out.println(employee);
					});
					System.out.println();
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println();
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
						System.out.println();
						System.out.println("Employee Not Found by id "+id);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				
				try {
					System.out.println("Enter the id to delete Employee");
					int id=sc.nextInt();
					boolean b=pr.deleteEmployeeById(id);
					if(b)
					{
						System.out.println();
						System.out.println("Employee Deleted Sucessfull........");
					}
					else
					{
						System.out.println();
						System.out.println("Employee Not found");
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
				
			case 6:
				try
				{
					System.out.println();
					System.out.println("Enter the name to Id");
					int id=sc.nextInt();
					System.out.println("Enter the name to update");
					sc.nextLine();
					String str=sc.nextLine();
					boolean b=pr.updateEmployeeNameByID(id, str);
					if(b)
					{
						System.out.println();
						System.out.println("Employee Name Is Updated");
					}
					else
					{
						System.out.println();
						System.out.println("Employee Not founnd");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 7:
				try
				{
					System.out.println();
					System.out.println("Enter the Id to Update Job Of Employee");
					int id=sc.nextInt();
					System.out.println("enter the Job Title");
					sc.nextLine();
					String Jtitle=sc.nextLine();
					boolean b=pr.updateEmployeeJobById(id, Jtitle);
					if(b)
					{
						System.out.println();
						System.out.println("Employee Job Title Is Changed");
					}
					else
					{
						System.out.println();
						System.out.println("Employee Not Found");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 8:
				try
				{
					System.out.println();
					System.out.println("Enter the Employee Id to Update The Salary");
					int id=sc.nextInt();
					System.out.println("Enter the Emeplyee Salary to Update Salary");
					double sal=sc.nextDouble();
					boolean b=pr.updateEmployeeSalaryById(id, sal);
					if(b)
					{
						System.out.println("Employee Salary Is Updated");
					}
					else
					{
						System.out.println("Employee Salary is Not Updated");
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 9:
				try {
					System.out.println("Enter the Employee Id to update Employee Department");
					int id=sc.nextInt();
					System.out.println("Enter the Department Number to Updated");
					int dep=sc.nextInt();
					boolean b=pr.updateEmployeeDepartNo(id, dep);
					if(b)
					{
						System.out.println("The Employee Department is Updated");
					}
					else
					{
						System.out.println("Something is went wrong");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 10:
				System.out.println();
				System.out.println("=========================== Exited =========================");
				running=true;
				break;
				
			default:
				System.out.println("<<<<<<<<<<<<<<<<<<<<< INVALID CHOICE >>>>>>>>>>>>>>>>>>>>>");
			}
		}


		((ConfigurableApplicationContext)cxt).close();
	}

}
