package com.main.runnerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.entity.Customer;
import com.main.service.ICustomerManagementService;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	ICustomerManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Customer cust=new Customer();
//		cust.setName("Akhi");
//		cust.setCAdd("Pune");
//		cust.setBillAmt(2000);
//		String result=service.registerCustomer(cust);
//		System.out.println(result);	
//		if(result==null)
//		{
//			System.out.println("Some Error is there...............");
//		}
		

		
		
		
	}

}
