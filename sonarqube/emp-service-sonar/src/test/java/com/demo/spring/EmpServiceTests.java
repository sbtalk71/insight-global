package com.demo.spring;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repositories.EmpRepository;
import com.demo.spring.services.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
 class EmpServiceTests {

    @MockitoBean
    EmpRepository empRepository;

    @Autowired
    EmpService empService;

    @Test
    void testEmpServiceForOneEmp(){
        when(empRepository.findById(100)).thenReturn(Optional.of(new Emp(100,"a","b",56000.0,20)));

        Emp emp=empService.getOneEmp(100);
        Assertions.assertEquals("a",emp.getName());
        Assertions.assertEquals(20,emp.getDeptNo());

    }

    @Test
    void testEmpServiceForOneEmpNotFound(){
        when(empRepository.findById(100)).thenThrow(new EmpNotFoundException());


        Assertions.assertThrows(EmpNotFoundException.class, ()->empService.getOneEmp(100));

    }
}
