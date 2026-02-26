package com.demo.spring.ex2.engines;

import com.demo.spring.ex2.Engine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FerrariEngine implements Engine {
    public FerrariEngine() {
        System.out.println("Ferrari Engine Object created....");
    }

    public void start() {
        System.out.println("Engine started...");
    }

    public void stop() {
        System.out.println("Engine stopped...");
    }
}
