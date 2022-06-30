package com.lewis.springrest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.springrest.dto.SalesDTO;
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
		String urlForSales = formartUrl;
		
		
		SalesDTO salesDTO = service.returnAll(pagNumber, pagSize, urlForSales);
		
		
	
		
		if (!(pagNumber <= 0 && pagSize <= 0) )
		{
			 urlForSales += "?" + "pagNumber=" + pagNumber + "&pagSize=" + pagSize;
		}
		
		salesDTO.addLink(urlForSales, "getAllEmployees");
		
		
		if (salesDTO.get_embedded().isEmpty() )
		{
			return ResponseEntity.notFound().build();
		}
		
		
		

		return ResponseEntity.ok().body(salesDTO);
	}

}
