package com.lewis.springrest.controllers;

import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.dto.EmployeeDTO;
import com.lewis.springrest.dto.EmployeesDTO;
import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.exceptions.CustomNotFoundException;
import com.lewis.springrest.services.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@GetMapping()
	public ResponseEntity<EmployeesDTO> ReturnAll(@RequestParam("pagNumber") int pagNumber, @RequestParam("pagSize") int pagSize,
			HttpServletRequest request)
	{
		
		List<Employee> employees = employeeService.getEmployees(pagNumber, pagSize);
		
		
		
		
		String fullUrl = request.getRequestURI().toString();
		String urlForEmployees = request.getRequestURI().toString();
		
		
		
		if (!(pagNumber == 0 && pagSize == 0) )
		{
			 urlForEmployees += "?" + "pagNumber=" + pagNumber + "&pagSize=" + pagSize;
		}
		
		
		/*
		 * 
			  "page": {
			        "size": 14,          - total elements for page
			        "totalElements": 30, =  total elements 
			        "totalPages": 3, =       total Pages
			        "number": 1        =     number of current page
			    }
		 */
		
		
		if (employees.isEmpty() )
		{
			return ResponseEntity.notFound().build();
		}
		
		
		
		EmployeesDTO employeesDTO = new EmployeesDTO();
		
		
		
		
		employeesDTO.addEmployees(employees,fullUrl);
		
		
		
		
		employeesDTO.addLink(urlForEmployees, "self");
		
		
		return ResponseEntity.ok().body(employeesDTO);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> returnById(@PathVariable int id,  HttpServletRequest request) 
	{
		
		Employee employeeId = employeeService.getEmployeeById(id);
		

		
		if (employeeId == null)
		{
			throw new CustomNotFoundException("id not found");
		}

		   String fullURL = request.getRequestURL().toString();

		
		
		System.out.println("------------------" + fullURL);
		
		
		EmployeeDTO employeeDTO = new EmployeeDTO(employeeId);
		
		employeeDTO.AddLink(fullURL , "self");
		
		
		return ResponseEntity.ok().body(employeeDTO);
		
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
