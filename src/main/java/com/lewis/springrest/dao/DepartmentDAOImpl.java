package com.lewis.springrest.dao;

import java.util.List;
import java.util.logging.Logger;

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
	
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public List<Department> getDepartments() {
	
		
		Session currentSession = session.getCurrentSession();
		
		Query<Department> theQuery = currentSession.createQuery("from Department order by id",Department.class);
		
		return theQuery.getResultList();
		
		
	}

	@Override
	public Department getDepartmentById(int id) {
		
		try {
		Session currentSession = session.getCurrentSession();
		
		Department departmentId = currentSession.get(Department.class, id);
		return departmentId;
		
		}
		
		catch(Exception e)
		{
			logger.info("error = *************************************************** ==============" + e.getStackTrace() );
			throw  new RuntimeException();
		}
		
		
		
		
	}

	
	
}
