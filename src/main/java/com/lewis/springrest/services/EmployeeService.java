package com.lewis.springrest.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lewis.springrest.dto.EmployeesDTO;
import com.lewis.springrest.entity.Employee;

public interface EmployeeService {

	
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee);
	
	public Employee getEmployeeById(int id);
	
	public void addEmployee( Employee employee);
	
	public Employee updateEmployee( int ind, Employee employee);
	
	public void deleteEmployee( int id);
	
}
