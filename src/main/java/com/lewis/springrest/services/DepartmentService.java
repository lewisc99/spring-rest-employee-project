package com.lewis.springrest.services;

import java.util.List;

import com.lewis.springrest.entity.Department;

public interface DepartmentService {
	
	public List<Department> getDepartments();
	
	public Department getDepartmentById(int id);
	
	

}
