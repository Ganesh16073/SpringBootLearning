package com.main.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.service.CustomerServiceImp;

@Component
public class TestCustomer implements CommandLineRunner{

	public TestCustomer() {
		System.out.println("TestCustomer.TestCustomer()");
	}
	@Autowired
	CustomerServiceImp cusService;
	@Override
	public void run(String... args) throws Exception {
		
		try
		{
			System.out.println("HEllllllllll");
			String mgs=cusService.deleteCustomerByIds(List.of(11,10));
			System.out.println(mgs);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
