package com.bootcamp.itexperts.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class AccountDto {
	
	
	@NotBlank(message = "Name owner is mandatory, please fill this field")
	@Length(max = 50)
	private String nameOwner;
	@NotBlank(message = "Agency code is mandatory, please fill this field")
	@Length(max = 5)
	private String agencyCode;
	@NotBlank(message = "Account code is mandatory, please fill this field")
	@Length(max = 10)
	private String accountCode;
	@NotBlank(message = "Verification digital is mandatory, please fill this field")
	@Length(max = 1)
	private String verificationDigital;
	@NotBlank(message = "CPF is mandatory, please fill this field")
	//@CPF
	@Length(max = 20)
	private String registerId;
	
		
		
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
	
	

}
