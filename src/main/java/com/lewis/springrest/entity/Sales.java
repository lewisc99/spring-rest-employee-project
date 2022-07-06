package com.lewis.springrest.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;


@Entity
@Table(name="sales")
public class Sales {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@NotNull
	@Column(name="product_name")
	@Min(value=4,message="product Name cannot be null")
	private String productName;
	
	@NotNull
	@Min(value=4,message="customer cannot be null")
	@Column(name="customer_name")
	private String customer;
	
	@NotNull
	@Column(name="date_created")
	private Date dateCreated;
	
	
	@NotNull
	@JoinColumn(name="employee_id")
	@ManyToOne( cascade= CascadeType.ALL)

	private Employee employee;
	
	public Sales() {}

	

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
		return this.customer;
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

	
	
	
	
	
	
	
}
