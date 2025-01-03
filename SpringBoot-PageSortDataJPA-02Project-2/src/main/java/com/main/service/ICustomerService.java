package com.main.service;

import java.util.List;


import com.main.entity.Customer;


public interface ICustomerService{
	
	public String deleteCustomerByIds(List<Integer> ids);
	public Customer getCustomerById(int id);
	public List<Customer> showCustomerByExampleData(Customer customer,boolean ascOrder,String ...properties);
	public String groupCustomerRegistration(List<Customer> list);
}
