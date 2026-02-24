package com.learning.com.demo;

public class OverloadDemo {

    public void add(){
        System.out.println("Nothing added here");
    }

    public int add(int a, int b){
        System.out.println("int, int  add() called..");
        return a+b;
    }

    public float add(int a, float b){
        System.out.println("int, float  add() called..");
        return a+b;
    }

//    public double add(double a, double b){
//        System.out.println("double, double  add() called..");
//        return a+b;
//    }

    public static void main(String[] args) {
OverloadDemo o= new OverloadDemo();
o.add();
o.add(2,3);
o.add(2,3.0f);
//o.add(3.0,4.0);

    }
}
