package com.bootcamp.itexperts.services.exceptions;

import java.util.List;

public class ValidationErrorResponse {
	
	private List<Violation> violations;

	public ValidationErrorResponse() {
	}
	
	public ValidationErrorResponse(List<Violation> violations) {
		this.violations = violations;
	}

	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}
}