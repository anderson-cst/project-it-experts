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
import com.bootcamp.itexperts.dtos.CardDto;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.services.CardService;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private Mapper mapper;
	
	@PostMapping
	public ResponseEntity<Object> saveCards(@RequestBody @Valid CardDto cardDto){
		var cardModel = mapper.modelMapper().map(cardDto, CardModel.class);
		cardService.save(cardModel);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cardModel.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
		
	@GetMapping
	public ResponseEntity<Page<CardDto>> getAllCards(Pageable pageable){
		return ResponseEntity.ok().body(mapper.cardModelToDtoPage(cardService.findAll(pageable)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CardDto> getCardsById(@PathVariable(value = "id") Integer id){
		CardModel cardModel = cardService.findById(id);
		CardDto cardDto = mapper.modelMapper.map(cardModel, CardDto.class);
		return ResponseEntity.ok().body(cardDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCards(@PathVariable(value = "id") Integer id){
		CardModel cardModelOpt = cardService.findById(id);
		cardService.delete(cardModelOpt);
		return ResponseEntity.ok().body("Card deleted successfully"); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCards(@PathVariable(value = "id") Integer id, @RequestBody @Valid CardDto cardDto){
		var cardModel = new CardModel();
		BeanUtils.copyProperties(cardDto, cardModel);
		cardModel = cardService.update(cardModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(cardService.save(cardModel));
	}
	

}
