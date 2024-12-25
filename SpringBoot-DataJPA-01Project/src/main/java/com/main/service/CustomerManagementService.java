package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;

@Service("customerManagement")
public class CustomerManagementService implements ICustomerManagementService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public String registerCustomer(Customer cust) {
		System.out.println("Cust object Data is "+cust);
		Customer c=customerRepository.save(cust);
		return "The Customer obj is Saved (Record inserted) having the id value : "+c.getId();
	}



}
