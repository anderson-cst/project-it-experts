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

import com.bootcamp.itexperts.config.SwaggerConfig;
import com.bootcamp.itexperts.controllers.mapper.Mapper;
import com.bootcamp.itexperts.dtos.CardDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.exceptions.ErrorDefault;
import com.bootcamp.itexperts.services.CardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {SwaggerConfig.CARD_TAG})
@RestController
@RequestMapping("/api/v1")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private Mapper mapper;
	
	
	@ApiOperation(value = "Create cards for account", 
			notes = "Put account id and insert card to account", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Card created successfully"),
			@ApiResponse(code = 404, message = "Card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@PostMapping("/accounts/{accountId}/cards")
	public ResponseEntity<Object> saveCards(
			@RequestBody @Valid CardDto cardDto, 
			@PathVariable(value = "accountId") AccountModel accountId){
		var cardModel = mapper.modelMapper().map(cardDto, CardModel.class);
		cardModel.setAccountModelId(accountId);
		cardService.save(cardModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cardModel.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	@ApiOperation(value = "Return all cards", 
			notes = "Return all cards created", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Card created successfully"),
			@ApiResponse(code = 404, message = "Card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@GetMapping("/cards")
	public ResponseEntity<Page<CardDto>> getAllCards(Pageable pageable){
		return ResponseEntity.ok().body(mapper.cardModelToDtoPage(cardService.findAll(pageable)));
	}
	
	
	@ApiOperation(value = "Return cards by id", 
			notes = "Put id card to find it", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Card created successfully"),
			@ApiResponse(code = 404, message = "Card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@GetMapping("/cards/{id}")
	public ResponseEntity<CardDto> getCardsById(@PathVariable(value = "id") Integer id){
		CardModel cardModel = cardService.findById(id);
		CardDto cardDto = mapper.modelMapper.map(cardModel, CardDto.class);
		return ResponseEntity.ok().body(cardDto);
	}
	
	
	@ApiOperation(value = "Delete cards by id", 
			notes = "Put id card to delete", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Card created successfully"),
			@ApiResponse(code = 404, message = "Card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@DeleteMapping("/cards/{id}")
	public ResponseEntity<Object> deleteCards(@PathVariable(value = "id") Integer id){
		CardModel cardModelOpt = cardService.findById(id);
		cardService.delete(cardModelOpt);
		return ResponseEntity.ok().body("Card deleted successfully"); 
	}
	
	
	@ApiOperation(value = "Update cards by id", 
			notes = "Put id card to update, all fields must be filled", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Card created successfully"),
			@ApiResponse(code = 404, message = "Card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@PutMapping("/cards/{id}")
	public ResponseEntity<Object> updateCards(@PathVariable(value = "id") Integer id, @RequestBody @Valid CardDto cardDto){
		
//		BeanUtils.copyProperties(cardDto, cardModel);
		var cardModel = mapper.modelMapper.map(cardDto, CardModel.class);
		cardModel = cardService.update(cardModel, id);
		cardService.save(cardModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
//				.path("/{id}")
				.buildAndExpand(cardModel.getId()).toUri();
		return ResponseEntity.created(location).build();
		//TROCAR BEAN UTILS POR MODEL MAPPER
	}
}
