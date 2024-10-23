package com.bootcamp.itexperts.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.AccountRepository;
import com.bootcamp.itexperts.repositories.CardRepository;
import com.bootcamp.itexperts.repositories.TypeCardRepository;
import com.bootcamp.itexperts.services.AccountService;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTests {
	
	@InjectMocks
	private AccountService accountService;
	
	@MockBean
	private AccountRepository accountRepository;	
	
	@MockBean
	private CardRepository cardRepository;
	
	@MockBean
	private TypeCardRepository typeCardRepository;

	
	private static final Integer ID = 1;
	private static final String NAME_OWNER = "Anderson Costa";
	private static final String AGENCY_CODE = "12345";
	private static final String ACCOUNT_CODE = "1234567890";
	private static final String VERIFICATION_DIGITAL = "5";
	private static final String REGISTER_ID = "11122233344";
	private static List<CardModel> CARD_MODEL_LIST;
	private static final Integer ID_INVALIDO 		        = 1000;
	private static final String USUARIO_NAO_ENCONTRADO 	= "Usuario não encontrado";

	private static AccountModel accountModel;
	private CardModel cardModel;
	private static TypeCardModel typeCardModel;
	private Optional<AccountModel> accountOpt;
	private AccountModel accountReturn;
	private AccountModel accountReturn2;
	private AccountModel accountReturn3;
	private Pageable pageable;
	
	
	private static final Integer id = 1;
	private static final String name = "Black Card";
	private static final String number = "1111222233334444";
	private static final String digitCode = "54321";
	private static final Double limitBalance = 1000.00;
	private static final Flag flag = Flag.MASTERCARD;
	private static final AccountModel accountModelId = accountModel;
	private static final TypeCardModel typeCardModelId = typeCardModel;

	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		startResources();
	}
	
	private void startResources() {
		cardModel = new CardModel(id, name, number, digitCode, limitBalance, flag, accountModelId, typeCardModelId);
		CARD_MODEL_LIST = new ArrayList<CardModel>();
		CARD_MODEL_LIST.add(cardModel);
		accountModel = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountOpt = Optional.of(new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST));
		accountReturn = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountReturn2 = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountReturn3 = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);		
	}
	
	
	@Test
	public void whenSaveShouldReturnAccountInstance() {
		when(accountRepository.save(accountModel)).thenReturn(accountReturn);		
		accountModel = accountService.save(accountModel);
		
		Assertions.assertNotNull(accountModel);
		Assertions.assertEquals(ID, accountModel.getId());
		Assertions.assertEquals(NAME_OWNER, accountModel.getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, accountModel.getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, accountModel.getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, accountModel.getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, accountModel.getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, accountModel.getCardModel());
	}
	
	@Test
	public void whenFindIdShouldReturnAccountInstance() {
		when(accountRepository.findById(ID)).thenReturn(accountOpt);
		accountModel = accountService.findById(ID);
		
		Assertions.assertNotNull(accountModel);
		Assertions.assertEquals(ID, accountModel.getId());
		Assertions.assertEquals(NAME_OWNER, accountModel.getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, accountModel.getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, accountModel.getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, accountModel.getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, accountModel.getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, accountModel.getCardModel());
	}
	
	@Test
	public void shouldFindAllAccountsReturnPaginationResource() {
		when(accountRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(accountReturn, accountReturn2, accountReturn3)));
		
		Page<AccountModel> resultado = accountService.findAll(pageable);
		
		Assertions.assertNotNull(resultado);
		
		Assertions.assertEquals(ID, resultado.getContent().get(0).getId());
		Assertions.assertEquals(NAME_OWNER, resultado.getContent().get(0).getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, resultado.getContent().get(0).getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, resultado.getContent().get(0).getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, resultado.getContent().get(0).getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, resultado.getContent().get(0).getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, resultado.getContent().get(0).getCardModel());
		
		Assertions.assertEquals(ID, resultado.getContent().get(1).getId());
		Assertions.assertEquals(NAME_OWNER, resultado.getContent().get(1).getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, resultado.getContent().get(1).getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, resultado.getContent().get(1).getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, resultado.getContent().get(1).getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, resultado.getContent().get(1).getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, resultado.getContent().get(1).getCardModel());
		
		Assertions.assertEquals(ID, resultado.getContent().get(2).getId());
		Assertions.assertEquals(NAME_OWNER, resultado.getContent().get(2).getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, resultado.getContent().get(2).getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, resultado.getContent().get(2).getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, resultado.getContent().get(2).getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, resultado.getContent().get(2).getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, resultado.getContent().get(2).getCardModel());
	}
	
	@Test
	public void shouldDeleteAccountInstance() {
		accountRepository.delete(accountModel);
	}
	
	@Test
	public void whenUpdateShoulReturnAccountInstance() {
		when(accountRepository.findById(ID)).thenReturn(accountOpt);
		accountModel = accountService.update(accountModel, ID);
		
		Assertions.assertNotNull(accountModel);
		Assertions.assertEquals(ID, accountModel.getId());
		Assertions.assertEquals(NAME_OWNER, accountModel.getNameOwner());
		Assertions.assertEquals(AGENCY_CODE, accountModel.getAgencyCode());
		Assertions.assertEquals(ACCOUNT_CODE, accountModel.getAccountCode());
		Assertions.assertEquals(VERIFICATION_DIGITAL, accountModel.getVerificationDigital());
		Assertions.assertEquals(REGISTER_ID, accountModel.getRegisterId());
		Assertions.assertEquals(CARD_MODEL_LIST, accountModel.getCardModel());
	}
	
	
	
	@Test
	public void whenFindByIdNotFoundShouldThrowAnErrorUsuarioException() {		
		
		when(accountRepository.findById(ID_INVALIDO))
		.thenThrow(new NotFoundException(USUARIO_NAO_ENCONTRADO));
		
		try {
			accountService.findById(ID_INVALIDO);
		} catch(NotFoundException e) {
			Assertions.assertEquals(NotFoundException.class, e.getClass());
			Assertions.assertEquals(USUARIO_NAO_ENCONTRADO, e.getMessage());
		}
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			accountService.findById(ID_INVALIDO);
		});
		
	}
	
	

}
