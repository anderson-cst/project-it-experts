package com.bootcamp.itexperts.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_accounts")
public class AccountModel implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nameOwner", nullable = false, length = 50)
	private String nameOwner;
	@Column(name = "agencyCode", nullable = false, length = 5)
	private String agencyCode;
	@Column(name = "accountCode", nullable = false, unique = true, length = 10)
	private String accountCode;
	@Column(name = "verificationDigital", nullable = false, length = 1)
	private String verificationDigital;
	@Column(name = "registerId", nullable = false, unique = true, length = 20)
	private String registerId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	

}
