package com.main.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		
		return new LinkedList<Employee>(list);
	}

	@Override
	public Boolean insertEmployee(Employee emp) throws Exception {
		Boolean b=dao.addEmployee(emp);
		return b;
	}

	@Override
	public List<Employee> fetchAllEmployee() throws Exception {
		List<Employee> list=dao.getAllEmployee();
		return new LinkedList<Employee>(list);
	}

	@Override
	public Employee fetchEmployeeById(int id) throws Exception {
		Optional<Employee> emp=dao.getEmployeeById(id);
		return emp.orElse(null);
	}

	@Override
	public Boolean removeEmployeeById(int id) throws Exception {
		boolean b=dao.deleteEmployeeById(id);
		return b;
	}

	@Override
	public Boolean editEmployeeNameById(int id, String name) throws Exception {
		boolean b=dao.updateEmployeeNameById(id, name);
		return b;
	}

}
