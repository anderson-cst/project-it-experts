package com.bootcamp.itexperts.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;

public class RequestCardDto {

	@NotBlank(message = "Name of card is mandatory, please fill this field")
	@Size(max = 128)
	private String name;
	@NotBlank(message = "Number of card is mandatory, please fill this field")
	@Size(min = 20, max = 20, message = "Maximum and minimum value are 20 characters")
	private String number;
	@NotBlank(message = "Digit code is mandatory, please fill this field")
	@Size(min = 5, max = 5, message = "Maximum and minimum value are 5 characters")
	private String digitCode;
	@NotNull(message = "Limit balance is mandatory, please fill this field")
	@Digits(integer = 14, fraction = 2)
	private Double limitBalance;
	@NotNull(message = "Flag is mandatory, please select a option - [MASTERCARD] - [VISA] - [ELO]")
	private Flag flag;
	@NotNull(message = "Type Card is mandatory, please fill this field")
	private TypeCardModel typeCardModelId;
	 
			
	public RequestCardDto() {
	}	
	
	public RequestCardDto(
			@NotBlank(message = "Name of card is mandatory, please fill this field") @Size(max = 128) String name,
			@NotBlank(message = "Number of card is mandatory, please fill this field") @Size(min = 20, max = 20, message = "Maximum and minimum value are 20 characters") String number,
			@NotBlank(message = "Digit code is mandatory, please fill this field") @Size(min = 5, max = 5, message = "Maximum and minimum value are 5 characters") String digitCode,
			@NotNull(message = "Limit balance is mandatory, please fill this field") @Digits(integer = 14, fraction = 2) Double limitBalance,
			@NotNull(message = "Flag is mandatory, please select a option - [MASTERCARD] - [VISA] - [ELO]") Flag flag,
			@NotNull(message = "Type Card is mandatory, please fill this field") TypeCardModel typeCardModelId) {
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.flag = flag;
		this.typeCardModelId = typeCardModelId;
	}

	public RequestCardDto(CardModel cardModel) {
		this.name = cardModel.getName();
		this.number = cardModel.getNumber();
		this.digitCode = cardModel.getDigitCode();
		this.limitBalance = cardModel.getLimitBalance();
		this.flag = cardModel.getFlag();
		this.typeCardModelId = cardModel.getTypeCardModelId();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDigitCode() {
		return digitCode;
	}

	public void setDigitCode(String digitCode) {
		this.digitCode = digitCode;
	}

	public Double getLimitBalance() {
		return limitBalance;
	}

	public void setLimitBalance(Double limitBalance) {
		this.limitBalance = limitBalance;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public TypeCardModel getTypeCardModelId() {
		return typeCardModelId; }
	  
	public void setTypeCardModelId(TypeCardModel typeCardModelId) {
	  this.typeCardModelId = typeCardModelId; }
	 	
}
