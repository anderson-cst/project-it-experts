package com.bootcamp.itexperts.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.itexperts.controllers.handlers.AccountHandler;
import com.bootcamp.itexperts.dtos.AccountDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.services.AccountService;


@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Account")
public class AccountController {
	
	final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto){
		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));		
	}
		
	
	
	
	
	
	
	
}
