package com.bootcamp.itexperts.controllers;

import java.net.URI;

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

import com.bootcamp.itexperts.controllers.mapper.Mapper;
import com.bootcamp.itexperts.dtos.AccountDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.services.AccountService;


@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Mapper mapper;
	
	@PostMapping
	public ResponseEntity<Object> saveAccounts(@RequestBody @Valid AccountDto accountDto){		
		var accountModel = mapper.modelMapper().map(accountDto, AccountModel.class);
		accountService.save(accountModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(accountModel.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
	@GetMapping
	public ResponseEntity<Page<AccountDto>> getAllAccounts(Pageable pageable){
		return ResponseEntity.ok().body(mapper.accountModelToDtoPage(accountService.findAll(pageable)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountsById(@PathVariable(value = "id") Integer id){
		AccountModel accountModel = accountService.findById(id);
		AccountDto accountDto = mapper.modelMapper.map(accountModel, AccountDto.class);
		return ResponseEntity.ok().body(accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccounts(@PathVariable(value = "id") Integer id){
		AccountModel accountModel = accountService.findById(id);
		accountService.delete(accountModel);
		return ResponseEntity.ok().body("Account deleted successfully"); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccounts(@PathVariable(value = "id") Integer id, @RequestBody @Valid AccountDto accountDto){
		var accountModel = new AccountModel();		
		BeanUtils.copyProperties(accountDto, accountModel);
		accountModel = accountService.update(accountModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(accountService.save(accountModel));
	}	
}
