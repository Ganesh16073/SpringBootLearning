package com.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Employee;

@Repository
public class EmployeeDAOImp implements IEmployeeDAO{

	public static String GET_ALL_EMPLOYEE="select * from Employee where job in (?,?,?) order by job ";
	
	@Autowired
	public DataSource ds;
	
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> emp=new ArrayList<>();
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_ALL_EMPLOYEE);)
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
		
		return emp;
	}

}
