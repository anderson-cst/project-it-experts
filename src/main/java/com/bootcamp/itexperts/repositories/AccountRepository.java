package com.bootcamp.itexperts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.itexperts.models.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>{
	
}
