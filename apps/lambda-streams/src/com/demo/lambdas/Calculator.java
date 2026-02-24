package com.demo.lambdas;

@FunctionalInterface
public interface Calculator {

    public int calculate(int a, int b);
}

interface Concat{
    public String doConcat(String s1, String s2);
}
