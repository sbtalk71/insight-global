package com.demo.spring.exceptions;

public class EmpResourceException extends RuntimeException{
    public EmpResourceException() {
    }

    public EmpResourceException(String message) {
        super(message);
    }
}
