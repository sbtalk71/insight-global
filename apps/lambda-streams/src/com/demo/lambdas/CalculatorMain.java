package com.demo.lambdas;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator adder=(a,b)->a+b;
        Calculator subtratc=(a,b)->a-b;
        Calculator multiply=(a,b)->a*b;
        Calculator divide=(a,b)->a/b;

        Concat concat=String::concat;

        System.out.println(concat.doConcat("Shantanu","Banerjee"));
    }
}
