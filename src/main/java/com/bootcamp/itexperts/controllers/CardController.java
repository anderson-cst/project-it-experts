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

import com.bootcamp.itexperts.dtos.CardDto;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.services.CardService;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@PostMapping
	public ResponseEntity<CardModel> saveCards(@RequestBody @Valid CardDto cardDto){
		var cardModel = new CardModel();
		BeanUtils.copyProperties(cardDto, cardModel);
		cardService.save(cardModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cardModel.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
		
	@GetMapping
	public ResponseEntity<Page<CardModel>> getAllCards(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(cardService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CardModel> getCardsById(@PathVariable(value = "id") Integer id){
		Optional<CardModel> cardModelOptional = cardService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cardModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCards(@PathVariable(value = "id") Integer id){
		Optional<CardModel> cardModelOptional = cardService.findById(id);
		cardService.delete(cardModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Card deleted successfully"); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCards(@PathVariable(value = "id") Integer id, @RequestBody @Valid CardDto cardDto){
		//Optional<AccountModel> accountModelOptional = accountService.findById(id);
		var cardModel = new CardModel();
		BeanUtils.copyProperties(cardDto, cardModel);
		cardModel = cardService.update(cardModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(cardService.save(cardModel));
	}
	

}
