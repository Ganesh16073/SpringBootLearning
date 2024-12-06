package com.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Employee;
import com.main.model.Login;

@Repository
public class EmployeeDAOImp implements IEmployeeDAO{

	public static final String CHECK_ADMIN_LOGIN="select * from Login where email=? and password=?";
	public static final String GET_EMPLOYEE_BY_DESEGINATION="select * from Employee where job in (?,?,?) order by eno ";
	public static final String ADD_EMPLOYEE = "INSERT INTO Employee (ename, job, salary, deptno) VALUES (?, ?, ?, ?)";
	public static final String GET_ALL_EMPLOYEE="select * from Employee";
	public static final String GET_EMPLOYEE_BY_ID="select * from employee where eno=?";
	public static final String DELETE_EMPLOYEE_BY_ID="delete from employee where eno=?";
	public static final String UPDATE_EMPLOYEE_NAME_BY_ID="update Employee set ename=? where eno=?";
	public static final String UPDATE_EMPLOYEE_JOB_BY_ID="update Employee set job=? where eno=?";
	public static final String UPDATE_EMPLOYEE_SALARY_BY_ID="update Employee set salary=? where eno=?";
	public static final String UPDATE_EMPLOYEE_DEPARTMENT_NUMBER_BY_ID="update Employee set deptno=? where eno=?";
	
	@Autowired
	public DataSource ds;
	
	@Override
	public Boolean isLogin(Login lg)throws Exception
	{
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(CHECK_ADMIN_LOGIN);)
		{
			ps.setString(1, lg.getEmail());
			ps.setString(2, lg.getPassword());
			
			try(ResultSet rs=ps.executeQuery();)
			{
				if(rs.next())
				{
					System.out.println("True");
					return true;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return false;
	}
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> emp=new LinkedList<>();
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMPLOYEE_BY_DESEGINATION);)
		{
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			try(ResultSet rs=ps.executeQuery();)
			{
				while(rs.next())
				{
					Employee e=new Employee();
					e.setEno(rs.getInt(1));          
					e.setEname(rs.getString(2));      
					e.setJob(rs.getString(3));        
					e.setSalary(rs.getDouble(4));     
					e.setDeptno(rs.getInt(5));        
					e.setGrossSalary(rs.getDouble(6));
					e.setNetSalary(rs.getDouble(7));  
					emp.add(e);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		return new ArrayList<>(emp);
	}

	@Override
	public Boolean addEmployee(Employee emp) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(ADD_EMPLOYEE);)
		{
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getDeptno());
			
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		
		List<Employee> list=new ArrayList<>();
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_ALL_EMPLOYEE);)
		{
			try(ResultSet rs=ps.executeQuery();)
			{
				while(rs.next())
				{
					Employee e=new Employee();
					e.setEno(rs.getInt(1));          
					e.setEname(rs.getString(2));      
					e.setJob(rs.getString(3));        
					e.setSalary(rs.getDouble(4));     
					e.setDeptno(rs.getInt(5));        
					e.setGrossSalary(rs.getDouble(6));
					e.setNetSalary(rs.getDouble(7)); 
					list.add(e);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		return new ArrayList<Employee>(list);
		
		
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) throws Exception {
		
		List<Employee> list=new ArrayList<>();
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMPLOYEE_BY_ID);)
		{
			ps.setInt(1,id);
			try(ResultSet rs=ps.executeQuery();)
			{
				while(rs.next())
				{
					Employee e=new Employee();
					e.setEno(rs.getInt(1));          
					e.setEname(rs.getString(2));      
					e.setJob(rs.getString(3));        
					e.setSalary(rs.getDouble(4));     
					e.setDeptno(rs.getInt(5));        
					e.setGrossSalary(rs.getDouble(6));
					e.setNetSalary(rs.getDouble(7)); 
					list.add(e);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list.stream().findFirst();
	}

	@Override
	public Boolean deleteEmployeeById(int id) throws Exception {
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(DELETE_EMPLOYEE_BY_ID);)
		{
			ps.setInt(1, id);
			
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return false;
	}

	@Override
	public Boolean updateEmployeeNameById(int id,String name) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_EMPLOYEE_NAME_BY_ID);)
		{
			ps.setString(1,name);
			ps.setInt(2, id);
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return false;
		
	}

	@Override
	public Boolean updateEmployeeJobById(int id, String job) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_EMPLOYEE_JOB_BY_ID);)
		{
			ps.setString(1,job);
			ps.setInt(2, id);
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return false;
	}

	@Override
	public Boolean updateEmployeeSalaryById(int id, double salary) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_EMPLOYEE_SALARY_BY_ID);)
		{
			ps.setDouble(1,salary);
			ps.setInt(2,id);
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return false;
	}

	@Override
	public Boolean updateEmployeeDepartmentNumberById(int id, int depNo) throws Exception {
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_EMPLOYEE_DEPARTMENT_NUMBER_BY_ID);)
		{
			ps.setInt(1, depNo);
			ps.setInt(2, id);
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return false;
	}

	

	

}
