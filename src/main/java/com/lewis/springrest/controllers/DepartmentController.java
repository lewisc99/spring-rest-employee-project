package com.lewis.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.entity.Department;
import com.lewis.springrest.exceptions.CustomNotFoundException;
import com.lewis.springrest.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	
	@GetMapping()
	public ResponseEntity<List<Department>> getDepartments()
	{
		
		List<Department> departments = service.getDepartments();
		
		return ResponseEntity.ok().body(departments);
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable int id)
	{
		Department department = service.getDepartmentById(id);
		
		if (department == null)
		{
			 throw new CustomNotFoundException("id not found");
		}
		
		
		
		return ResponseEntity.ok().body(department);
	}
}
