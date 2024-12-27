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
	public Customer fetchCustomerById(Integer id);
	public String adjustCustomerBillAmount(int id, double discountPercentage);
	public String registerOrUpdateCustumerDetails(Customer customer);
	public String removeCustumerById(int id);
	public String removeCustumer(Customer cust);
}
