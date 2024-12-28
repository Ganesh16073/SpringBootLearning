package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	private CustomerRepository cusRepo;
	
	@Override
	public Iterable<Customer> getAllCustomers(boolean ascOrder, String... properties) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		Iterable<Customer> it=cusRepo.findAll(sort);
		return it; 
	}

	@Override
	public Page<Customer> getCustomerByPageNo(int pageNo, int pageSize) {
		// Prepare Pageable Object
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		//Get Requested Page Details
		Page<Customer> page=cusRepo.findAll(pageable);
		return page;
	}

}
