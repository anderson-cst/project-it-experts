package com.bootcamp.itexperts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;	
	//inserir dependencia card / endereco

		
	@Transactional
	public AccountModel save(AccountModel accountModel) {
		return accountRepository.save(accountModel);
	}
	
	@Transactional(readOnly = true)
	public Page<AccountModel> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Optional<AccountModel> findById(Integer id) {
		return accountRepository.findById(id);
	}
	
	@Transactional
	public void delete(AccountModel accountModel) {
		accountRepository.delete(accountModel);
	}
	
	@Transactional
	public AccountModel update(AccountModel accountModel, Integer id) {
		Optional<AccountModel> accountModelOptional = accountRepository.findById(id);
		accountModelOptional.get().setNameOwner(accountModel.getNameOwner());
		accountModelOptional.get().setAgencyCode(accountModel.getAgencyCode());
		accountModelOptional.get().setAccountCode(accountModel.getAccountCode());
		accountModelOptional.get().setVerificationDigital(accountModel.getVerificationDigital());
		accountModelOptional.get().setRegisterId(accountModel.getRegisterId());
		return accountModelOptional.get();
	}
	
	
	
	
	
}
