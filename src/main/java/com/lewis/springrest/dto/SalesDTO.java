package com.lewis.springrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.lewis.springrest.entity.Link;
import com.lewis.springrest.entity.Page;
import com.lewis.springrest.entity.Sales;

public class SalesDTO {

	private List<SaleDTO> _embedded = new ArrayList<>();
	
	private List<Link> links = new ArrayList<>();
	
	private Page page;
	
	
	public SalesDTO() {}


	public List<SaleDTO> get_embedded() {
		return _embedded;
	}


	public void set_embedded(List<SaleDTO> _embedded) {
		this._embedded = _embedded;
	}


	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	};
	
	
	public void addLink(String href, String rel)
	{
		
		Link link = new Link(href,rel);
		
		this.links.add(link);
		
	}
	

	public  void AddPage(int size, int totalElements,int totalPages, int number) 
	{
		 this.page = new Page(size,totalElements,totalPages,number);
		
		 
	}
	
	public void addSales(List<Sales> sales, String urlLInk)
	{
		
		for(Sales sale: sales)
		{
			Link link = new Link(urlLInk +"/"+ sale.getId(),"self");
			
			 SaleDTO saleDTO = new SaleDTO(sale);
			 
			
			 
			 saleDTO.addLink(link);
			 
			 this._embedded.add(saleDTO);
			 
		}
	}
	
}
