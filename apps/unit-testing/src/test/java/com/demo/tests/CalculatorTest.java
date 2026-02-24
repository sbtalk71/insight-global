package com.demo.tests;


import com.demo.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    @Test
    @Disabled
    public void testForHelloWorld(){
        String message="Hello";
        Assertions.assertEquals("Hello",message);
    }

    Calculator cal= new Calculator();

    @Test
    @Disabled
    public void testAddMethodForSuccess(){

    int result=cal.add(2,8);

    Assertions.assertEquals(10,result);
    }


    @RepeatedTest(value = 4)
    @Disabled
    public void testSubtractForSuccess(){
        int result=cal.subtract(6,3);
        Assertions.assertEquals(3,result);
    }

}
