package com.lewis.springrest.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
	
	private List<Sales> sales;
	
	public Employee()
	{}
	
	
	

	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	
	}
	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
}
