package com.main.service;

import java.util.Optional;

import com.main.entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer cust) ;
	public String registerCustomerGroup(Iterable<Customer> list);
	public Boolean isCustomerAvailable(Integer Id);
	public long getCustomerCounnt();
	public Iterable<Customer> getAllCustomer();
	public Iterable<Customer> getCustomerByIds(Iterable<Integer> ids);
	public Optional<Customer> getCustomerById(int id);
}
