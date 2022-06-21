package com.lewis.springrest.dao;

import java.util.List;

import com.lewis.springrest.entity.Department;

public interface DepartmentDAO {

	
	public List<Department> getDepartments();
	
	public Department getDepartmentById(int id);
	
	
}
