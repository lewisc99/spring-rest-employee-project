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
	public List<Employee> getEmployees(int pagNumber, int pagSize) {
	 
	return	employeeDAO.getEmployees(pagNumber,pagSize);
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
	@Transactional
	public Employee updateEmployee(int id, Employee employee) {
		
		return  employeeDAO.updateEmployee(id, employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeDAO.deleteEmployee(id);
		
	}

}
