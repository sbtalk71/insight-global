package com.demo.spring;

import com.demo.spring.entity.Emp;
import com.demo.spring.repositories.EmpRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmpRepositoryTests {

    @Autowired
    EmpRepository empRepository;

    @Test
    void testFindAll(){
        List<Emp> empList=empRepository.findAll();
        Assertions.assertEquals(18,empList.size());
    }
}
