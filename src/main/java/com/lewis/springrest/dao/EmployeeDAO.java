package com.lewis.springrest.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lewis.springrest.entity.Employee;

public interface EmployeeDAO {

	
	public List<Employee> getEmployees(int pagNumber, int pagSize);
	
	public Employee getEmployeeById(int id);
	
	public void addEmployee(@RequestBody Employee employee);
	
	public Employee updateEmployee(int id, @RequestBody Employee employee);
	
	public void deleteEmployee(@PathVariable int id);
}
