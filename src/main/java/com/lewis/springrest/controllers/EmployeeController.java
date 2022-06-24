package com.lewis.springrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.exceptions.CustomNotFoundException;
import com.lewis.springrest.services.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	
	
	@GetMapping()
	public ResponseEntity<List<Employee>> ReturnAll()
	{
		
		List<Employee> employees = employeeService.getEmployees();
		
		if (employees == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(employees);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> returnById(@PathVariable int id)
	{
		
		Employee employeeId = employeeService.getEmployeeById(id);
		
		if (employeeId == null)
		{
			throw new CustomNotFoundException("id not found");
		}
		
		return ResponseEntity.ok().body(employeeId);
		
	}

	@PostMapping()
	public ResponseEntity<Void> Create(@RequestBody  @Valid Employee employee)
	{
		
		if (employee == null)
		{
			throw new RuntimeException("Employee is empty");
		}
	
		employeeService.addEmployee(employee);
		
	return	ResponseEntity.status(201).build();
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> Update(@PathVariable int id, @RequestBody Employee employee)
	{
	
		Employee employeeId = employeeService.getEmployeeById(id);
		
		if (employeeId == null)
		{
			throw new CustomNotFoundException("id not found " + id);
			
		}
		if (employee == null)
		{
			
			ResponseEntity.badRequest().build();
		}
		
		Employee employeeUpdated = employeeService.updateEmployee(id, employee);
		
		return ResponseEntity.status(200).body(employeeUpdated);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Employee> Delete(@PathVariable int id)
	{
		
		Employee EmployeeId = employeeService.getEmployeeById(id);
		
		if (EmployeeId == null)
		{
			throw new CustomNotFoundException("id not found " + id);
		}
		
		employeeService.deleteEmployee(id);
		
		return ResponseEntity.status(200).build();
	}
	
	
	
	
}
