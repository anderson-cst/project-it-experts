package com.bootcamp.itexperts.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import com.bootcamp.itexperts.services.CardService;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;

@SpringBootTest
public class CardServiceTests {
	
	
	@InjectMocks
	private CardService cardService;
		
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
	private Pageable pageable;
	private CardModel cardModel;
	private Optional<CardModel> cardOpt;
	private static TypeCardModel typeCardModel;
	private CardModel cardReturn;
	private CardModel cardReturn2;
	private CardModel cardReturn3;
	
	
	private static final Integer ID_CARD = 1;
	private static final String NAME = "Black Card";
	private static final String NUMBER = "1111222233334444";
	private static final String DIGIT_CODE = "54321";
	private static final Double LIMIT_BALANCE = 1000.00;
	private static final Flag FLAG = Flag.MASTERCARD;
	private static final AccountModel ACCOUNT_MODEL_ID = accountModel;
	private static final TypeCardModel TYPE_CARD_MODEL_ID = typeCardModel;

	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		startResources();
	}
	
	private void startResources() {
		cardModel = new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID);
		cardOpt = Optional.of(new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID));
		cardReturn = new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID);
		cardReturn2 = new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID);
		cardReturn3 = new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID);
		CARD_MODEL_LIST = new ArrayList<CardModel>();
		CARD_MODEL_LIST.add(cardModel);
		accountModel = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
	}
	
	
