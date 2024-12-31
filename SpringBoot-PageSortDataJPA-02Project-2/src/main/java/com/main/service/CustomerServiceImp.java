package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Customer;
import com.main.repository.ICustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository custRepo;
	
	@Override
	public String deleteCustomerByIds(List<Integer> ids) {
		List<Customer> list=custRepo.findAllById(ids);
		if(list.size()!=0)
		{
			custRepo.deleteAllByIdInBatch(ids);
			return list.size()+" No of Customer deleted";
		}
		
		return "No Customer was Found";
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer cus=custRepo.getReferenceById(id); // if id not found then it throws exception. do not use
		return cus;
	}

}
