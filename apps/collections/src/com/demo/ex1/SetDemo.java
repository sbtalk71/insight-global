package com.demo.ex1;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
       // Set<String> fruitsList=new HashSet<>();
        Set<String> fruitsList=new TreeSet<>();

        fruitsList.add("apple");
        fruitsList.add("mango");
        fruitsList.add("guava");
        fruitsList.add("pear");

        System.out.println(fruitsList);

       fruitsList.add("apple");

        Iterator<String> itr=fruitsList.iterator();
       // System.out.println(itr.getClass().getName());

        while(itr.hasNext()){
            String fruit=itr.next();
            System.out.println(fruit.toUpperCase());
        }

        for(String fruit:fruitsList){
            System.out.println(fruit.toUpperCase());
        }

    }
}
