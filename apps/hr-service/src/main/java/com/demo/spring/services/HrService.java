package com.demo.spring.services;

import com.demo.spring.entity.EmpDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HrService {

    private RestClient.Builder restClientBuilder;

    public HrService(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public EmpDTO getEmDetails(Integer id){

      EmpDTO empDTO = restClientBuilder.build().get()
                .uri("http://emp-service/emp/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(EmpDTO.class);
        System.out.println("Load balancer : "+restClientBuilder.build().getClass().getName());
      return empDTO;
    }
}
