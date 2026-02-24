package com.demo.inner.classes;

public class Outer {

    private void outerFun(){
        System.out.println("Outer class function");

    }
    public class Inner1{
        public void innerFun(){
            System.out.println("Inner fun...");
            outerFun();
        }
    }

    public static class NotInner{

        public void nestedFun(){
            System.out.println("nested class function..");

        }
    }
}
