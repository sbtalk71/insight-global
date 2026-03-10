package com.demo.spring.exceptions;

public class EmpNotFoundException extends EmpResourceException{
    public EmpNotFoundException() {
    }

    public EmpNotFoundException(String message) {
        super(message);
    }
}
