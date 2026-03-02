package com.demo.spring.clients;

import com.demo.spring.entity.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public class MyApiClient implements CommandLineRunner {
    private RestTemplate restTemplate;

    @Autowired
    private RestClient restClient;

    public MyApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @Override
    public void run(String... args) throws Exception {

        //getSingleEmp();
        //getAll();
       // postEmp();
        postEmpWithRestClient();

    }

    private void getSingleEmp() {
        ResponseEntity<String> responseEntity= restTemplate.getForEntity("http://localhost:8081/emp/100",String.class);
        System.out.println(responseEntity.getBody());

        ResponseEntity<EmpDTO> responseEntity1=restTemplate.getForEntity("http://localhost:8081/emp/100", EmpDTO.class);
        EmpDTO empDto=responseEntity1.getBody();

        System.out.println(empDto.getName()+" "+empDto.getSalary());
    }

    private void getAll(){
        ResponseEntity<List<EmpDTO>> empListEntity=restTemplate.exchange("http://localhost:8081/emp/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<EmpDTO>>() {});

        empListEntity.getBody().stream().forEach(e-> System.out.println(e.getName()+" "+e.getSalary()));
    }

    private void postEmp(){

        HttpHeaders headers=new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-TYpe",MediaType.APPLICATION_JSON_VALUE);

        EmpDTO empDTO=new EmpDTO(501,"Kokila","Mumbai",50000.0,20);
        HttpEntity<EmpDTO> requestData=new HttpEntity<>(empDTO,headers);

        ResponseEntity<EmpDTO> responseEntity=restTemplate.exchange("http://localhost:8081/emp/",
                HttpMethod.POST,requestData,EmpDTO.class);

        System.out.println(responseEntity.getBody());

    }

    public void postEmpWithRestClient(){
        EmpDTO empDTO=new EmpDTO(502,"Sanket","Mumbai",50000.0,20);

        ResponseEntity<EmpDTO> responseEntity=restClient.post()
                .uri("http://localhost:8081/emp/")
                .body(empDTO)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(EmpDTO.class);

        System.out.println(responseEntity.getBody());
    }

}
