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

import com.bootcamp.itexperts.dtos.TypeCardDto;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.services.TypeCardService;

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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTypeCards(@PathVariable(value = "id") Integer id){
		TypeCardModel typeCardModelOpt = typeCardService.findById(id);
		typeCardService.delete(typeCardModelOpt);
		return ResponseEntity.ok().body("Type Card deleted successfully"); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTypeCards(@PathVariable(value = "id") Integer id, @RequestBody @Valid TypeCardDto typeCardDto){
		var typeCardModel = new TypeCardModel();
		BeanUtils.copyProperties(typeCardDto, typeCardModel);
		typeCardModel = typeCardService.update(typeCardModel, id);
		return ResponseEntity.status(HttpStatus.OK).body(typeCardService.save(typeCardModel));
	}
	
	
	
	
	
	
	
	

}
