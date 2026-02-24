package com.learning.com.demo;

import java.lang.reflect.Method;

public class DuckMain {
    public static void main(String[] args) throws Exception{
        Class.forName("com.learning.com.demo.Duck");
        /*Duck d1=new Duck();
        Duck d2=new Duck();
        Duck d3=new Duck();
        Duck d4=new Duck();*/
        Duck d5=new Duck();

        System.out.println(d5.getClass().getMethods().length);
        for(Method m:d5.getClass().getMethods()){
            System.out.println(m.getName());
        }
        System.out.println("No of ducks : "+Duck.duckCount);
    }
}
