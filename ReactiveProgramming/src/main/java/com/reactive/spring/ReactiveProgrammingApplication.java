package com.reactive.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebFlux
@SpringBootApplication
@EnableReactiveMongoRepositories
//@EnableSwagger2//use postman
public class ReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}

}
