package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication

public class HrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}

	@Bean
	RestClient.Builder restClient(){
		return RestClient.builder();
	}
}
