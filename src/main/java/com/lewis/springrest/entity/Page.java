package com.lewis.springrest.entity;

public class Page {

	private int size;
	
	private int totalElements;
	
	private int totalPages;
	
	private int pagNumber;
	
	public Page() {}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPagNumber() {
		return pagNumber;
	}

	public void setPagNumber(int pagNumber) {
		this.pagNumber = pagNumber;
	}
	
	
	
	
	
}