package com.main.runnerTest;

import java.util.Optional;

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
		

//		try
//		{
//			List<Customer> list=List.of(new Customer("Raja","hyd", 8555),
//					new Customer("Ram","Pune", 7755),
//					new Customer("Dhruv","Banglore", 10555));
//			String resultMsgg=service.registerCustomerGroup(list);
//			System.out.println(resultMsgg);
//			
//		}catch (Exception e) {
//			e.printStackTrace(); 
//		}
//		
//		try
//		{
//			boolean flag=service.isCustomerAvailable(1);
//			if(flag)
//			{
//				System.out.println("Customrt is Present");
//			}
//			else 
//			{
//				System.out.println("Customer is Not Present");
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println("Customer Count is =>> "+service.getCustomerCounnt());
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try
//		{
//			Iterable<Customer> all=service.getAllCustomer();
//			System.out.println("All Customer are =");
//			all.forEach(System.out::println);
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try
//		{
//			System.out.println("All Customer by id ");
//			Iterable<Customer> li=service.getCustomerByIds(List.of(1,2,4));// if we pass null it give nullpointer exceptions
//			li.forEach(System.out::println);
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
		try
		{
			System.out.println(" Customer by id ");
			Optional<Customer> li=service.getCustomerById(1);
			if(li.isPresent())
			{
				System.out.println("The Customer is "+li.get());
			}
			else
			{
				System.out.println("Not Valid Customer");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
