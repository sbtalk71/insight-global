package com.demo.tests;

import com.demo.Counter;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CounterTest {

    Counter counter=new Counter();

    @Test
    public void testIncrement(){
        counter.increment();
        counter.increment();
        Assertions.assertEquals(2,counter.getCount());
    }

    @Test
    public void testDecrement(){
        counter.decrement();
        counter.decrement();
        Assertions.assertEquals(-2,counter.getCount());
    }
}
