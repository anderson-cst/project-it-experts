package com.bootcamp.itexperts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//itexperts.src.main.java.com.bootcamp.itexperts.repositories
@EnableJpaRepositories(basePackages = "com.bootcamp.itexperts.repositories")
@SpringBootApplication
public class ItexpertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItexpertsApplication.class, args);	
	}

}
