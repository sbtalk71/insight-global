package com.demo.spring.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");

        Car car=(Car)context.getBean("mycar");

        car.start();
    }
}
