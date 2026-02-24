package com.demo;

public class Counter {
    private int count=0;

    public Counter(){
        System.out.println("Counter Created");
    }
    public void increment(){
        count=count+1;
    }

    public void decrement(){
        count=count-1;
    }

    public int getCount(){
        return this.count;
    }

//    public void reset(){
//        this.count=0;
//    }

}
