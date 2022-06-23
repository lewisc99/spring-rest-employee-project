package com.lewis.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springrest.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	
	@Autowired
	private SessionFactory session;
	
	@Override
	public List<Employee> getEmployees() {
		
		
		try {
			
		
	
		Session currentSession = session.getCurrentSession();
		
		List<Employee> employees = currentSession.createQuery("from Employee order by id").getResultList();
		
		return employees;
		}
		catch (Exception e)
		{
			e.getStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	

	@Override
	public Employee getEmployeeById(int id) {
	 
		
		try {
			Session currentSession = session.getCurrentSession();
			
			Employee employeeById = currentSession.get(Employee.class, id);
			
			
			return employeeById;
			
		}
		catch( Exception e)
		{
			e.getStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void addEmployee(Employee employee) {
	
		try
		{
			
			Session currentSession = session.getCurrentSession();
			
			employee.setId(0);
			currentSession.save(employee);
			
			
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}
