package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.main.entity.Customer;
import com.main.service.ICustomerService;

@Component
public class PandSRepoRunner implements CommandLineRunner{

	@Autowired
	ICustomerService service;
	
//	@Override // for Sorting
//	public void run(String... args) throws Exception {
//		service.getAllCustomers(true, "billAmt").forEach(System.out::println);
//		
//	}
	
	
//	@Override
//	public void run(String... args) throws Exception {
//		Page<Customer> page=service.getCustomerByPageNo(0, 4);
//		System.out.println("The Requeste Data is::");
//		page.getContent().forEach(System.out::println);// getContent is used to get data from page
//		
//		System.out.println("Total Pages are "+page.getTotalPages());// return total Page number
//		System.out.println("Current page number is ::"+page.getNumber());
//		System.out.println("Total Number of Records "+page.getTotalElements());
//		System.out.println("Records in theCurrent Requested Page"+page.getNumberOfElements());
//		System.out.println("Is the Requested Page is First page "+page.isFirst());
//		System.out.println("Is the Requested Page is Last page "+page.isLast());
//		
//	}
	@Override
	public void run(String... args) throws Exception {
		
		Page<Customer> page=service.getSortedCustomerByPage(0, 3, true, "billAmt");
		page.getContent().forEach(System.out::println);
	}

}
