package com.demo.ex1;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

       // Map<Integer, String> fruitsMap=new HashMap<>();
        Map<Integer, String> fruitsMap=new Hashtable<>();
        fruitsMap.put(1,"apple");
        fruitsMap.put(2,"mango");
        fruitsMap.put(3,"orange");
        fruitsMap.put(4,"pear");
        fruitsMap.put(5,"avocado");
        fruitsMap.put(6,"guava");

        System.out.println(fruitsMap);

        System.out.println(fruitsMap.get(5));

       Set<Integer> keys= fruitsMap.keySet();

       //key based processing
       for(Integer key:keys){
           System.out.println(key+" -----> "+fruitsMap.get(key));
       }

        System.out.println("----------------------------------------");
       //value based processing
        Collection<String> fruits=fruitsMap.values();

       for(String fruit:fruits){
           System.out.println(fruit);
       }

        System.out.println("----------------------------------------");
       //Entry Based Processing

        Set<Map.Entry<Integer, String>> entrySet=fruitsMap.entrySet();

       for(Map.Entry<Integer,String> entry:entrySet){
           System.out.println(entry.getKey()+" -----> "+entry.getValue());
       }
        System.out.println("----------------------------------------");
    }
}
