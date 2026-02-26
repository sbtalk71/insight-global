package com.demo.spring.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {


    private Engine engine;

    public Car() {
        System.out.println("Car Object created....");
    }

    public Engine getEngine() {

        return engine;
    }

   // @Autowired
   //@Qualifier("fiatEngine")
    public void setEngine(Engine engine) {
        System.out.println(engine.getClass().getSimpleName()+" is set to car..");
        this.engine = engine;
    }

    public void start(){
        this.engine.start();
    }
}
