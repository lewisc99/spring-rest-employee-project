package com.lewis.springrest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	
	@Column(name="email")
	private String email;
	
	@JoinColumn(name="department_id")
	@ManyToOne
	private Department department;
	
	
	@OneToMany(mappedBy="employee")
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




	public Department getDepartment() {
		return department;
	}




	public void setDepartment(Department department) {
		this.department = department;
	}



	
	

	
	
	
}
