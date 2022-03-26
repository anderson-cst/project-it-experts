package com.bootcamp.itexperts.services.exceptions;

public class DetailError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String field;
	private String message;
	
	public DetailError() {
	}

	public DetailError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
