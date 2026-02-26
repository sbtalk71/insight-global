package com.demo.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentService{
    @Override
    public String pay(double amount) {
        return "Payment of "+amount+" made using Credit card";
    }
}
