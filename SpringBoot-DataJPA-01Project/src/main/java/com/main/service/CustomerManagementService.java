package com.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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


	@Override
	public String registerCustomerGroup(Iterable<Customer> list) {
		if(list!=null)
		{
			Iterable<Customer> cust=customerRepository.saveAll(list);
			
			int size=((Collection)cust).size();
			List<Integer> customer=new ArrayList<Integer>();
			
			cust.forEach(c->customer.add(c.getId()));
			
			return size+" no of Customer are Register having Id valuse are "+customer.toString();
			
			
		}
		else
		{
			throw new IllegalArgumentException("Invalid Inputes");
		
		}
		
		
	}



}
