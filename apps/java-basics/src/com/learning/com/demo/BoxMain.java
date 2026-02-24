package com.learning.com.demo;

public class BoxMain {
    public static void main(String[] args) {
    Box box1=new Box(10,10,20);
    //box1.length=20;
        System.out.println("Volume : "+box1.getVolume());

        Box box2=new Box(10,10,20,"green");
    }
}
