package com.lewis.springrest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;

@Repository
public class SalesDAOImpl  implements SalesDAO{

	
	@Autowired
	private SessionFactory session;
	

	@Override
	public SalesDTO returnAll(int pagNumber, int pagSize, int Url) {
	 
		
		Session currentSession = session.getCurrentSession();
		
		return new SalesDTO();
	}


	@Override
	public SaleDTO returnById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
