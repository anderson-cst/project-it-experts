package com.bootcamp.itexperts.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bootcamp.itexperts.controllers.AccountController;
import com.bootcamp.itexperts.controllers.mapper.Mapper;
import com.bootcamp.itexperts.dtos.AccountDto;
import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.services.AccountService;


@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTests {

	@InjectMocks
	private AccountController accountController;
	
	@MockBean
	private Mapper mapper;
			
	@MockBean
	private AccountService accountService;
	
	private static final Integer ID = 1;
	private static final String NAME_OWNER = "Anderson Costa";
	private static final String AGENCY_CODE = "12345";
	private static final String ACCOUNT_CODE = "1234567890";
	private static final String VERIFICATION_DIGITAL = "5";
	private static final String REGISTER_ID = "11122233344";
	private static List<CardModel> CARD_MODEL_LIST;

	
	private static AccountModel accountModel;
	private CardModel cardModel;
	private static TypeCardModel typeCardModel;
	private AccountModel accountReturn;
	private AccountDto accountDto;
	private Optional<AccountModel> accountOpt;
	
	
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
		MockitoAnnotations.openMocks(this);
		startAccountModel();
	}
	
	private void startAccountModel() {
		cardModel = new CardModel(id, name, number, digitCode, limitBalance, flag, accountModelId, typeCardModelId);
		CARD_MODEL_LIST = new ArrayList<CardModel>();
		CARD_MODEL_LIST.add(cardModel);
		accountModel = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountDto = new AccountDto(NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountReturn = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		accountOpt = Optional.of(new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST));
	}

//	@Test
//	public void shouldCreateAccountShouldReturnStatusCreated() {
//				
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//		AccountService accountService = new AccountService(new Mapper());
//
//		when(accountService.save(accountModel)).thenReturn(accountReturn);
//		
//		ResponseEntity<Object> result = accountController.saveAccounts(accountDto);
//
//		Assertions.assertEquals(ResponseEntity.class, result.getClass());
//		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
//		Assertions.assertNotNull(result.getHeaders().get("location"));
//		Assertions.assertFalse(result.hasBody());
//	}
	
//	@Test
//	public void shouldFindByIdAccountAndThenReturnSuccess() {
//
//		AccountService accountService = new AccountService(new Mapper());
//		when(accountService.findById(ID)).thenReturn(accountReturn);
//
//		ResponseEntity<AccountDto> result = accountController.getAccountsById(ID);
//
//		Assertions.assertNotNull(result);
//		Assertions.assertNotNull(result.getBody());
//		Assertions.assertTrue(result.hasBody());
//		Assertions.assertEquals(true, result.getStatusCode().is2xxSuccessful());
//		Assertions.assertEquals(200, result.getStatusCode().value());
//
//		//Assertions.assertEquals(ID, result.getBody().getId());
//		Assertions.assertEquals(NAME_OWNER, result.getBody().getNameOwner());
//		//Assertions.assertEquals(EMAIL, result.getBody().getEmail());
//		//Assertions.assertNotNull(result.getBody().getDataCriacao());
//
//	}
	
	
	
	
	
	
	
	
	
	
}
