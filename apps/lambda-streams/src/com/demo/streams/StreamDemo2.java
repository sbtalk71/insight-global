package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(1,2,1,3,4,5,5,6,8,9,12,1,2,12,13,15,16,90,5,56,45,89);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

      int sum=  nums.stream().peek(System.out::println).mapToInt(n->n+10).peek(System.out::println).reduce((a,b)->a+b).getAsInt();
        System.out.println(sum);

    }
}
