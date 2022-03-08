package com.bootcamp.itexperts.controllers.handlers;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcamp.itexperts.models.exceptions.ErrorDefault;

@RestControllerAdvice
public class AccountHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidantionException(MethodArgumentNotValidException e){
		Map<String, String> errors = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDefault> handleDataViolation(DataIntegrityViolationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDefault erro = new ErrorDefault();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Please insert valids values");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	

}
