package com.demo.spring.ex2;

import com.demo.spring.ex2.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIMainEx2 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("context-ex2.xml");

        Car car=(Car)context.getBean("mycar");

        car.start();
    }
}
