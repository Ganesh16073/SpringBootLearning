package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;

import com.main.model.Employee;
import com.main.service.IEmployeeService;

@Controller
public class PayrollOperationController {
	
	@Lookup
	public  Employee getEmployee()
	{
		return null;
	}
	
	@Autowired
	private IEmployeeService service;
	
	public List<Employee> showEmployeeByDesg(String desg1,String desg2,String desg3) throws Exception
	{
		
		List<Employee> list=service.fetchAllEmployeeByDesgs(desg1, desg2, desg3);
				
		return list;
		
	}
	
	public Boolean addNewEmployee(Employee emp) throws Exception
	{
		
		return service.insertEmployee(emp);
		
	}
	
	public List<Employee> showAllEmployee() throws Exception
	{
		List<Employee> list=service.fetchAllEmployee();
		return list;
	}
	
	public Employee showEmployeByID(int id) throws Exception
	{
		Employee em=service.fetchEmployeeById(id);
		return em;
	}
	
	public Boolean deleteEmployeeById(int id)throws Exception
	{
		return service.removeEmployeeById(id);
	}
	
	public Boolean updateEmployeeNameByID(int id,String name) throws Exception
	{
		return service.editEmployeeNameById(id, name);
	}
	
	public boolean updateEmployeeJobById(int id, String job)throws Exception
	{
		return service.editEmployeeJobById(id, job);
	}
	
	public boolean updateEmployeeSalaryById(int id, double salary) throws Exception
	{
		
		return service.editEmployeeSalaryId(id, salary);
	}

}
