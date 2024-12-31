package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.entity.Customer;
import com.main.service.CustomerServiceImp;

@Component
public class TestCustomer implements CommandLineRunner{

	public TestCustomer() {
		System.out.println("TestCustomer.TestCustomer()");
	}
	@Autowired
	CustomerServiceImp cusService;	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		try
//		{
//			System.out.println("HEllllllllll");
//			String mgs=cusService.deleteCustomerByIds(List.of(11,10));
//			System.out.println(mgs);
//		}catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//	}
	
	@Override
	public void run(String... args) throws Exception {
		
		try
		{
			Customer cust=cusService.getCustomerById(100); 
			System.out.println(cust==null?"No Customer":cust);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
