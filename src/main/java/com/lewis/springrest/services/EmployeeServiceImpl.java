package com.lewis.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springrest.dao.EmployeeDAO;
import com.lewis.springrest.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
	 
	return	employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
	 
		
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		 
		employeeDAO.addEmployee(employee);
		
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
