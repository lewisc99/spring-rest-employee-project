package com.lewis.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springrest.entity.Department;


@Repository
public class DepartmentDAOImpl  implements DepartmentDAO{

	
	@Autowired
	private SessionFactory session;
	
	@Override
	public List<Department> getDepartments() {
	
		
		Session currentSession = session.getCurrentSession();
		
		Query<Department> theQuery = currentSession.createQuery("from Department order by name",Department.class);
		
		return theQuery.getResultList();
		
		
	}

	@Override
	public Department getDepartmentById(int id) {
		
		Session currentSession = session.getCurrentSession();
		
		Department departmentId = currentSession.get(Department.class, id);
		
		return departmentId;
		
		
		
	}

	
	
}
