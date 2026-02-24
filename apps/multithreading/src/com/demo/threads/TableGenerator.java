package com.demo.threads;

public class TableGenerator {

    public synchronized void printTable(int num) {
        try {
            for (int i = 1; i < 11; i++) {
                Thread.sleep(2000);
                System.out.println(num + " X " + i + " = " + (num * i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
