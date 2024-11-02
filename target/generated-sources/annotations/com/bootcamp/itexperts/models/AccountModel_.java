package com.bootcamp.itexperts.models;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountModel.class)
public abstract class AccountModel_ {

	public static volatile SingularAttribute<AccountModel, String> accountCode;
	public static volatile SingularAttribute<AccountModel, String> nameOwner;
	public static volatile SingularAttribute<AccountModel, String> verificationDigital;
	public static volatile SingularAttribute<AccountModel, String> registerId;
	public static volatile SingularAttribute<AccountModel, Integer> id;
	public static volatile SingularAttribute<AccountModel, String> agencyCode;
	public static volatile ListAttribute<AccountModel, CardModel> cardModel;

	public static final String ACCOUNT_CODE = "accountCode";
	public static final String NAME_OWNER = "nameOwner";
	public static final String VERIFICATION_DIGITAL = "verificationDigital";
	public static final String REGISTER_ID = "registerId";
	public static final String ID = "id";
	public static final String AGENCY_CODE = "agencyCode";
	public static final String CARD_MODEL = "cardModel";

}

