package com.bootcamp.itexperts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String ACCOUNT_TAG = "Accounts";
	public static final String CARD_TAG = "Cards";
	public static final String TYPE_CARD_TAG = "Type Cards";
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bootcamp.itexperts"))
				.paths(PathSelectors.any())
				.build()
				.tags(new Tag(ACCOUNT_TAG, "Manage Accounts"))
				.tags(new Tag(CARD_TAG, "Manage Cards"))
				.tags(new Tag(TYPE_CARD_TAG, "Manage Type Cards"))
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				.title("Bank Account Api")
				.description("This Api create a bank account with cards associated")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
				.contact(new Contact("Anderson Costa","https://github.com/anderson-cst","andersonleandrocosta@hotmail.com"))
				.build();				
	}	
}
