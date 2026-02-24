package com.demo.inner.classes;

import java.util.function.Predicate;

public class Greeter {
    public static void main(String[] args) {
        Greet greet=new GoodMorning();
        System.out.println(greet.getGreet());


        Greet greet1= new Greet() {
            @Override
            public String getGreet() {
                return "Good Evening";
            }
        };

        Greet greet2= () -> "Good Evening";

        System.out.println(greet2.getGreet());

      new Thread( ()->{
            System.out.println("this is a thread");
          System.out.println(Thread.currentThread().getName());
        }).start();

        System.out.println("20 is even "+new MyPredicate().test(20));

        Predicate<Integer> evenCheck=(x)->x%2==0;

        System.out.println(evenCheck.test(90));
    }

}
