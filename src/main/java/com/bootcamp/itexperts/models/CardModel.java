package com.bootcamp.itexperts.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bootcamp.itexperts.enums.Flag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CARDS", uniqueConstraints= {
		@UniqueConstraint(name="unique_number", columnNames= {"number"})})
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
	@Column(name = "flag", nullable = false, length = 45)
	@Enumerated(EnumType.STRING)
	private Flag flag;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_model_id")
	private AccountModel accountModelId;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_card_model_id")
	private TypeCardModel typeCardModelId;
	
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

	
	public CardModel() {
	}

	public CardModel(Integer id, String name, String number, String digitCode, Double limitBalance, Flag flag,
			AccountModel accountModelId, TypeCardModel typeCardModelId) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.flag = flag;
		this.accountModelId = accountModelId;
		this.typeCardModelId = typeCardModelId;
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

	@JsonBackReference
	public AccountModel getAccountModelId() {
		return accountModelId;
	}

	public void setAccountModelId(AccountModel accountModelId) {
		this.accountModelId = accountModelId;
	}

	public TypeCardModel getTypeCardModelId() {
		return typeCardModelId;
	}

	public void setTypeCardModelId(TypeCardModel typeCardModelId) {
		this.typeCardModelId = typeCardModelId;
	}
	

}
