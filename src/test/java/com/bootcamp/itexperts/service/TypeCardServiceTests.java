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

import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;
import com.bootcamp.itexperts.repositories.TypeCardRepository;
import com.bootcamp.itexperts.services.TypeCardService;
import com.bootcamp.itexperts.services.exceptions.NotFoundException;

@SpringBootTest
public class TypeCardServiceTests {
	
	@InjectMocks
	private TypeCardService typeCardService;
	
	@MockBean
	private TypeCardRepository typeCardRepository;

	
	private static AccountModel accountModel;
	private static CardModel cardModel;
	private static TypeCardModel typeCardModel;
	private static TypeCardModel typeCardReturn;
	private static Optional<TypeCardModel> typeCardOpt;
	
	private static final Integer ID = 1;
	private static final String NAME_OWNER = "Anderson Costa";
	private static final String AGENCY_CODE = "12345";
	private static final String ACCOUNT_CODE = "1234567890";
	private static final String VERIFICATION_DIGITAL = "5";
	private static final String REGISTER_ID = "11122233344";
	private static List<CardModel> CARD_MODEL_LIST;
	
	private static final Integer ID_TYPE = 1;
	private static final String NAME_TYPE = "CREDIT_CARD";	
	
	private static final Integer ID_CARD = 1;
	private static final String NAME = "Black Card";
	private static final String NUMBER = "1111222233334444";
	private static final String DIGIT_CODE = "54321";
	private static final Double LIMIT_BALANCE = 1000.00;
	private static final Flag FLAG = Flag.MASTERCARD;
	private static final AccountModel ACCOUNT_MODEL_ID = accountModel;
	private static final TypeCardModel TYPE_CARD_MODEL_ID = typeCardModel;

	private static final Integer ID_INVALIDO = 1000;
	private static final String USUARIO_NAO_ENCONTRADO = "Usuario não encontrado";

	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		startResources();
	}
	
	private void startResources() {
		cardModel = new CardModel(ID_CARD, NAME, NUMBER, DIGIT_CODE, LIMIT_BALANCE, FLAG, ACCOUNT_MODEL_ID, TYPE_CARD_MODEL_ID);
		CARD_MODEL_LIST = new ArrayList<CardModel>();
		CARD_MODEL_LIST.add(cardModel);
		accountModel = new AccountModel(ID, NAME_OWNER, AGENCY_CODE, ACCOUNT_CODE, VERIFICATION_DIGITAL, REGISTER_ID, CARD_MODEL_LIST);
		typeCardReturn = new TypeCardModel(ID_TYPE, NAME_TYPE, cardModel);
		typeCardModel = new TypeCardModel(ID_TYPE, NAME_TYPE, cardModel);
		typeCardOpt = Optional.of(new TypeCardModel(ID_TYPE, NAME_TYPE, cardModel));
	}
	
	
	@Test
	public void whenSaveShouldReturnTypeCardInstance() {
		when(typeCardRepository.save(typeCardModel)).thenReturn(typeCardReturn);		
		typeCardModel = typeCardService.save(typeCardModel);
		
		Assertions.assertNotNull(typeCardModel);
		Assertions.assertEquals(ID_TYPE, typeCardModel.getId());
		Assertions.assertEquals(NAME_TYPE, typeCardModel.getName());
	}
	
	@Test
	public void whenFindIdShouldReturnTypeCardInstance() {
		when(typeCardRepository.findById(ID_TYPE)).thenReturn(typeCardOpt);
		typeCardModel = typeCardService.findById(ID_TYPE);
		
		Assertions.assertNotNull(typeCardModel);
		Assertions.assertEquals(ID_TYPE, typeCardModel.getId());
		Assertions.assertEquals(NAME_TYPE, typeCardModel.getName());
	}
	
	
	
	@Test
	public void shouldDeleteTypeCardInstance() {
		typeCardRepository.delete(typeCardModel);
	}
	
	@Test
	public void whenUpdateShoulReturnTypeCardInstance() {
		when(typeCardRepository.findById(ID_TYPE)).thenReturn(typeCardOpt);
		typeCardModel = typeCardService.update(typeCardModel, ID_TYPE);
		
		Assertions.assertNotNull(typeCardModel);
		Assertions.assertEquals(ID_TYPE, typeCardModel.getId());
		Assertions.assertEquals(NAME_TYPE, typeCardModel.getName());
	}
	
	
	
	@Test
	public void whenFindByIdNotFoundShouldThrowAnErrorNotFoundException() {		
		
		when(typeCardRepository.findById(ID_INVALIDO))
		.thenThrow(new NotFoundException(USUARIO_NAO_ENCONTRADO));
		
		try {
			typeCardService.findById(ID_INVALIDO);
		} catch(NotFoundException e) {
			Assertions.assertEquals(NotFoundException.class, e.getClass());
			Assertions.assertEquals(USUARIO_NAO_ENCONTRADO, e.getMessage());
		}
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			typeCardService.findById(ID_INVALIDO);
		});
	}
}
