package com.lewis.springrest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.lewis.springrest.entity.Department;
import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.entity.Link;
import com.lewis.springrest.entity.Sales;

public class EmployeeDTO {
	
	
	
	private int id;
	private String name;
	private String email;
	
	private List<Link> links = new ArrayList<>();

	
	public EmployeeDTO(Employee employee)
	{
		this.id = employee.getId();
		this.name = employee.getName();
		this.email = employee.getEmail();
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


	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	public void AddLink(String url, String rel)
	{
		Link link = new Link();
		
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
		
	}

}
