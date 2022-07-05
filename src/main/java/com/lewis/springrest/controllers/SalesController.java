package com.lewis.springrest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.dto.SaleDTO;
import com.lewis.springrest.dto.SalesDTO;
import com.lewis.springrest.entity.Link;
import com.lewis.springrest.exceptions.CustomNotFoundException;
import com.lewis.springrest.services.SaleService;

@RequestMapping("api/sales")
@RestController
public class SalesController {

	@Autowired
	private SaleService service;

	@GetMapping()
	public ResponseEntity<SalesDTO> returnAll(@RequestParam(name = "pagNumber", required = false) Integer pagNumber,
			@RequestParam(name = "pagSize", required = false) Integer pagSize, HttpServletRequest requestUrl) {

		if (pagNumber == null && pagSize == null) {
			pagNumber = 0;
			pagSize = 0;
		}
		
		

		String formartUrl = requestUrl.getRequestURL().toString();
		String urlForSales = requestUrl.getRequestURL().toString();
		
		
		SalesDTO salesDTO = service.returnAll(pagNumber, pagSize, urlForSales);
		
		
	
		
		if (!(pagNumber <= 0 && pagSize <= 0) )
		{
			formartUrl += "?" + "pagNumber=" + pagNumber + "&pagSize=" + pagSize;
		}
		
		salesDTO.addLink(formartUrl, "getAllEmployees");
		
		
		if (salesDTO.get_embedded().isEmpty() )
		{
			return ResponseEntity.notFound().build();
		}
		
		
		

		return ResponseEntity.ok().body(salesDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SaleDTO> returnById(@PathVariable(required=true) int id, HttpServletRequest requestUrl)
	{
		
		SaleDTO saleDTO = service.returnById(id);
		String formartUrl = requestUrl.getRequestURL().toString();
		
		Link link = new Link(formartUrl,"self");
		
		saleDTO.addLink(link);
		
		
		if ( (id <= 0) )
		{
			throw new RuntimeException("invalid id - must be a number greater than 1");
		}
		
		if (saleDTO == null)
		{
			throw new CustomNotFoundException("id not found");

		}
		
		else
		{
			
			
			return ResponseEntity.ok().body(saleDTO);
		}
		
	}
	

}
