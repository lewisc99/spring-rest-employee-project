package com.lewis.springrest.services;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;

public interface SaleService {
	
	public SalesDTO returnAll(int pagNumber, int pagSize, String Url);
	
	public SaleDTO returnById(int id);

}
