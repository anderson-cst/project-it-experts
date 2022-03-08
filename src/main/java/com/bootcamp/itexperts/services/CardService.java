package com.bootcamp.itexperts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.AccountRepository;
import com.bootcamp.itexperts.repositories.CardRepository;
import com.bootcamp.itexperts.repositories.TypeCardRepository;

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
		List<CardModel> cardList = new ArrayList<>();
		Optional<AccountModel> accountOpt = accountRepository.findById(accountModel.getId());
						
		try {
			
		cardModel.setAccountModelId(accountOpt.get());
		cardList.add(cardModel);
		accountOpt.get().setCardModel(cardList);
		
		TypeCardModel typeCardModel = new TypeCardModel(); 
		//Optional<CardModel>	cardOpt = cardRepository.findById(cardModel.getId());
		
		typeCardModel.setName(cardModel.getTypeCardModelId().getName());
		typeCardModel.setCardModelId(cardModel);
		typeCardRepository.save(typeCardModel);
		
		cardRepository.save(cardModel);
		
		}catch (NoSuchElementException e) {
			throw new RuntimeException("Cliente não encontrado para inserir endereço!");			
		}catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Insira valores válidos para entrada");
		}
				
		
		
		return cardModel;
		 
		
		
	}
	
	@Transactional(readOnly = true)
	public List<CardModel> findAll() {
		return cardRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<CardModel> findById(Integer id) {
		return cardRepository.findById(id);
	}
	
	@Transactional
	public void delete(CardModel cardModel) {
		cardRepository.delete(cardModel);
	}
	
	@Transactional
	public CardModel update(CardModel cardModel, Integer id) {
		Optional<CardModel> cardModelOptional = cardRepository.findById(id);
		cardModelOptional.get().setName(cardModel.getName());
		cardModelOptional.get().setNumber(cardModel.getNumber());
		cardModelOptional.get().setDigitCode(cardModel.getDigitCode());
		cardModelOptional.get().setLimitBalance(cardModel.getLimitBalance());
		//cardModelOptional.get().setAccountId(cardModel.getAccountId());
		return cardModelOptional.get();
	}
	

}
