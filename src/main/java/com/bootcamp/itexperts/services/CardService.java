package com.bootcamp.itexperts.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.repositories.CardRepository;

public class CardService {
	
	final CardRepository cardRepository;

	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	
	@Transactional
	public CardModel save(CardModel cardModel) {
		return cardRepository.save(cardModel);
	}
	
	public List<CardModel> findAll() {
		return cardRepository.findAll();
	}
	
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
