package com.demo.spring.runners;

import com.demo.spring.entity.Emp;
import com.demo.spring.repositories.EmpRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaRunner2 implements CommandLineRunner {
    private EmpRepository empRepository;

    public JpaRunner2(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(empRepository.getClass().getName());

      Class<?> interfaces[] = empRepository.getClass().getInterfaces();
      for(int i=0;i<interfaces.length;i++){
          System.out.println(interfaces[i].getName());
      }

        List<Emp> empList=empRepository.findAll();
    }
}
