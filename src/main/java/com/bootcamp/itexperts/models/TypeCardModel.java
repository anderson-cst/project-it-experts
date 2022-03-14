package com.bootcamp.itexperts.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "TB_TYPE_CARDS")
public class TypeCardModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@OneToOne//(cascade = CascadeType.ALL)//(mappedBy = "typeCardModelId")
//	private CardModel cardModel;
	
	public TypeCardModel() {
	}

	public TypeCardModel(Integer id, String name, CardModel cardModel) {
		this.id = id;
		this.name = name;
//		this.cardModel = cardModel;
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
	
	//@JsonManagedReference
//	public CardModel getCardModel() {
//		return cardModel;
//	}
//
//	public void setCardModel(CardModel cardModel) {
//		this.cardModel = cardModel;
//	}	
}
