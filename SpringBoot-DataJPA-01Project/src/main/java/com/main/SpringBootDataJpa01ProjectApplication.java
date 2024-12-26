package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.entity.Customer;
import com.main.service.ICustomerManagementService;

@SpringBootApplication
public class SpringBootDataJpa01ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpa01ProjectApplication.class, args);
		
//		ICustomerManagementService service=cxt.getBean(ICustomerManagementService.class);
//		
//		try
//		{
//			Customer cust=new Customer();
//			cust.setName("Akhi");
//			cust.setCAdd("Pune");
//			cust.setBillAmt(2000);
//			String result=service.registerCustomer(cust);
//			System.out.println(result);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Some Error is there...............");
//		}
		
		
	}

}
