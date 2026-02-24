package com.demo.ex1;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        //List<String> fruitsList=new ArrayList<>();
        //List<String> fruitsList=new LinkedList<>();
        List<String> fruitsList=new Vector<>();

        fruitsList.add("apple");
        fruitsList.add("mango");
        fruitsList.add("guava");
        fruitsList.add("pear");

        System.out.println(fruitsList);

        System.out.println(fruitsList.get(2));
        fruitsList.add(2,"avocado");
        fruitsList.add("apple");

        System.out.println(fruitsList);

        Iterator<String> itr=fruitsList.iterator();
       // System.out.println(itr.getClass().getName());

        while(itr.hasNext()){
            String fruit=itr.next();
            System.out.println(fruit.toUpperCase());
        }

        for(String fruit:fruitsList){
            System.out.println(fruit.toUpperCase());
        }

        Collections.sort(fruitsList);
        System.out.println(fruitsList);

    }
}
