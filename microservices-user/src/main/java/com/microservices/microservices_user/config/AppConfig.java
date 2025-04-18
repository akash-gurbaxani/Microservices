package com.microservices.microservices_user.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Configurable
public class AppConfig {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
        }

}
