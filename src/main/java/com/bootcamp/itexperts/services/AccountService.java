package com.bootcamp.itexperts.services;

import org.springframework.stereotype.Service;

import com.bootcamp.itexperts.repositories.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
