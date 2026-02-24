package com.demo.threads;

public class SynchMain {
    public static void main(String[] args) throws Exception{

        TableGenerator tableGenerator=new TableGenerator();

        Thread t1= new Thread(new TableWorker(tableGenerator,4));
        Thread t2= new Thread(new TableWorker(tableGenerator,5));
        Thread t3= new Thread(new TableWorker(tableGenerator,7));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
