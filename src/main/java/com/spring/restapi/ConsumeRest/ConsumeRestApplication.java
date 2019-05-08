package com.spring.restapi.ConsumeRest;

import com.spring.restapi.ConsumeRest.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumeRestApplication {

	@Autowired
	PhonebookService service;

	public static void main(String[] args) {

		SpringApplication.run(ConsumeRestApplication.class, args);


	}

}
