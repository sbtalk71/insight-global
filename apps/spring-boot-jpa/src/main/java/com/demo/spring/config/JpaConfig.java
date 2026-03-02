package com.demo.spring.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef ="emf1",
        basePackages = "com.demo.spring.repositories",
        transactionManagerRef = "transactionManager1")
public class JpaConfig {

    @Bean(name="emf1")
    LocalContainerEntityManagerFactoryBean emf1(DataSource ds){
        LocalContainerEntityManagerFactoryBean lcfb=new LocalContainerEntityManagerFactoryBean();
        lcfb.setDataSource(ds);
        lcfb.setPackagesToScan("com.demo.spring.entity");
        lcfb.setPersistenceUnitName("my-unit");
        JpaVendorAdapter va= new HibernateJpaVendorAdapter();
        lcfb.setJpaVendorAdapter(va);
        return lcfb;
    }

    @Bean(name="transactionManager1")
    JpaTransactionManager transactionManager1(@Qualifier("emf1") EntityManagerFactory emf){
        JpaTransactionManager jpx=new JpaTransactionManager();
        jpx.setEntityManagerFactory(emf);
        return jpx;
    }
}
