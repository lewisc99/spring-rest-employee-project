package com.lewis.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Sales;
import com.lewis.springrest.exceptions.CustomNotFoundException;

@Repository
public class SalesDAOImpl implements SalesDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public SalesDTO returnAll(int pagNumber, int pagSize, String url) {

		try {
		
		Session currentSession = session.getCurrentSession();

		List<Sales> sales = currentSession.createQuery("from Sales order by id").getResultList();
													  
		int salesSize = sales.size();
		SalesDTO salesDTO = new SalesDTO();

		if ((pagNumber <= 0) && (pagSize <= 0)) {

			salesDTO.addSales(sales, url);
			salesDTO.AddPage(0, salesSize, 0, 0);
			
			return salesDTO;
		}

		if (pagNumber < 1 && pagSize >= 1) {
			pagNumber = 1;
		}
		
		List<Sales> salesResized = sales.stream().skip((pagNumber - 1) * pagSize).limit(pagSize).toList();
		
		int salesTotalByPage = (int) Math.ceil((double)  salesSize / pagSize);
		
		salesDTO.AddPage(pagSize, salesSize, salesTotalByPage, pagNumber);
		
		salesDTO.addSales(salesResized, url);
		
		return salesDTO;
		
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public SaleDTO returnById(int id) {
	
		try {
		
		Session currentSession = session.getCurrentSession();
		
		
		Sales sales = currentSession.get(Sales.class, id);
		
		
		
		SaleDTO saleDTO = new SaleDTO(sales);
		
		return saleDTO;
		}
		catch(CustomNotFoundException e)
		{

			throw new CustomNotFoundException("id not found " + id);
		}
		
		catch(Exception e) {
			
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void Create(Sales sales) {
		
		
		Session currentSession = session.getCurrentSession();
		
		sales.setId(0);
		currentSession.save(sales);
			
			
		
	}

}
