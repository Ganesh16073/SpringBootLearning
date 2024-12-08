package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.controller.LoginController;
import com.main.controller.PayrollOperationController;
import com.main.model.Employee;
import com.main.model.Login;

@SpringBootApplication
public class LayeredAppJdbc1Application {

	public static void main(String[] args)  {
		
		ApplicationContext cxt=SpringApplication.run(LayeredAppJdbc1Application.class, args);
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter the Email to login");
		String email=null;
		boolean validEmail=false;
		while(!validEmail)
		{
			try
			{
				email=sc.nextLine();
				if(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") )
				{
					validEmail=true;
				}
				else
				{
					System.out.println();
					System.out.println("Enter the valid mail");
					System.out.println();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("Enter the Pasword");
		
		String password=sc.nextLine();

		
		Login lg=cxt.getBean(Login.class);
		lg.setEmail(email);
		lg.setPassword(password);
		
		LoginController logC=cxt.getBean(LoginController.class);
		Boolean ValidAdmin;
		try
		{
			ValidAdmin=logC.isValidLogin(lg);
		}catch (Exception e) {
			ValidAdmin=false;
			e.printStackTrace();
		}
		if(!ValidAdmin)
		{
			System.out.println();
			System.out.println("Invalid Email or Password");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Try Again <<<<<<<<<<<<<<<<<<<<");
			System.out.println();
			System.out.println("============================= Exited ======================");
			System.out.println();
			
		}
		
		while(ValidAdmin)
		{
			PayrollOperationController pr=cxt.getBean(PayrollOperationController.class);
			
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
				    try {
				        System.out.println();
				        System.out.println("Enter the name of Employee:");
				        sc.nextLine(); // Clear the buffer
				        String ename = sc.nextLine();
				        
				        System.out.println("Enter the Job Title:");
				        String jobTitle = sc.nextLine();
				        
				        System.out.println("Enter the Salary of Employee:");
				        double sal = 0.0;
				        while (true) {
				            try {
				                sal = sc.nextDouble();
				                if (sal <= 0) {
				                    System.out.println("Salary must be positive. Please enter again:");
				                    continue;
				                }
				                break;
				            } catch (Exception e) {
				                System.out.println("Invalid salary! Please enter a numeric value:");
				                sc.next(); // Clear invalid input
				            }
				        }
				        
				        System.out.println("Enter the Department number:");
				        int dno = 0;
				        while (true) {
				            try {
				                dno = sc.nextInt();
				                if (dno <= 0) {
				                    System.out.println("Department number must be positive. Please enter again:");
				                    continue;
				                }
				                break;
				            } catch (Exception e) {
				                System.out.println("Invalid department number! Please enter a numeric value:");
				                sc.next(); // Clear invalid input
				            }
				        }

				        Employee emp = pr.getEmployee();
				        emp.setEname(ename);
				        emp.setJob(jobTitle);
				        emp.setSalary(sal);
				        emp.setDeptno(dno);

				        Boolean b = pr.addNewEmployee(emp);
				        if (b) {
				            System.out.println();
				            System.out.println("New Employee Added");
				        } else {
				            System.out.println();
				            System.out.println("Some Error is there...");
				        }

				    } catch (Exception e) {
				        System.out.println("An unexpected error occurred: " + e.getMessage());
				        e.printStackTrace();
				    }
				    break;
					
				case 2:
				    try {
				        System.out.println();
				        System.out.println("Enter the first Job Title:");
				        sc.nextLine(); // Clear the buffer
				        String job1;
				        while (true) {
				            job1 = sc.nextLine();
				            if (job1.isEmpty()) {
				                System.out.println("Job Title cannot be empty. Please enter again:");
				            } else {
				                break;
				            }
				        }

				        System.out.println("Enter the second Job Title:");
				        String job2;
				        while (true) {
				            job2 = sc.nextLine();
				            if (job2.isEmpty()) {
				                System.out.println("Job Title cannot be empty. Please enter again:");
				            } else {
				                break;
				            }
				        }

				        System.out.println("Enter the third Job Title:");
				        String job3;
				        while (true) {
				            job3 = sc.nextLine();
				            if (job3.isEmpty()) {
				                System.out.println("Job Title cannot be empty. Please enter again:");
				            } else {
				                break;
				            }
				        }

				        List<Employee> emp = pr.showEmployeeByDesg(job1, job2, job3);

				        if (emp.isEmpty()) {
				            System.out.println();
				            System.out.println("No employees found with the given job titles.");
				        } else {
				            System.out.println();
				            System.out.println("Employee Data is =>>");
				            emp.forEach((data) -> System.out.println(data));
				            System.out.println();
				        }

				    } catch (Exception e) {
				        e.printStackTrace();
				        System.out.println();
				        System.out.println("Some internal problem occurred.");
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
					System.out.println();
					ValidAdmin=false;
					running=true;
					break;
					
				default:
					System.out.println("<<<<<<<<<<<<<<<<<<<<< INVALID CHOICE >>>>>>>>>>>>>>>>>>>>>");
					ValidAdmin=false;
				}
			}

			
		} // while end
			
		
		
		

		((ConfigurableApplicationContext)cxt).close();
	}

}
