package com.bootcamp.itexperts.dtos;

import com.bootcamp.itexperts.enums.Flag;
import com.bootcamp.itexperts.models.CardModel;
import com.bootcamp.itexperts.models.TypeCardModel;

public class ResponseCardDto {
	
	private Integer id;
	private String name;
	private String number;
	private String digitCode;
	private Double limitBalance;
	private Flag flag;
	private TypeCardModel typeCardModelId;
	
	public ResponseCardDto() {
	}
	
	public ResponseCardDto(Integer id, String name, String number, String digitCode, Double limitBalance, Flag flag,
			TypeCardModel typeCardModelId) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.flag = flag;
		this.typeCardModelId = typeCardModelId;
	}
	
	public ResponseCardDto(CardModel cardModel) {
		this.id = cardModel.getId();
		this.name = cardModel.getName();
		this.number = cardModel.getNumber();
		this.digitCode = cardModel.getDigitCode();
		this.limitBalance = cardModel.getLimitBalance();
		this.flag = cardModel.getFlag();
		this.typeCardModelId = cardModel.getTypeCardModelId();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return typeCardModelId;
	}

	public void setTypeCardModelId(TypeCardModel typeCardModelId) {
		this.typeCardModelId = typeCardModelId;
	}
}
