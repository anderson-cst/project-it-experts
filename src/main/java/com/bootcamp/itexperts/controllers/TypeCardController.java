package com.bootcamp.itexperts.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.itexperts.config.SwaggerConfig;
import com.bootcamp.itexperts.dtos.CardDto;
import com.bootcamp.itexperts.dtos.TypeCardDto;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.models.exceptions.ErrorDefault;
import com.bootcamp.itexperts.services.TypeCardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {SwaggerConfig.TYPE_CARD_TAG})
@Controller
@RequestMapping("/api/v1/typecards")
public class TypeCardController {
	
	@Autowired
	private TypeCardService typeCardService;
	
//	@Autowired
//	private Mapper mapper;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<TypeCardDto> getTypeCardsById(@PathVariable(value = "id") Integer id){
//		TypeCardModel typeCardModel = typeCardService.findById(id);
//		TypeCardDto typeCardDto = mapper.modelMapper.map(typeCardModel, TypeCardDto.class);
//		return ResponseEntity.ok().body(typeCardDto);
//	}
	
	
	@ApiOperation(value = "Delete type cards by id", 
			notes = "Put id type card to delete", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Type card created successfully"),
			@ApiResponse(code = 404, message = "Type card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTypeCards(@PathVariable(value = "id") Integer id){
		TypeCardModel typeCardModelOpt = typeCardService.findById(id);
		typeCardService.delete(typeCardModelOpt);
		return ResponseEntity.ok().body("Type Card deleted successfully"); 
	}
	
	
	@ApiOperation(value = "Update type cards by id", 
			notes = "Put id type card to update, all fields must be filled", 
			response = CardDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Type card created successfully"),
			@ApiResponse(code = 404, message = "Type card not found", response = ErrorDefault.class),
			@ApiResponse(code = 409, message = "Conflict on request", response = ErrorDefault.class)
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTypeCards(@PathVariable(value = "id") Integer id, @RequestBody @Valid TypeCardDto typeCardDto){
		var typeCardModel = new TypeCardModel();
		BeanUtils.copyProperties(typeCardDto, typeCardModel);
		typeCardModel = typeCardService.update(typeCardModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(typeCardService.save(typeCardModel));
	}
	
	
	
	
	
	
	
	

}
