package com.lewis.springrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springrest.dao.SalesDAO;
import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;

@Service
public class SaleServiceImpl implements SaleService{

	
	@Autowired
	private SalesDAO salesDAO;
	
	
	@Transactional
	@Override
	public SalesDTO returnAll(int pagNumber, int pagSize, String Url) {
		 
		
		return salesDAO.returnAll(pagNumber, pagSize, Url);
	}

	
	@Transactional
	@Override
	public SaleDTO returnById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
