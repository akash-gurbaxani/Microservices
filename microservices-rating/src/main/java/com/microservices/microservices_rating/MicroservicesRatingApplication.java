package com.microservices.microservices_rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesRatingApplication.class, args);
		
		System.out.println("Rating Service is Running....");
	}

}
