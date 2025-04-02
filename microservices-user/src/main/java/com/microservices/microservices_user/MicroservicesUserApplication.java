package com.microservices.microservices_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUserApplication.class, args);

		System.out.println("Microservices User Application Running...");
	}

}
