package com.lewis.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Sales;

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

		if ((pagNumber < 0) && (pagSize < 0)) {

			salesDTO.addSales(sales, url);
			return salesDTO;
		}

		if (pagNumber < 1 && pagSize > 1) {
			pagNumber = 1;
		}
		
		List<Sales> salesResized = sales.stream().skip((pagNumber - 1) * pagSize).limit(pagSize).toList();
		
		int salesTotalByPage = (int) Math.ceil(salesSize / pagSize);
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
