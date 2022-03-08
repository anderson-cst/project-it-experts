package com.bootcamp.itexperts.enums;

public enum Flag {

	MASTERCARD("Mastercard"),
	VISA("Visa"),
	ELO("Elo");
	
	private final String flagPorExtenso;

	private Flag(String flagPorExtenso) {
		this.flagPorExtenso = flagPorExtenso;
	}

	public String getFlagPorExtenso() {
		return flagPorExtenso;
	}
}
