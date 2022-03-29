package com.bootcamp.itexperts.controllers.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.bootcamp.itexperts.dtos.RequestAccountDto;
import com.bootcamp.itexperts.dtos.RequestCardDto;
import com.bootcamp.itexperts.dtos.ResponseAccountDto;
import com.bootcamp.itexperts.dtos.ResponseCardDto;
import com.bootcamp.itexperts.dtos.TypeCardDto;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;

@Component
public class Mapper {


	public ModelMapper modelMapper = new ModelMapper();
	
	@Bean
	public ModelMapper modelMapper() {
				
		modelMapper.typeMap(RequestAccountDto.class, AccountModel.class).addMappings(map -> map.skip(AccountModel::setId));
		modelMapper.typeMap(RequestCardDto.class, CardModel.class).addMappings(map -> map.skip(CardModel::setId));
		modelMapper.typeMap(TypeCardDto.class, TypeCardModel.class).addMappings(map -> map.skip(TypeCardModel::setId));
		return modelMapper;
	}	
		
	public Page<RequestAccountDto> accountModelToDtoPage(Page<AccountModel> accountModel){
		return accountModel.map(x -> new RequestAccountDto(x));
	}
	
	public Page<ResponseAccountDto> accountModelToResponseAccountDtoPage(Page<AccountModel> accountModel){
		return accountModel.map(x -> new ResponseAccountDto(x));
	}
	
	
	public Page<RequestCardDto> cardModelToDtoPage(Page<CardModel> cardModel){
		return cardModel.map(x -> new RequestCardDto(x));
	}
	
	public Page<ResponseCardDto> cardModelToResponseDtoPage(Page<CardModel> cardModel){
		return cardModel.map(x -> new ResponseCardDto(x));
	}	
}
