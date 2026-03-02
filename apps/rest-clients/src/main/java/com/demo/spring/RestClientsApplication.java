package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientsApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	RestClient restClient(){
		return RestClient.builder().build();
	}
}
