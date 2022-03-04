package com.bootcamp.itexperts.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_CARDS")
public class CardModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Column(name = "number", nullable = false, length = 45)
	private String number;
	@Column(name = "digit_code", nullable = false, length = 5)
	private String digitCode;
	@Column(name = "limit_balance", nullable = false, length = 14)
	private Double limitBalance;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_model_id")
	private AccountModel accountModelId;
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	//@JsonIgnore
	
	//private Flag flag;
	//private Type typeCardId;
	
	public CardModel() {
	}
	
	public CardModel(Integer id, String name, String number, String digitCode, Double limitBalance,
			AccountModel accountModelId) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.accountModelId = accountModelId;
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
	@JsonBackReference
	public AccountModel getAccountId() {
		return accountModelId;
	}
	public void setAccountId(AccountModel accountModelId) {
		this.accountModelId = accountModelId;
	}
	
	

}
