package com.bootcamp.itexperts.services.exceptions;

public class DeleteNotAllowed extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DeleteNotAllowed(String msg) {
		super(msg);
	}

}
