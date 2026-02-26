package com.demo.spring.ex2;

import com.demo.spring.ex2.engines.FiatEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.demo.spring.ex2")
public class AppConfig {

    @Bean
    public Engine fiatEngine(){
        return new FiatEngine();
    }

}
