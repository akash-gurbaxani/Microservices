package com.microservices.microservices_ServerRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicesServerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesServerRegistryApplication.class, args);
		System.out.println("Server Registry is running...");
	}

}
