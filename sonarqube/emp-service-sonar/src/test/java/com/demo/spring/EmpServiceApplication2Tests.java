package com.demo.spring;

import com.demo.spring.entity.Emp;
import com.demo.spring.services.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmpServiceApplication2Tests {

	@Value("${local.server.port}")
	private int port;

	@Autowired
	EmpService empService;







	@Test

	void testRestCallToOneEmpSuccess(){
		RestTestClient testClient= RestTestClient.bindToServer().baseUrl("http://localhost:"+this.port).build();;
		System.out.println("LOcal Server Port : "+port);
		EntityExchangeResult<Emp> result=testClient
				.get()
				.uri("/emp/100")
				.accept(MediaType.APPLICATION_JSON)
						.exchange()
								.expectBody(Emp.class).returnResult();

		Assertions.assertEquals("shantanu",result.getResponseBody().getName());
	}

}
