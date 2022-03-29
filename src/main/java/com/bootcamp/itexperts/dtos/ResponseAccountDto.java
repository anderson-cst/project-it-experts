package com.bootcamp.itexperts.dtos;

import java.util.List;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;

public class ResponseAccountDto {

	private Integer id;
	private String nameOwner;
	private String agencyCode;
	private String accountCode;
	private String verificationDigital;
	private String registerId;
	private List<CardModel> cardModel;
	
	public ResponseAccountDto() {
	}
	
	public ResponseAccountDto(Integer id, String nameOwner, String agencyCode, String accountCode,
			String verificationDigital, String registerId, List<CardModel> cardModel) {
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigital = verificationDigital;
		this.registerId = registerId;
		this.cardModel = cardModel;
	}

	public ResponseAccountDto(AccountModel accountModel) {
		this.id = accountModel.getId();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
		this.cardModel = accountModel.getCardModel();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getVerificationDigital() {
		return verificationDigital;
	}

	public void setVerificationDigital(String verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public List<CardModel> getCardModel() {
		return cardModel;
	}

	public void setCardModel(List<CardModel> cardModel) {
		this.cardModel = cardModel;
	}	
}
