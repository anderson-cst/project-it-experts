package com.bootcamp.itexperts.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcamp.itexperts.dtos.AccountDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.services.AccountService;


@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Object> saveAccounts(@RequestBody @Valid AccountDto accountDto){
		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		accountService.save(accountModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(accountModel.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
	@GetMapping
	public ResponseEntity<Page<AccountModel>> getAllAccounts(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountModel> getAccountsById(@PathVariable(value = "id") Integer id){
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(accountModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccounts(@PathVariable(value = "id") Integer id){
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		accountService.delete(accountModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully"); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccounts(@PathVariable(value = "id") Integer id, @RequestBody @Valid AccountDto accountDto){
		//Optional<AccountModel> accountModelOptional = accountService.findById(id);
		var accountModel = new AccountModel();		
		BeanUtils.copyProperties(accountDto, accountModel);
		accountModel = accountService.update(accountModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(accountService.save(accountModel));
	}
	
	
	
	
	
	
	
	
}
