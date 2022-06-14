package com.lewis.springrest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
	
	
	private List<Employee> employees = new ArrayList<>();
	
	
	@PostConstruct
	public void Load()
	{
		Employee employee1 = new Employee(1,"Fernand","fernand@lewis.com");
		Employee employee2 = new Employee(2,"Marcel","marcel.pietro@lewis.com");
		Employee employee3 = new Employee(3,"Jeniffer","jeniffer@lewis.com");
		Employee employee4 = new Employee(4,"elon","elon.musk@lewis.com");
		
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{

		return employees;
		
		
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id)
	{

		if ((id >= employees.size() || (id < 0) ))
		{
			throw new RuntimeException("invalid id - " + id);
			
		}
		
		Employee employeeFound = employees.get(id -1);
		
		if (employeeFound == null)
		{
			throw new StudentNotFoundException("Student id not found - " + id);
			
		}
		else
		{
			return employeeFound;
		}
	
		
		
	}

	
}
