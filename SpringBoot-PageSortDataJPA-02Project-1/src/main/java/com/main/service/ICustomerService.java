package com.main.service;

import org.springframework.data.domain.Page;

import com.main.entity.Customer;

public interface ICustomerService {

	public Iterable<Customer> getAllCustomers(boolean ascOrder,String ...properties);
	public Page<Customer> getCustomerByPageNo(int pageNo,int pageSize);
	public Page<Customer> getSortedCustomerByPage(int pageNo,int pageSize,boolean order,String ...properties);
	public void showCustomersPageByPage(int pageSize);
}
 