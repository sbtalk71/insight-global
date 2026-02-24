package com.demo.ex1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.offer("apple");
        queue.offer("guava");
        queue.offer("mango");
        queue.offer("pear");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
