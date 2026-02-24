package com.demo.inner.classes;

public class InnerClassDemo {
    public static void main(String[] args) {

        Outer.NotInner ni=new Outer.NotInner();

        Outer outer= new Outer();
        Outer.Inner1 inner= outer.new Inner1();

        inner.innerFun();

        ni.nestedFun();
    }
}
