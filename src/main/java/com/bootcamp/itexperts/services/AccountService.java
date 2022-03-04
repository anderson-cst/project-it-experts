package com.bootcamp.itexperts.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.repositories.AccountRepository;

@Service
public class AccountService {

	final AccountRepository accountRepository;
	
	//inserir dependencia card / endereco

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	@Transactional
	public AccountModel save(AccountModel accountModel) {
		return accountRepository.save(accountModel);
	}
	
	public List<AccountModel> findAll() {
		return accountRepository.findAll();
	}
	
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