//	@Test
//	public void whenSaveShouldReturnCardInstance() {
//		when(cardRepository.save(cardModel)).thenReturn(cardReturn);
//		cardModel = cardService.save(cardModel);
//		
//		Assertions.assertNotNull(cardModel);
//		Assertions.assertEquals(ID_CARD, cardModel.getId());
//		Assertions.assertEquals(NAME, cardModel.getName());
//		Assertions.assertEquals(NUMBER, cardModel.getNumber());
//		Assertions.assertEquals(DIGIT_CODE, cardModel.getDigitCode());
//		Assertions.assertEquals(LIMIT_BALANCE, cardModel.getLimitBalance());
//		Assertions.assertEquals(FLAG, cardModel.getFlag());
//		Assertions.assertEquals(ACCOUNT_MODEL_ID, cardModel.getAccountModelId());
//		Assertions.assertEquals(TYPE_CARD_MODEL_ID, cardModel.getTypeCardModelId());
//	}
	
	@Test
	public void whenFindIdShouldReturnCardInstance() {
		when(cardRepository.findById(ID_CARD)).thenReturn(cardOpt);
		cardModel = cardService.findById(ID_CARD);
		
		Assertions.assertNotNull(cardModel);
		Assertions.assertEquals(ID_CARD, cardModel.getId());
		Assertions.assertEquals(NAME, cardModel.getName());
		Assertions.assertEquals(NUMBER, cardModel.getNumber());
		Assertions.assertEquals(DIGIT_CODE, cardModel.getDigitCode());
		Assertions.assertEquals(LIMIT_BALANCE, cardModel.getLimitBalance());
		Assertions.assertEquals(FLAG, cardModel.getFlag());
		Assertions.assertEquals(ACCOUNT_MODEL_ID, cardModel.getAccountModelId());
		Assertions.assertEquals(TYPE_CARD_MODEL_ID, cardModel.getTypeCardModelId());
	}
	
	@Test
	public void shouldFindAllCardsReturnPaginationResource() {
		when(cardRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(cardReturn, cardReturn2, cardReturn3)));
		
		Page<CardModel> resultado = cardService.findAll(pageable);
		
		Assertions.assertNotNull(resultado);
		
		Assertions.assertEquals(ID_CARD, resultado.getContent().get(0).getId());
		Assertions.assertEquals(NAME, resultado.getContent().get(0).getName());
		Assertions.assertEquals(NUMBER, resultado.getContent().get(0).getNumber());
		Assertions.assertEquals(DIGIT_CODE, resultado.getContent().get(0).getDigitCode());
		Assertions.assertEquals(LIMIT_BALANCE, resultado.getContent().get(0).getLimitBalance());
		Assertions.assertEquals(FLAG, resultado.getContent().get(0).getFlag());
		Assertions.assertEquals(ACCOUNT_MODEL_ID, resultado.getContent().get(0).getAccountModelId());
		Assertions.assertEquals(TYPE_CARD_MODEL_ID, resultado.getContent().get(0).getTypeCardModelId());
		
		Assertions.assertEquals(ID_CARD, resultado.getContent().get(0).getId());
		Assertions.assertEquals(NAME, resultado.getContent().get(0).getName());
		Assertions.assertEquals(NUMBER, resultado.getContent().get(0).getNumber());
		Assertions.assertEquals(DIGIT_CODE, resultado.getContent().get(0).getDigitCode());
		Assertions.assertEquals(LIMIT_BALANCE, resultado.getContent().get(0).getLimitBalance());
		Assertions.assertEquals(FLAG, resultado.getContent().get(0).getFlag());
		Assertions.assertEquals(ACCOUNT_MODEL_ID, resultado.getContent().get(0).getAccountModelId());
		Assertions.assertEquals(TYPE_CARD_MODEL_ID, resultado.getContent().get(0).getTypeCardModelId());
		
		Assertions.assertEquals(ID_CARD, resultado.getContent().get(0).getId());
		Assertions.assertEquals(NAME, resultado.getContent().get(0).getName());
		Assertions.assertEquals(NUMBER, resultado.getContent().get(0).getNumber());
		Assertions.assertEquals(DIGIT_CODE, resultado.getContent().get(0).getDigitCode());
		Assertions.assertEquals(LIMIT_BALANCE, resultado.getContent().get(0).getLimitBalance());
		Assertions.assertEquals(FLAG, resultado.getContent().get(0).getFlag());
		Assertions.assertEquals(ACCOUNT_MODEL_ID, resultado.getContent().get(0).getAccountModelId());
		Assertions.assertEquals(TYPE_CARD_MODEL_ID, resultado.getContent().get(0).getTypeCardModelId());
	}
	
	@Test
	public void shouldDeleteCardInstance() {
		cardRepository.delete(cardModel);
	}
	
	@Test
	public void whenUpdateShoulReturnCardInstance() {
		when(cardRepository.findById(ID_CARD)).thenReturn(cardOpt);
		cardModel = cardService.update(cardModel, ID_CARD);
		
		Assertions.assertNotNull(cardModel);
		Assertions.assertEquals(ID_CARD, cardModel.getId());
		Assertions.assertEquals(NAME, cardModel.getName());
		Assertions.assertEquals(NUMBER, cardModel.getNumber());
		Assertions.assertEquals(DIGIT_CODE, cardModel.getDigitCode());
		Assertions.assertEquals(LIMIT_BALANCE, cardModel.getLimitBalance());
		Assertions.assertEquals(FLAG, cardModel.getFlag());
		Assertions.assertEquals(ACCOUNT_MODEL_ID, cardModel.getAccountModelId());
		Assertions.assertEquals(TYPE_CARD_MODEL_ID, cardModel.getTypeCardModelId());
	}
	
	
	
	@Test
	public void whenFindByIdNotFoundShouldThrowAnErrorNotFoundException() {		
		
		when(cardRepository.findById(ID_INVALIDO))
		.thenThrow(new NotFoundException(USUARIO_NAO_ENCONTRADO));
		
		try {
			cardService.findById(ID_INVALIDO);
		} catch(NotFoundException e) {
			Assertions.assertEquals(NotFoundException.class, e.getClass());
			Assertions.assertEquals(USUARIO_NAO_ENCONTRADO, e.getMessage());
		}
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			cardService.findById(ID_INVALIDO);
		});
		
	}


}
