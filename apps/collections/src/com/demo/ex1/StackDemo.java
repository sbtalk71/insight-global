package com.demo.ex1;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> mystatck=new Stack<>();
        mystatck.push("apple");
        mystatck.push("mango");
        mystatck.push("pear");

        System.out.println(mystatck.search("apple"));

        System.out.println(mystatck);

        System.out.println(mystatck.peek());
        System.out.println(mystatck.pop());
    }
}
