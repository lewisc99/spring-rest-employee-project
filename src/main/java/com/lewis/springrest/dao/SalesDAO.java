package com.lewis.springrest.dao;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;

public interface SalesDAO {

	
	public SalesDTO returnAll(int pagNumber, int pagSize, int Url);
	
	public SaleDTO returnById(int id);
}
