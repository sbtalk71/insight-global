package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    //@Bean
    //@Profile("dev")
    DataSource dataSource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3307/training");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }
}
