package com.bootcamp.itexperts.models;

import com.bootcamp.itexperts.enums.Flag;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CardModel.class)
public abstract class CardModel_ {

	public static volatile SingularAttribute<CardModel, String> number;
	public static volatile SingularAttribute<CardModel, String> digitCode;
	public static volatile SingularAttribute<CardModel, Flag> flag;
	public static volatile SingularAttribute<CardModel, String> name;
	public static volatile SingularAttribute<CardModel, Integer> id;
	public static volatile SingularAttribute<CardModel, AccountModel> accountModelId;
	public static volatile SingularAttribute<CardModel, TypeCardModel> typeCardModelId;
	public static volatile SingularAttribute<CardModel, Double> limitBalance;

	public static final String NUMBER = "number";
	public static final String DIGIT_CODE = "digitCode";
	public static final String FLAG = "flag";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String ACCOUNT_MODEL_ID = "accountModelId";
	public static final String TYPE_CARD_MODEL_ID = "typeCardModelId";
	public static final String LIMIT_BALANCE = "limitBalance";

}

