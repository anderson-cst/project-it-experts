package com.bootcamp.itexperts.controllers;

import java.net.URI;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.bootcamp.itexperts.config.SwaggerConfig;
import com.bootcamp.itexperts.controllers.mapper.Mapper;
import com.bootcamp.itexperts.dtos.RequestAccountDto;
import com.bootcamp.itexperts.dtos.ResponseAccountDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.exceptions.ErrorDefault;
import com.bootcamp.itexperts.services.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {SwaggerConfig.ACCOUNT_TAG})
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
//	private ModelMapper modelMapper;
	
//	@Autowired
//    public AccountController(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
	
	@Autowired
	private Mapper mapper;
	
	
	@ApiOperation(value = "Create account with cards associated", 
			notes = "Insert account with one card or more", 
			response = RequestAccountDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Account created successfully"),
			@ApiResponse(code = 404, message = "Account not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)			
	})
	@PostMapping
	public ResponseEntity<Object> saveAccounts(@RequestBody @Valid RequestAccountDto accountDto){		
		AccountModel accountModel = mapper.modelMapper().map(accountDto, AccountModel.class);
		accountService.save(accountModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(accountModel.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@ApiOperation(value = "Return all accounts", 
			notes = "Return all accounts created", 
			response = ResponseAccountDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Account created successfully"),
			@ApiResponse(code = 404, message = "Account not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)			
	})
	@GetMapping
	public ResponseEntity<Page<ResponseAccountDto>> getAllAccounts(Pageable pageable){
		return ResponseEntity.ok().body(mapper.accountModelToResponseAccountDtoPage(accountService.findAll(pageable)));
	}
	
	
	@ApiOperation(value = "Return accounts by id", 
			notes = "Put id account to find it", 
			response = ResponseAccountDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Account created successfully"),
			@ApiResponse(code = 404, message = "Account not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)			
	})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseAccountDto> getAccountsById(@PathVariable(value = "id") Integer id){
		AccountModel accountModel = accountService.findById(id);
		ResponseAccountDto responseAccountDto = mapper.modelMapper().map(accountModel, ResponseAccountDto.class);
		return ResponseEntity.ok().body(responseAccountDto);
	}
	
	
	@ApiOperation(value = "Delete accounts by id", 
			notes = "Put id account to delete", 
			response = RequestAccountDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Account created successfully"),
			@ApiResponse(code = 404, message = "Account not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)			
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccounts(@PathVariable(value = "id") Integer id){
		AccountModel accountModel = accountService.findById(id);
		accountService.delete(accountModel);
		return ResponseEntity.ok().body("Account deleted successfully"); 
	}
	
	
	@ApiOperation(value = "Update accounts by id", 
			notes = "Put id account to update, all fields must be filled", 
			response = RequestAccountDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Account created successfully"),
			@ApiResponse(code = 404, message = "Account not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)			
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccounts(@PathVariable(value = "id") Integer id, @RequestBody @Valid RequestAccountDto accountDto){
		AccountModel accountModel = mapper.modelMapper().map(accountDto, AccountModel.class);
		accountModel = accountService.update(accountModel, id);
		accountService.save(accountModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(accountModel.getId()).toUri();
		return ResponseEntity.created(location).build();
	}	
}
