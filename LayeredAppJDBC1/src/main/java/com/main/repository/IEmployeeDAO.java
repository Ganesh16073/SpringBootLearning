package com.main.repository;

import java.util.List;
import java.util.Optional;

import com.main.model.Employee;
import com.main.model.Login;

public interface IEmployeeDAO {
	
	public Boolean isLogin(Login lg)throws Exception;
	public List<Employee> getEmployeeByDesgs(String desg1,String desg2,String desg3) throws Exception;
	public Boolean addEmployee(Employee emp) throws Exception;
	public List<Employee> getAllEmployee() throws Exception;
	public Optional<Employee> getEmployeeById(int id) throws Exception;
	public Boolean deleteEmployeeById(int id) throws Exception;
	public Boolean updateEmployeeNameById(int id,String name) throws Exception;
	public Boolean updateEmployeeJobById(int id,String job) throws Exception;
	public Boolean updateEmployeeSalaryById(int id, double salary)throws Exception;
	public Boolean updateEmployeeDepartmentNumberById(int id, int depNo)throws Exception;
	
}
