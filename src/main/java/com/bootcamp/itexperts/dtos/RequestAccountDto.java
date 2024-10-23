package com.bootcamp.itexperts.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.bootcamp.itexperts.models.AccountModel;
import com.bootcamp.itexperts.models.CardModel;

public class RequestAccountDto {
	
	
	@NotBlank(message = "Name owner is mandatory, please fill this field")
	@Size(max = 50)
	private String nameOwner;
	@NotBlank(message = "Agency code is mandatory, please fill this field")
	@Size(max = 5)
	private String agencyCode;
	@NotBlank(message = "Account code is mandatory, please fill this field")
	@Size(max = 10)
	private String accountCode;
	@NotBlank(message = "Verification digital is mandatory, please fill this field")
	@Size(max = 1)
	private String verificationDigital;
	@NotBlank(message = "CPF is mandatory, please fill this field")
	@CPF
	@Size(max = 20)
	private String registerId;

	private List<CardModel> cardModel;
		
	public RequestAccountDto() {
	}

	public RequestAccountDto(
			@NotBlank(message = "Name owner is mandatory, please fill this field") @Size(max = 50) String nameOwner,
			@NotBlank(message = "Agency code is mandatory, please fill this field") @Size(max = 5) String agencyCode,
			@NotBlank(message = "Account code is mandatory, please fill this field") @Size(max = 10) String accountCode,
			@NotBlank(message = "Verification digital is mandatory, please fill this field") @Size(max = 1) String verificationDigital,
			@NotBlank(message = "CPF is mandatory, please fill this field") @Size(max = 20) String registerId,
			List<CardModel> cardModel) {
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigital = verificationDigital;
		this.registerId = registerId;
		this.cardModel = cardModel;
	}

	public RequestAccountDto(AccountModel accountModel) {
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
		this.cardModel = accountModel.getCardModel();
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
