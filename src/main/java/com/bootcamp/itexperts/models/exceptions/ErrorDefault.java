package com.bootcamp.itexperts.models.exceptions;

import java.time.Instant;

public class ErrorDefault {
	
	private Instant timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	
	public ErrorDefault() {
		super();
	}


	public ErrorDefault(Instant timeStamp, Integer status, String error, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}


	public Instant getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
