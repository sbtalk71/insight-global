package com.demo.inner.classes;

import java.util.function.Predicate;

@FunctionalInterface
public interface Greet {

    public String getGreet();
    //public String getGreet2();



}

class MyPredicate implements Predicate<Integer>{

    @Override
    public boolean test(Integer i) {
        return i%2==0;
    }
}
