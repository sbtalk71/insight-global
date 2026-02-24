package com.demo.threads;

public class MyThreadMain {
    public static void main(String[] args) throws Exception{

        System.out.println(Thread.currentThread().getName()+" starts");
        Thread.currentThread().setPriority(7);
        MyThread t1= new MyThread();
        MyThread t2= new MyThread();
        MyThread t3= new MyThread();
       System.out.println(t1);
       t1.start();
       t2.start();
       t3.start();

       // System.out.println(t1.getId()+" "+t1.getName()+" "+t1.getPriority()+" "+t1.getThreadGroup());

        t1.join();
        t2.join();
        t3.join();
        System.out.println(Thread.currentThread().getName()+" exits");
    }
}
