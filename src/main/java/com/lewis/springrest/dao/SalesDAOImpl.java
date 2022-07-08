package com.lewis.springrest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.entity.Sales;
import com.lewis.springrest.exceptions.CustomNotFoundException;

@Repository
public class SalesDAOImpl implements SalesDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public SalesDTO returnAll(int pagNumber, int pagSize, String url, String sort) {

		try {

			Session currentSession = session.getCurrentSession();

			List<Sales> sales = currentSession.createQuery("from Sales order by " + sort).getResultList();

			int salesSize = sales.size();
			SalesDTO salesDTO = new SalesDTO();

			if ((pagNumber <= 0) && (pagSize <= 0)) {

				salesDTO.addSales(sales, url);
				salesDTO.AddPage(salesSize, salesSize, 0, 0);

				return salesDTO;
			}

			if (pagNumber < 1 && pagSize >= 1) {
				pagNumber = 1;
			}

			List<Sales> salesResized = sales.stream().skip((pagNumber - 1) * pagSize).limit(pagSize).toList();

			int salesTotalByPage = (int) Math.ceil((double) salesSize / pagSize);

			salesDTO.AddPage(pagSize, salesSize, salesTotalByPage, pagNumber);

			salesDTO.addSales(salesResized, url);

			return salesDTO;

		} catch (Exception e) {
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
		} catch (CustomNotFoundException e) {

			throw new CustomNotFoundException("id not found " + id);
		}

		catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void Create(Sales sales) {

		
		try {
			Session currentSession = session.getCurrentSession();

			sales.setId(0);
			currentSession.save(sales);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}

	}
	

	public Sales Update(Sales sales, int id)
	{
		
		
		Sales salesChanged = RestrictedUpdate(sales, id);
		
		
		
		
		return salesChanged;
		
	}
	
	private Sales RestrictedUpdate(Sales sales, int id)
	{
		Session currentSession = session.getCurrentSession();

		Sales salesDefault = currentSession.get(Sales.class, id);
		
		salesDefault.setProductName(sales.getProductName());
		//salesDefault.setCustomer(sales.getCustomer());
		
		currentSession.saveOrUpdate(salesDefault);
		
		return salesDefault;
		
	}

	@Override
	public void Delete(int id) {
	
		
		Session currentSession = session.getCurrentSession();
		
		Sales salesDefault = currentSession.get(Sales.class, id);

		currentSession.delete(salesDefault);
	}

}
