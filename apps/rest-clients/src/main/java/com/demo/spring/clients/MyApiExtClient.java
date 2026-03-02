package com.demo.spring.clients;

import com.demo.spring.entity.EmpDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class MyApiExtClient implements CommandLineRunner {

    public MyApiExtClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

      ResponseEntity<String> responseEntity= restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",String.class);
        System.out.println(responseEntity.getBody());



    }
}
