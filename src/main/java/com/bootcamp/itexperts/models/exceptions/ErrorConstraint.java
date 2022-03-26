package com.bootcamp.itexperts.models.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import com.bootcamp.itexperts.services.exceptions.DetailError;

public class ErrorConstraint implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant timeStamp;
	private Integer status;
	private String error;
	private String path;
	
	private List<DetailError> details;

	public ErrorConstraint() {
	}

	public ErrorConstraint(Instant timeStamp, Integer status, String error, String path, List<DetailError> details) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.path = path;
		this.details = details;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<DetailError> getDetails() {
		return details;
	}

	public void setDetails(List<DetailError> details) {
		this.details = details;
	}
}
