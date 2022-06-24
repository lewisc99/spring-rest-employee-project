package com.lewis.springrest.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lewis.springrest.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void addEmployee( Employee employee);
	
	public Employee updateEmployee( int ind, Employee employee);
	
	public void deleteEmployee( int id);
	
}
