package com.demo.ex1;

import java.util.*;

public class SortedMapDemo {
    public static void main(String[] args) {

       TreeMap<String, String> fruitsMap=new TreeMap<>(new KeySorter());
       // Map<String,String> fruitsMap=new HashMap<>();
        fruitsMap.put("one","apple");
        fruitsMap.put("two","avocado");
        fruitsMap.put("four","mango");
        fruitsMap.put("five","orange");
        fruitsMap.put("six","pear");
        fruitsMap.put("three","guava");
        System.out.println(fruitsMap);
    }
}
class KeySorter implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}