package com.demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(1,2,3,4,5,6,8,9,12,13,15,16,90,56,45,89);

        //add 10 to each even number and display the result

        nums.stream().filter(n->n%2==0).mapToInt(n->n+10).forEach(System.out::println);

        //find first

        System.out.println(nums.stream().filter(n->n%2!=0).findFirst().get());

        System.out.println(nums.stream().filter(n->n%2!=0).reduce((x,y)->y).get());

       List<Integer> evensList= nums.stream().filter(n->n%2==0).collect(Collectors.toList());




       //Flat Map

        List<List<Integer>> listOfList= Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));
        System.out.println(listOfList);

        listOfList.stream().flatMap(list->list.stream()).forEach(System.out::println);

        System.out.println(listOfList.stream().flatMap(list->list.stream()));







    }
}
