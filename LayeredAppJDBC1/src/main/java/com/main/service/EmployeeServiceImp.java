package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
import com.main.repository.IEmployeeDAO;

@Service
public class EmployeeServiceImp implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<Employee> fetchAllEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> list=dao.getEmployeeByDesgs(desg1, desg2, desg3);
		
		return list;
	}

}
