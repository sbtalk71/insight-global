package com.demo.spring;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.demo.spring.controllers.EmpRestController;
import com.demo.spring.entity.Emp;
import com.demo.spring.services.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.EntityExchangeResult;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmpServiceApplicationTests {

	@Autowired
	MockMvc mvc;

	@LocalServerPort
	private int port;

	@MockitoBean
	EmpService empService;



	RestTestClient testClient= RestTestClient.bindToServer().baseUrl("http://localhost:"+this.port).build();;

	@Test
	 void testGetOneEmpSuccess() throws Exception{

		when(empService.getOneEmp(100)).thenReturn(new Emp(100,"Tiger","Jungle",56000.0,10));
		mvc.perform(get("/emp/100"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("Tiger"));

	}

	@Test
	void testGetFindAllEmpSuccess() throws Exception{

		List<Emp> empList=new ArrayList<>();
		empList.add(new Emp(1,"a","b",100.0,20));
		empList.add(new Emp(2,"c","d",100.0,20));
		when(empService.getAllEmps()).thenReturn(empList);

		mvc.perform(get("/emp/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(2));

	}

	@Test
	void testRestCallToOneEmpSuccess(){

		EntityExchangeResult<Emp> result=testClient
				.get()
				.uri("/emp/100")
				.accept(MediaType.APPLICATION_JSON)
						.exchange()
								.expectBody(Emp.class).returnResult();

		Assertions.assertEquals("shantanu",result.getResponseBody().getName());
	}

}
