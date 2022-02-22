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
	@Column(nullable = false, length = 50)
	private String nameOwner;
	@Column(nullable = false, length = 5)
	private Integer agencyCode;
	@Column(nullable = false, unique = true, length = 10)
	private Integer accountCode;
	@Column(nullable = false, unique = true, length = 1)
	private Integer digitVerification;
	@Column(nullable = false, unique = true, length = 20)
	private Integer registerId;
	
	
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
	public Integer getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(Integer agencyCode) {
		this.agencyCode = agencyCode;
	}
	public Integer getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(Integer accountCode) {
		this.accountCode = accountCode;
	}
	public Integer getDigitVerification() {
		return digitVerification;
	}
	public void setDigitVerification(Integer digitVerification) {
		this.digitVerification = digitVerification;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	
	

}
