package com.lewis.springrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springrest.dao.SalesDAO;
import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Sales;

@Service
public class SaleServiceImpl implements SaleService{

	
	@Autowired
	private SalesDAO salesDAO;
	
	
	@Transactional
	@Override
	public SalesDTO returnAll(int pagNumber, int pagSize, String Url, String sort) {
		 
		
		return salesDAO.returnAll(pagNumber, pagSize, Url, sort);
	}

	
	@Transactional
	@Override
	public SaleDTO returnById(int id) {
	 
		return salesDAO.returnById(id);
	}

	@Transactional
	@Override
	public void Create(Sales sales) {
		
		
		salesDAO.Create(sales);
	}
	
	
	@Override
	@Transactional
	public Sales Update(Sales sales, int id)
	{
		Sales salesUpdated = salesDAO.Update(sales, id);
		
		return salesUpdated;
	}


	@Override
	@Transactional
	public void Delete(int id) {
		 
		salesDAO.Delete(id);
		
	}

}
