package com.bootcamp.itexperts.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TB_ACCOUNTS", uniqueConstraints= {
		@UniqueConstraint(name="unique_account_code", columnNames= {"account_code"}),
		@UniqueConstraint(name="unique_register_id", columnNames= {"register_id"})})
public class AccountModel implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name_owner", nullable = false, length = 50)
	private String nameOwner;
	@Column(name = "agency_code", nullable = false, length = 5)
	private String agencyCode;
	@Column(name = "account_code", nullable = false, length = 10)
	private String accountCode;
	@Column(name = "verification_digital", nullable = false, length = 1)
	private String verificationDigital;
	@Column(name = "register_id", nullable = false, length = 20)
	private String registerId;
	@OneToMany(mappedBy = "accountModelId")
	private List<CardModel> cardModel;
	
	
		
	public AccountModel() {
	}

	public AccountModel(Integer id, String nameOwner, String agencyCode, String accountCode, String verificationDigital,
			String registerId, List<CardModel> cardModel) {
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigital = verificationDigital;
		this.registerId = registerId;
		this.cardModel = cardModel;
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
