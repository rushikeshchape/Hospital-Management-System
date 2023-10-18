package com.jspiders.hospitalmanagement.exception;

public class IdNotFound extends RuntimeException{

	private String message = "Id Not Found";
	
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public IdNotFound(String message) {
		this.message = message;
	}

	public IdNotFound() {
		super();
	}
}  