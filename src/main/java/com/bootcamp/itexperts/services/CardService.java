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
		typeCardModel.setName(cardModel.getTypeCardModelId().getName());	
		typeCardRepository.save(typeCardModel);
		cardModel.setTypeCardModelId(typeCardModel);
		return cardRepository.save(cardModel);
		
		}catch (NoSuchElementException e) {
			throw new RuntimeException("Cliente não encontrado para inserir endereço!");			
		}catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Insira valores válidos para entrada");
		}		
	}
	
	@Transactional(readOnly = true)
	public Page<CardModel> findAll(Pageable pageable) {
		return cardRepository.findAll(pageable);
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
