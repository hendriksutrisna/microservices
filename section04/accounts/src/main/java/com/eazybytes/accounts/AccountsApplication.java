package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
	info = @Info(
		title = "Accounts microservice REST API Documentation",
		description = "EazyBank Accounts microservice REST API Documentation",
		version = "v1",
		contact = @Contact(
				name = "Hendrik Sutrisna",
				email = "sutrisnahendrik@gmail.com",
				url = "https://growthops.udemy.com/course/master-microservices-with-spring-docker-kubernetes"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://growthops.udemy.com/course/master-microservices-with-spring-docker-kubernetes"
		)
	),
	externalDocs = @ExternalDocumentation(
			description =  "EazyBank Accounts microservice REST API Documentation",
			url = "https://www.eazybytes.com/swagger-ui.html"
	)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
