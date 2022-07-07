package com.lewis.springrest.dao;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.entity.Sales;

public interface SalesDAO {

	
	public SalesDTO returnAll(int pagNumber, int pagSize, String Url, String sort);
	
	public SaleDTO returnById(int id);
	
	public void Create(Sales sales);
	
	public Sales Update(Sales sales, int id);
}
