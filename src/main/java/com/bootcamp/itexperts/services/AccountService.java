package com.bootcamp.itexperts.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.repositories.AccountRepository;

@Service
public class AccountService {

	final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Transactional
	public AccountModel save(AccountModel accountModel) {
		return accountRepository.save(accountModel);
	}
}
