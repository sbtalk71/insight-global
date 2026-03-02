package com.demo.spring.repositories;

import com.demo.spring.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface EmpRepository extends JpaRepository<Emp,Integer> {

}
