package com.main.service;

import java.util.List;

import com.main.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> fetchAllEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;
	public Boolean insertEmployee(Employee emp) throws Exception;

}
