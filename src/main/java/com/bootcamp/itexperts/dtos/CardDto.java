package com.bootcamp.itexperts.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.TypeCardModel;

public class CardDto {

	//@NotBlank(message = "Name of card is mandatory, please fill this field")
	//@Size(max = 128)
	private String name;
	//@NotBlank(message = "Number of card is mandatory, please fill this field")
	//@Size(min = 20, max = 20)
	private String number;
	//@NotBlank(message = "Digit code is mandatory, please fill this field")
	//@Size(max = 5)
	private String digitCode;
	//@NotBlank(message = "Limit balance is mandatory, please fill this field")
	//@Size(max = 20)
	private Double limitBalance;
	//@NotBlank(message = "Flag is mandatory, please select a option - [MASTERCARD] - [VISA] - [ELO]")
	//@Size(max = 45)
	private Flag flag;
	//@NotBlank(message = "Account is mandatory, please fill this field")
	private AccountModel accountModelId;
//	@NotBlank(message = "Type Card is mandatory, please fill this field")
//	@Size(max = 20)
	private TypeCardModel typeCardModelId;
	 
			
	public CardDto() {
	}

	public CardDto(
			@NotBlank(message = "Name of card is mandatory, please fill this field") @Size(max = 128) String name,
			@NotBlank(message = "Number of card is mandatory, please fill this field") @Size(min = 20, max = 20) String number,
			@NotBlank(message = "Digit code is mandatory, please fill this field") @Size(max = 5) String digitCode,
			@NotBlank(message = "Limit balance is mandatory, please fill this field") @Size(max = 20) Double limitBalance,
			@NotBlank(message = "Flag is mandatory, please select a option - [MASTERCAR] - [VISA] - [ELO]") @Size(max = 45) Flag flag,
			@NotBlank(message = "Account is mandatory, please fill this field") @Size(max = 20) AccountModel accountModelId,
			@NotBlank(message = "Type Card is mandatory, please fill this field") @Size(max = 20) TypeCardModel typeCardModelId) {
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.flag = flag;
		this.accountModelId = accountModelId;
		this.typeCardModelId = typeCardModelId;
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

	public AccountModel getAccountModelId() {
		return accountModelId;
	}

	public void setAccountModelId(AccountModel accountModelId) {
		this.accountModelId = accountModelId;
	}

	public TypeCardModel getTypeCardModelId() {
		return typeCardModelId; }
	  
	public void setTypeCardModelId(TypeCardModel typeCardModelId) {
	  this.typeCardModelId = typeCardModelId; }
	 	
}