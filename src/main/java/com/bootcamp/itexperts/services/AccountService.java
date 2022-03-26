package com.bootcamp.itexperts.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.itexperts.controllers.mapper.Mapper;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.AccountRepository;
import com.bootcamp.itexperts.repositories.CardRepository;
import com.bootcamp.itexperts.repositories.TypeCardRepository;
import com.bootcamp.itexperts.services.exceptions.DeleteNotAllowed;
import com.bootcamp.itexperts.services.exceptions.InvalidInputException;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;	
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TypeCardRepository typeCardRepository;

	
	public AccountService(Mapper mapper) {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public AccountModel save(AccountModel accountModel) {
		
		accountRepository.save(accountModel);		
		List<CardModel> cardModelList = accountModel.getCardModel();
								
		try {
		
			TypeCardModel typeCardModel = new TypeCardModel();
			for (CardModel cardModelFor : cardModelList) {
				cardModelFor.setAccountModelId(accountModel);
				cardRepository.save(cardModelFor);
				typeCardModel = cardModelFor.getTypeCardModelId();
//				typeCardModel.setCardModel(cardModelFor);
				typeCardRepository.save(typeCardModel);
			}
			
			return accountModel;
			
		}catch (NoSuchElementException e) {
			throw new NotFoundException("Not Found!");	
		}catch (DataIntegrityViolationException e) {
			throw new InvalidInputException("Invalid Input!");
		}		
	}
	
	@Transactional(readOnly = true)
	public Page<AccountModel> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public AccountModel findById(Integer id) {
		Optional<AccountModel> accountModelOpt = accountRepository.findById(id);
		return accountModelOpt.orElseThrow(()-> new NotFoundException("Account Not Found!"));
	}
	
	@Transactional
	public void delete(AccountModel accountModel) {
			accountRepository.delete(accountModel);
	}
	
	@Transactional
	public AccountModel update(AccountModel accountModel, Integer id) {
		try {
			Optional<AccountModel> accountModelOpt = accountRepository.findById(id);
			accountModelOpt.get().setNameOwner(accountModel.getNameOwner());
			accountModelOpt.get().setAgencyCode(accountModel.getAgencyCode());
			accountModelOpt.get().setAccountCode(accountModel.getAccountCode());
			accountModelOpt.get().setVerificationDigital(accountModel.getVerificationDigital());
			accountModelOpt.get().setRegisterId(accountModel.getRegisterId());
			return accountModelOpt.get();			
		}catch (NoSuchElementException e) {
			throw new NotFoundException("Account Not Found to Update");	
	    }
	}	
}
