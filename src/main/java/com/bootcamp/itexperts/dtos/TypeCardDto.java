package com.bootcamp.itexperts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TypeCardDto {
	
	@NotBlank(message = "Type Card mandatory, please fill this field")
	@Size(max = 50)
	private String name;

	public TypeCardDto() {
	}	

	public TypeCardDto(
			@NotBlank(message = "Name of card is mandatory, please fill this field") @Size(max = 50) String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
