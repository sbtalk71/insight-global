package com.learning.com.demo;

public class Duck {
    public static int duckCount;

    public Duck(){
        duckCount++;
    }

    static {
        System.out.println("Static block initialized..");
    }

    public static void statFun(){
        System.out.println();
        //fun();
    }

    public void fun(){
        statFun();
    }
}
