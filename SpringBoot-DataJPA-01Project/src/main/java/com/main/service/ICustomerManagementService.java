package com.main.service;

import com.main.entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer cust) ;
	public String registerCustomerGroup(Iterable<Customer> list);
	public Boolean isCustomerAvailable(Integer Id);
	public long getCustomerCounnt();
	public Iterable<Customer> getAllCustomer();
}
