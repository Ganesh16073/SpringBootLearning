package com.main.service;

import java.util.List;

import com.main.model.Employee;
import com.main.model.Login;

public interface IEmployeeService {
	
	public Boolean checkValidLogin(Login lg)throws Exception;
	public List<Employee> fetchAllEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception;
	public Boolean insertEmployee(Employee emp) throws Exception;
	public List<Employee> fetchAllEmployee() throws Exception;
	public Employee fetchEmployeeById(int id) throws Exception;
	public Boolean removeEmployeeById(int id) throws Exception;
	public Boolean editEmployeeNameById(int id, String name)throws Exception;
	public Boolean editEmployeeJobById(int id, String job)throws Exception;
	public Boolean editEmployeeSalaryId(int id, Double salary) throws Exception;
	public Boolean editEmployeeDepartNoById(int id,int deptno)throws Exception;

}
