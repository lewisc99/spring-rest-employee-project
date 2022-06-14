package com.lewis.springrest.exceptions;

public class StudentNotFoundException  extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	
	public StudentNotFoundException(String message)
	{
		super(message);
	}
	
	public StudentNotFoundException(String message, Throwable exception)
	{
		super(message, exception);
	}
	
	
	public StudentNotFoundException( Throwable exception)
	{
		super( exception);
	}
	

}
