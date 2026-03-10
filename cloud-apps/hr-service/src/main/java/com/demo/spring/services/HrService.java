package com.demo.spring.services;

import com.demo.spring.entity.EmpDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class HrService {

    private RestClient.Builder restClientBuilder;

    public HrService(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    @CircuitBreaker(name = "hr-service-cb",fallbackMethod = "handleFailure")
    public EmpDTO getEmDetails(Integer id){

      EmpDTO empDTO = restClientBuilder.build().get()
                .uri("http://emp-service/emp/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(EmpDTO.class);
        System.out.println("Load balancer : "+restClientBuilder.build().getClass().getName());
      return empDTO;
    }


    public EmpDTO handleFailure(Throwable e){
        throw new RuntimeException("Circuit Breaker:Service Unavailable");
    }
}
