package com.bootcamp.itexperts.services.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcamp.itexperts.models.exceptions.ErrorDefault;

@RestControllerAdvice
public class HandlerExceptions {
	
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
		erro.setError("Action Not Allowed");
		erro.setMessage("Do not allowed Delete with Card associated");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorDefault> invalidInput(InvalidInputException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		ErrorDefault erro = new ErrorDefault();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Favor rever os valores de entrada");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDefault> notFound(NotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorDefault erro = new ErrorDefault();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Not Found, input valid values!");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDefault> notReadable(HttpMessageNotReadableException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorDefault erro = new ErrorDefault();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Please attention on input values!");
		erro.setMessage("conflicted fields!");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(DeleteNotAllowed.class)
	public ResponseEntity<ErrorDefault> notAllowed(DeleteNotAllowed e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorDefault erro = new ErrorDefault();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Delete Not Allowed");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}

}
