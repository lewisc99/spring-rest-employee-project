package com.lewis.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springrest.dao.DepartmentDAO;
import com.lewis.springrest.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	
	@Override
	@Transactional
	public List<Department> getDepartments() {

		return departmentDAO.getDepartments();
	}

	@Override
	@Transactional
	public Department getDepartmentById(int id) {
		
		return departmentDAO.getDepartmentById(id);
		
	}

}
