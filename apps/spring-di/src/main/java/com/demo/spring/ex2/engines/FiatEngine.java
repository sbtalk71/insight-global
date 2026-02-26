package com.demo.spring.ex2.engines;

import com.demo.spring.ex2.Engine;
import org.springframework.stereotype.Component;


public class FiatEngine implements Engine {
    public FiatEngine() {
        System.out.println("Fiat Engine Object created....");
    }

    public void start() {
        System.out.println("Engine started...");
    }

    public void stop() {
        System.out.println("Engine stopped...");
    }
}
