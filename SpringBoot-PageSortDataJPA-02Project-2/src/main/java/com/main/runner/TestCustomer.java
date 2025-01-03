package com.main.runner;

import java.util.List;

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
	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		try
//		{
//			Customer cust=cusService.getCustomerById(100); 
//			System.out.println(cust==null?"No Customer":cust);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Override
	public void run(String... args) throws Exception {
		Customer cust=new Customer();
		cust.setName("Don");
		cust.setCusAdd("XYZ");
		
		List<Customer> list=cusService.showCustomerByExampleData(cust, true, "bilAmt","name");
		if(list.size()!=0)
		{
			list.forEach(System.out::println);
			
		}else
		{
			System.out.println("No Data Found");
		}
		
	}

}
