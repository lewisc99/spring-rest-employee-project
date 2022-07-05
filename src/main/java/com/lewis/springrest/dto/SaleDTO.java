package com.lewis.springrest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.entity.Link;
import com.lewis.springrest.entity.Sales;

public class SaleDTO {

	private int id;

	private String productName;

	private String customer;

	private Date dateCreated;

	private Employee employee;

	private List<Link> link = new ArrayList<>();

	public SaleDTO() {
	}

	public SaleDTO(Sales sales) {
		this.id = sales.getId();
		this.productName = sales.getProductName();
		this.customer = sales.getCustomer();
		this.dateCreated = sales.getDateCreated();
		this.employee = sales.getEmployee();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Link> getLink() {
		return link;
	}

	public void setLink(List<Link> link) {
		this.link = link;
	}

	

	public void addLink(Link link) {
		
		
		Link linkInfo = new Link(link.getLink(), link.getRel());

		this.link.add(linkInfo);

	}

}
