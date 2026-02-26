package com.demo.spring.ex1;

public class Car {

    private Engine engine;

    public Car() {
        System.out.println("Car Object created....");
    }

    public Engine getEngine() {

        return engine;
    }

    public void setEngine(Engine engine) {
        System.out.println("Engine is set to car..");
        this.engine = engine;
    }

    public void start(){
        this.engine.start();
    }
}
