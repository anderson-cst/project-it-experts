package com.bootcamp.itexperts.dtos;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.bootcamp.itexperts.models.AccountModel;

public class CardDto {

	@NotBlank(message = "Name of card is mandatory, please fill this field")
	@Length(max = 128)
	private String name;
	@NotBlank(message = "Number of card is mandatory, please fill this field")
	@Length(min = 20, max = 20)
	private String number;
	@NotBlank(message = "Digit code is mandatory, please fill this field")
	@Length(max = 5)
	private String digitCode;
	@NotBlank(message = "Limit balance is mandatory, please fill this field")
	@Length(max = 20)
	private Double limitBalance;
	@NotBlank(message = "Account is mandatory, please fill this field")
	@Length(max = 20)
	private AccountModel accountModelId;
	
			
	public CardDto() {
	}

	public CardDto(
			@NotBlank(message = "Name of card is mandatory, please fill this field") @Length(max = 128) String name,
			@NotBlank(message = "Number of card is mandatory, please fill this field") @Length(min = 20, max = 20) String number,
			@NotBlank(message = "Digit code is mandatory, please fill this field") @Length(max = 5) String digitCode,
			@NotBlank(message = "Limit balance is mandatory, please fill this field") @Length(max = 20) Double limitBalance,
			@NotBlank(message = "Limit balance is mandatory, please fill this field") @Length(max = 20) AccountModel accountModelId) {
		super();
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.accountModelId = accountModelId;
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
	public AccountModel getAccountModelId() {
		return accountModelId;
	}
	public void setAccountModelId(AccountModel accountModelId) {
		this.accountModelId = accountModelId;
	}
	
	
	
}
