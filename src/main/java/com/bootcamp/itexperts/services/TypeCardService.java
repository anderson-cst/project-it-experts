package com.bootcamp.itexperts.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.TypeCardRepository;
import com.bootcamp.itexperts.services.exceptions.InvalidInputException;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;

@Service
public class TypeCardService {

	@Autowired
	private TypeCardRepository typeCardRepository;
	
	
	@Transactional
	public TypeCardModel save(TypeCardModel typeCardModel) {
								
		try {
		
		return typeCardRepository.save(typeCardModel);
		
		}catch (DataIntegrityViolationException e) {
			throw new InvalidInputException("Invalid Input!");
		}		
	}
	
	@Transactional(readOnly = true)
	public TypeCardModel findById(Integer id) {
		Optional<TypeCardModel> typeCardModelOpt = typeCardRepository.findById(id);
		return typeCardModelOpt.orElseThrow(()-> new NotFoundException("Type Card Not Found!"));
	}
	
	@Transactional
	public void delete(TypeCardModel typeCardModel) {
		typeCardRepository.delete(typeCardModel);
	}
	
	@Transactional
	public TypeCardModel update(TypeCardModel typeCardModel, Integer id) {
		try {
			Optional<TypeCardModel> typeCardModelOpt = typeCardRepository.findById(id);
			typeCardModelOpt.get().setName(typeCardModel.getName());
			return typeCardModelOpt.get();			
		}catch (NoSuchElementException e) {
			throw new NotFoundException("Type Card Not Found to Update");	
	    }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
