package com.bootcamp.itexperts.controllers.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.bootcamp.itexperts.dtos.AccountDto;
import com.bootcamp.itexperts.dtos.CardDto;
import com.bootcamp.itexperts.dtos.TypeCardDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;

@Component
public class Mapper {


	public ModelMapper modelMapper = new ModelMapper();
	
	@Bean
	public ModelMapper modelMapper() {
				
		modelMapper.typeMap(AccountDto.class, AccountModel.class).addMappings(map -> map.skip(AccountModel::setId));
		modelMapper.typeMap(CardDto.class, CardModel.class).addMappings(map -> map.skip(CardModel::setId));
		modelMapper.typeMap(TypeCardDto.class, TypeCardModel.class).addMappings(map -> map.skip(TypeCardModel::setId));
		return modelMapper;
	}	
		
	public Page<AccountDto> accountModelToDtoPage(Page<AccountModel> accountModel){
		return accountModel.map(x -> new AccountDto(x));
	}
	
	public AccountModel accountDtoToModel(AccountDto accountDto) {
		return modelMapper.map(accountDto, AccountModel.class);
	}
	
	public AccountDto accountModelToDto(AccountModel accountModel) {
		return modelMapper.map(accountModel, AccountDto.class);
	}
	
	public Page<CardDto> cardModelToDtoPage(Page<CardModel> cardModel){
		return cardModel.map(x -> new CardDto(x));
	}
	
	public CardModel cardDtoToModel(CardDto cardDto) {
		return modelMapper.map(cardDto, CardModel.class);
	}
	
	public CardDto cardModelToDto(CardModel cardModel) {
		return modelMapper.map(cardModel, CardDto.class);
	}	
}
