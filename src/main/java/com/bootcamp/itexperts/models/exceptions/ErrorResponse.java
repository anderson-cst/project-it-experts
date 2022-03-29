package com.bootcamp.itexperts.models.exceptions;

import java.time.Instant;

import com.bootcamp.itexperts.services.exceptions.ValidationErrorResponse;

public class ErrorResponse {

	private Instant timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private ValidationErrorResponse violations;
	
	public ErrorResponse() {
	}

	public ErrorResponse(Instant timeStamp, Integer status, String error, String message, String path,
			ValidationErrorResponse violations) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.violations = violations;
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

	public ValidationErrorResponse getViolations() {
		return violations;
	}

	public void setViolations(ValidationErrorResponse violations) {
		this.violations = violations;
	}	
}
