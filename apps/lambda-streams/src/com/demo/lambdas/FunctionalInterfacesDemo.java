package com.demo.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {

        //odd number checking impl of Predicate

        //Supplier impl of returning "Hello World"


        //Comparator impl for two Strings s1 and s2


        // Consumer implementation for "Good Morning"

        Consumer<String> consumer=(String s1)-> System.out.println(s1);
        consumer.accept("Good Morning");

        //BiFUnction for adding 2 integers

        //Function for input "Hello" return "Hello There";

        Function<String,String> fun=(s1)->{return s1+" There";};
        System.out.println(fun.apply("hello"));

        //implement a thread using Lambda for Runnable to print 1 to 10 with 2 sec pause



        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });//.start();

        Function<String,Integer> intParser= (s1)->{
            Integer num=0;
            try{
                num=Integer.parseInt(s1);
                System.out.println(num.getClass().getName());
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            return num;
        };

        System.out.println(intParser.apply("55"));

        Function<String,Integer> intParser2= Integer::parseInt;

        System.out.println(intParser2.apply("78"));

        //method ref

        Consumer<String> consumer2=System.out::println;
        consumer.accept("Good Evening");

        MessagePrinter mp= new MessagePrinter();

        BiConsumer<String,String> consumer3= mp::printMessage;


        List<String> fruits=Arrays.asList("apple","orange","pear","banana","guava");
        fruits.forEach(System.out::println);

    }
}

class MessagePrinter{
    public void printMessage(String s1,String s2){
        System.out.println(s1+" "+s2);
    }
}
