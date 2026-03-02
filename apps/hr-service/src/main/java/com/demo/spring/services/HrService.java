package com.demo.spring.services;

import com.demo.spring.entity.EmpDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HrService {

    private RestClient restClient;

    public HrService(RestClient restClient) {
        this.restClient = restClient;
    }

    public EmpDTO getEmDetails(Integer id){

      EmpDTO empDTO =  restClient.get()
                .uri("http://localhost:8081/emp/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(EmpDTO.class);
      return empDTO;
    }
}
