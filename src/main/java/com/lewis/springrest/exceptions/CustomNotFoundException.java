package com.lewis.springrest.exceptions;

public class CustomNotFoundException  extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	
	public CustomNotFoundException(String message)
	{
		super(message);
	}
	
	public CustomNotFoundException(String message, Throwable exception)
	{
		super(message, exception);
	}
	
	
	public CustomNotFoundException( Throwable exception)
	{
		super( exception);
	}
	

}
