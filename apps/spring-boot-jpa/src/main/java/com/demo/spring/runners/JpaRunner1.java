package com.demo.spring.runners;

import com.demo.spring.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class JpaRunner1 implements CommandLineRunner {
    private EntityManager entityManager;

    public JpaRunner1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) throws Exception {

        Query query=entityManager.createQuery("select e from Emp e");
        List<Emp> empList=query.getResultList();
        empList.stream().forEach(emp-> System.out.println(emp.getName()+" "+ emp.getSalary()));
    }
}
