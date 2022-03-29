package com.bootcamp.itexperts.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.AccountRepository;
import com.bootcamp.itexperts.repositories.CardRepository;
import com.bootcamp.itexperts.repositories.TypeCardRepository;
import com.bootcamp.itexperts.services.exceptions.InvalidInputException;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TypeCardRepository typeCardRepository;
	
	
	@Transactional
	public CardModel save(CardModel cardModel) {
		AccountModel accountModel = cardModel.getAccountModelId();
		TypeCardModel typeCardModel = new TypeCardModel();
		Optional<AccountModel> accountOpt = accountRepository.findById(accountModel.getId());
						
		try {
		
		cardModel.setAccountModelId(accountOpt.get());
		typeCardModel = cardModel.getTypeCardModelId();
		typeCardRepository.save(typeCardModel);
		cardModel.setTypeCardModelId(typeCardModel);
		return cardRepository.save(cardModel);
		
		}catch (NoSuchElementException e) {
			throw new NotFoundException("Account Not Found to insert Card!");	
		}catch (DataIntegrityViolationException e) {
			throw new InvalidInputException("Invalid Input!");
		}		
	}
	
	@Transactional(readOnly = true)
	public Page<CardModel> findAll(Pageable pageable) {
		return cardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public CardModel findById(Integer id) {
		Optional<CardModel> cardModelOpt = cardRepository.findById(id);
		return cardModelOpt.orElseThrow(()-> new NotFoundException("Card Not Found!"));
	}
	
	@Transactional
	public void delete(CardModel cardModel) {
		cardRepository.delete(cardModel);
	}
	
	@Transactional
	public CardModel update(CardModel cardModel, Integer id) {
		try {
			Optional<CardModel> cardModelOpt = cardRepository.findById(id);
			cardModelOpt.get().setName(cardModel.getName());
			cardModelOpt.get().setNumber(cardModel.getNumber());
			cardModelOpt.get().setDigitCode(cardModel.getDigitCode());
			cardModelOpt.get().setLimitBalance(cardModel.getLimitBalance());
			cardModelOpt.get().setFlag(cardModel.getFlag());
			cardModelOpt.get().setTypeCardModelId(cardModel.getTypeCardModelId());
			return cardModelOpt.get();			
		}catch (NoSuchElementException e) {
			throw new NotFoundException("Card Not Found to Update");	
	    }
		
	}
	

}
