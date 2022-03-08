package com.bootcamp.itexperts.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TYPE_CARDS")
public class TypeCardModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", nullable = true, length = 45)
	private String name;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "typeCardModelId")
	private CardModel cardModelId;
	
	public TypeCardModel() {
	}

	public TypeCardModel(Integer id, String name, CardModel cardModelId) {
		this.id = id;
		this.name = name;
		this.cardModelId = cardModelId;
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

	public CardModel getCardModelId() {
		return cardModelId;
	}

	public void setCardModelId(CardModel cardModelId) {
		this.cardModelId = cardModelId;
	}	
}
