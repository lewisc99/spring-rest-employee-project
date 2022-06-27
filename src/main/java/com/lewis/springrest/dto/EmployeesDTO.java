package com.lewis.springrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.lewis.springrest.entity.Employee;
import com.lewis.springrest.entity.Link;
import com.lewis.springrest.entity.Page;

public class EmployeesDTO {

	private List<EmployeeDTO> _embedded = new ArrayList<>();

	private List<Link> links = new ArrayList<>();

	private Page page;

	public EmployeesDTO() {
	}

	public List<EmployeeDTO> get_embedded() {
		return _embedded;
	}

	public void set_embedded(List<EmployeeDTO> _embedded) {
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
	}

	public void addLink(String link, String rel) {

		links.add(new Link(link, rel));

	}

	public void addEmployees(List<Employee> employees, String url)
	{
		
		
		for(Employee employee: employees)
		{
			
			EmployeeDTO employeeDTO = new EmployeeDTO(employee);
			
			employeeDTO.AddLink(url + employee.getId(), "self");
			
			_embedded.add(employeeDTO);
		
		}
		
	}
	
	public  void AddPage(String size, String totalElements,String totalPages, String number) 
	{
		
	}

	
}
