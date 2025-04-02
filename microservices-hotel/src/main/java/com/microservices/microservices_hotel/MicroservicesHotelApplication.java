package com.microservices.microservices_hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesHotelApplication.class, args);

		System.out.println("Hotel Microservice is running...");
	}

}
