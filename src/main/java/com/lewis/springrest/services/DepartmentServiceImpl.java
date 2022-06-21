package com.lewis.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lewis.springrest.dao.DepartmentDAO;
import com.lewis.springrest.entity.Department;


public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	
	@Override
	public List<Department> getDepartments() {

		return departmentDAO.getDepartments();
	}

	@Override
	public Department getDepartmentById(int id) {
		
		return departmentDAO.getDepartmentById(id);
		
	}

}
