package com.lewis.springrest.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Department {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public String name;
	
	
	public Department()
	{}

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
	
	
	
	
	
	
}
