package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> fetchAllEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;
	public Boolean insertEmployee(Employee emp) throws Exception;
	public List<Employee> fetchAllEmployee() throws Exception;
	public Employee fetchEmployeeById(int id) throws Exception;

}
